package cn.vpclub.demo.service;

import cn.vpclub.demo.domain.entity.SysUserTokenEntity;

import cn.vpclub.moses.core.model.response.BaseResponse;
import com.baomidou.mybatisplus.service.IService;


/**
 * 用户Token
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	BaseResponse createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	BaseResponse logout(long userId);

}
