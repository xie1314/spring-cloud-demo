package cn.vpclub.demo.web;


import cn.vpclub.demo.common.utils.RedisUtils;
import cn.vpclub.demo.domain.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller公共组件
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 * @date 2018年4月25日 guowangcheng 添加分表，pageData方法
 */
public abstract class AbstractController {

	@Autowired
	private RedisUtils redis;


	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected SysUserEntity getUser() {
		HttpServletRequest request = getRequest();
		String token = request.getHeader("token");
		SysUserEntity userEntity =  redis.get(token,SysUserEntity.class);
		return userEntity;
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}


	/**得到request对象
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
}
