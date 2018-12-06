package cn.vpclub.demo.model.response;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共返回类
 * Created by guowangcheng on 2017/12/22.
 */
public class Result<T>  extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result success() {
        return new Result();
    }


    public static Result unauthorized() {
        return unauthorized(HttpStatus.SC_UNAUTHORIZED, "您没有访问该接口的权限！");
    }

    public static Result unauthorized(String msg) {
        return unauthorized(HttpStatus.SC_UNAUTHORIZED, msg);
    }

    public static Result unauthorized(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    public static String fillResultString(int code, String msg, Object data) {
        Result r=new Result();
        r.put("code",code);
        r.put("msg",msg);
        r.put("data",data);
        return JSON.toJSONString(r);
    }


    public static enum Code{
        SUCCESS(0,"success"),
        OK(200,"ok"),
        NOAUTH(401,"noauth"),
        UNAUTHORIZED(1001,"unauthorized"),
        NONEXISTENCE(1002,"nonexistence"),
        TYPEERROR(1003,"type.error"),
        SERVERERROR(1004,"server.error"),
        FAILED(1005,"failed"),
        NOPARAMETER(1006,"parameters.missing"),
        TIMEOUT(1007,"timeout"),
        DUPLICATE(1008,"already.exists"),
        NOSESSION(1009,"session.expired"),
        AUTHFAILED(1009,"authfailed");

        // 成员变量
        private int value;
        private int code;//状态码
        private String msg;//信息
        // 构造方法
        private Code(int code) {
            this.code = code;
        }
        private Code(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
        public String getMsg() {
            return this.msg;
        }
        public int getCode() {
            return this.code;
        }
    }

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private int code;//状态码

    private String msg;//信息

    private T data;//数据

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
