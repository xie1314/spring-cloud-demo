package cn.vpclub.demo.service;



import cn.vpclub.demo.domain.entity.SysRoleEntity;
import cn.vpclub.demo.model.request.SysRoleParam;
import cn.vpclub.moses.core.model.response.PageResponse;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统角色 服务类
 * </p>
 * 
 * @author yk
 * @since  2018-06-01
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageResponse queryPage(SysRoleParam params);

	void save(SysRoleEntity role);

	void update(SysRoleEntity role);

	void deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createdBy);
}
