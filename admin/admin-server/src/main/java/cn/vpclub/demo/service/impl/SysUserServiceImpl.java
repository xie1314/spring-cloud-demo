package cn.vpclub.demo.service.impl;

import cn.vpclub.demo.common.utils.Query;
import cn.vpclub.demo.domain.entity.SysUserEntity;
import cn.vpclub.demo.model.request.PageDataParam;
import cn.vpclub.demo.dao.SysUserDao;

import cn.vpclub.demo.model.request.SysLogParam;
import cn.vpclub.demo.model.request.SysUserParam;

import cn.vpclub.demo.model.response.PageUtils;
import cn.vpclub.demo.service.SysRoleService;
import cn.vpclub.demo.service.SysUserRoleService;
import cn.vpclub.demo.service.SysUserService;
import cn.vpclub.demo.utils.Constant;
import cn.vpclub.moses.core.enums.ReturnCodeEnum;
import cn.vpclub.moses.core.model.response.BackResponseUtil;
import cn.vpclub.moses.core.model.response.PageResponse;
import cn.vpclub.moses.utils.common.StringUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleService sysRoleService;

	@Override
	public PageResponse queryPage(SysUserParam params) {
		PageResponse pageResponse = BackResponseUtil.getPageResponse(ReturnCodeEnum.CODE_1000.getCode());
		Page<SysUserEntity> page = new Page<SysUserEntity>();
		if (StringUtil.isNotEmpty(params)){
			page.setCurrent(params.getPageNumber());
			page.setSize(params.getPageSize());
		}
		EntityWrapper<SysUserEntity> ew = new EntityWrapper<>();
		ew.like(StringUtil.isNotEmpty(params.getUsername()), "username", params.getUsername());
//		ew.eq(StringUtil.isNotEmpty(params.getMobile()),"mobile",params.getMobile());
		Page<SysUserEntity> selectPage = this.selectPage(page, ew);
		BeanUtils.copyProperties(selectPage, pageResponse);
		return pageResponse;
	}

	@Override
	public List<String> queryAllPerms(Long userId) {
		return baseMapper.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	public SysUserEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}

    @Override
	public void save(SysUserEntity user) {
		Long nowTime = System.currentTimeMillis();
		user.setCreatedTime(nowTime);
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
		user.setSalt(salt);
		this.insert((SysUserEntity) user);

		//检查角色是否越权
		checkRole((SysUserEntity) user);

		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional
	public void update(SysUserEntity user) {
		/*if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
		}*/
		this.updateById((SysUserEntity) user);

		/*//检查角色是否越权
		checkRole(user);

		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());*/
	}

	@Override
	public void deleteBatch(Long[] userId) {
		this.deleteBatchIds(Arrays.asList(userId));
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		SysUserEntity userEntity = new SysUserEntity();
		userEntity.setPassword(newPassword);
		return this.update(userEntity,
				new EntityWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUserEntity user){
		if(user.getRoleIdList() == null || user.getRoleIdList().size() == 0){
			return;
		}
		//如果不是超级管理员，则需要判断用户的角色是否自己创建
		if(user.getCreateUserId() == Constant.SUPER_ADMIN){
			return ;
		}

		//查询用户创建的角色列表
		List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());

		//判断是否越权
		if(!roleIdList.containsAll(user.getRoleIdList())){
			log.error("新增用户所选角色，不是本人创建");
		}
	}

	@Override
	public void deleteByUserId(List<Long> ids) {
		baseMapper.deleteByUserIds(ids);
	}

	@Override
	public void register(SysUserEntity registerUser) {
		baseMapper.addUser((SysUserEntity) registerUser);
	}

	@Override
	public List<SysUserEntity> queryByParentId(String parentId) {
		return baseMapper.queryByParentId(parentId);
	}

    @Override
	public SysUserEntity queryByPhone(SysUserEntity mobileuser) {
		EntityWrapper<SysUserEntity> condition = new EntityWrapper<SysUserEntity>((SysUserEntity) mobileuser);
		SysUserEntity user = this.selectOne(condition);
		return user;
	}
}
