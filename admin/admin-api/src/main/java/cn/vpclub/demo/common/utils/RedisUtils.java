package cn.vpclub.demo.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-17 21:12
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations; //  ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
    @Autowired
    private HashOperations<String, String, Object> hashOperations;// HashOperations<String, Object, Object> stringObjectObjectHashOperations = redisTemplate.opsForHash();
    @Autowired
    private ListOperations<String, Object> listOperations; //  ListOperations<String, Object> stringObjectListOperations = redisTemplate.opsForList();
    @Autowired
    private SetOperations<String, Object> setOperations; // SetOperations<String, Object> stringObjectSetOperations = redisTemplate.opsForSet();
    @Autowired
    private ZSetOperations<String, Object> zSetOperations;// ZSetOperations<String, Object> stringObjectZSetOperations = redisTemplate.opsForZSet();
    /**  默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1;


    public void set(String key, Object value, long expire){
        valueOperations.set(key, toJson(value));
        if(expire != NOT_EXPIRE){
          redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object){
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }
}
/**　hash的操作方法

 （1）：获得hash数据类型的模板

 　　　//获得redis缓存HASH数据类型（散列）
 HashOperations opsForHash = redisTemplate.opsForHash();

 （2）：通过 会员id 和 商品 id 得到商品信息

 　　  //判断该用户（的商品）在缓存中有没有该数据     hkey需为string类型
 Order cacheOrder = (Order) opsForHash.get(order.getMemberId() + "", order.getGoodsId());

 （3）：存入信息 ，

 　　//根据会员ID 以及  商品 ID 将数据存入缓存中 【opsForHash.put(key, hashKey, value);】value为object类型
 opsForHash.put(order.getMemberId() + "", order.getGoodsId(), goodsOrder);

 （4）：修改商品库存(修改的原则是先对 value 数值进行修改  在将修改后的数值存入缓存中  会覆盖原来的缓存信息 )

 　　//判断该用户（的商品）在缓存中有没有该数据       【先修改数值】
 Order cacheOrder = (Order) opsForHash.get(order.getMemberId() + "", order.getGoodsId());

 　　//更新修改后的缓存数据
 opsForHash.put(order.getMemberId() + "", order.getGoodsId(), cacheOrder);

 （5）：删除缓存数据  【不过一般不会直接删除，只会做逻辑删除】

 　　opsForHash.delete(key, hashKeys);



 简单演示一下list的几种方法：

 （1）：获得list数类型

 　　//获得redis缓存list数据类型
 ListOperations opsForList = redisTemplate.opsForList();

 （2）：根据键名获得长度

 　　Long size = opsForList.size(order.getMemberId() + "");

 （3）：添加信息

 　　　//将购物信息添加到缓存中 rightPush 依次有右边添加  leftPush依次由左边添加
 opsForList.rightPush(order.getMemberId() +"" ,cacheOrder);

 （4）：获得list集合 【 0 ，-1 代表所有值】

 　　　　//获得所有当前可以的所有信息
 List<Order> range = opsForList.range(order.getMemberId() +"”, 0, -1);



 llist数据类型适合于消息队列的场景:比如12306并发量太高，而同一时间段内只能处理指定数量的订单！必须满足先进先出的原则，其余订单处于等待





 redis事务  ：原子性，即 要不全部成功 要不全部失败

 redis持久化 ：rdb           aof

 RDB方式:

 RDB持久化默认生成的文件名为dump.rdb

 Redis.conf中可以配置，默认配置如下：【默认是开启RDB方式的】

 save 900 1
 save 300 10
 save 60 10000

 以上表示的意思是，【 满足任一条件 ， 都会进行持久化 】

 900秒之内对服务进行了至少一次修改

 300秒之内服务器进行了至少10次修改

 60秒之内对服务器进行了至少10000次修改。

 AOF方式：

 appendonly yes              #启用aof持久化方式
 # appendfsync always     #每次收到写命令就立即强制写入磁盘，最慢的，但是保证完全的持久化，不推荐使用
 appendfsync everysec     #每秒钟强制写入磁盘一次，在性能和持久化方面做了很好的折中，推荐
 # appendfsync no          #完全依赖os，性能最好,持久化没保证
 *
 */
