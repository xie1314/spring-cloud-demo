package cn.vpclub.demo.service.impl;



import cn.vpclub.demo.dao.SysRoleDao;
import cn.vpclub.demo.domain.entity.SysRoleEntity;
import cn.vpclub.demo.model.request.SysRoleParam;
import cn.vpclub.demo.service.SysRoleMenuService;
import cn.vpclub.demo.service.SysRoleService;
import cn.vpclub.demo.service.SysUserRoleService;
import cn.vpclub.demo.service.SysUserService;
import cn.vpclub.demo.utils.Constant;
import cn.vpclub.moses.core.enums.ReturnCodeEnum;
import cn.vpclub.moses.core.model.response.BackResponseUtil;
import cn.vpclub.moses.core.model.response.PageResponse;
import cn.vpclub.moses.utils.common.JsonUtil;
import cn.vpclub.moses.utils.common.StringUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 系统角色 服务实现类
 *
 * @author yk
 * @since 2018-06-01
 */

@Slf4j
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {


	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	@Autowired
	private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

	@Override
	public PageResponse queryPage(SysRoleParam params) {
		log.info("系统角色列表分页 request: {}", JsonUtil.objectToJson(params));
		PageResponse pageResponse = BackResponseUtil.getPageResponse(ReturnCodeEnum.CODE_1000.getCode());
		Page<SysRoleEntity> page= new Page<>();
		if(StringUtil.isNotEmpty(params)){
			page.setCurrent(params.getPageNumber());
			page.setSize(params.getPageSize());
		}

//		String roleName = params.getRoleName();
//		Long createUserId = params.getCreateUserId();

		EntityWrapper<SysRoleEntity> ew = new EntityWrapper<>();
		ew.like(StringUtil.isNotEmpty(params.getRoleName()),"role_name",params.getRoleName()).eq(StringUtil.isNotEmpty(params.getRoleId()),"create_user_id",params.getRoleId());
		Page<SysRoleEntity> selectPage=this.selectPage(page,ew);

//		Page<SysRoleEntity> page = this.selectPage(
//			new Query<SysRoleEntity>(params).getPage(),
//			new EntityWrapper<SysRoleEntity>().like(StringUtils.isNotBlank(roleName),"role_name", roleName)
//				.eq(createUserId != null,"create_user_id", createUserId)
//		);

		BeanUtils.copyProperties(selectPage,pageResponse);
		return pageResponse;
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleEntity role) {
        role.setUpdatedTime(System.currentTimeMillis());
        this.insert(role);

        //检查权限是否越权
        checkPrems(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList(),role.getCreatedBy(),role.getUpdatedBy(),role.getCreatedTime(),role.getUpdatedTime());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {
        this.updateById(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList(),role.getCreatedBy(),role.getUpdatedBy(),role.getCreatedTime(),role.getUpdatedTime());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
        //删除角色
        this.deleteBatchIds(Arrays.asList(roleIds));

        //删除角色与菜单关联
        sysRoleMenuService.deleteBatch(roleIds);

        //删除角色与用户关联
        sysUserRoleService.deleteBatch(roleIds);
    }


    @Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return baseMapper.queryRoleIdList(createUserId);
	}

	/**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRoleEntity role){
		//如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if(role.getRoleId() == Constant.SUPER_ADMIN){
			return ;
		}

		//查询用户所拥有的菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(role.getRoleId());

		//判断是否越权
		if(!menuIdList.containsAll(role.getMenuIdList())){
			log.error("新增角色的权限，已超出你的权限范围");
			return;
		}
	}

}