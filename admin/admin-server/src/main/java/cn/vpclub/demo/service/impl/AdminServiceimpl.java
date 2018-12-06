package cn.vpclub.demo.service.impl;

import cn.vpclub.demo.common.utils.ReturnCode;
import cn.vpclub.demo.dao.AdminMapper;
import cn.vpclub.demo.domain.entity.Admin;

import cn.vpclub.demo.request.AdminId;
import cn.vpclub.demo.request.AdminListRequset;
import cn.vpclub.demo.request.AdminListid;
import cn.vpclub.demo.request.AdminPageParam;
import cn.vpclub.demo.service.AdminService;

import cn.vpclub.moses.core.model.response.BackResponseUtil;
import cn.vpclub.moses.core.model.response.BaseResponse;
import cn.vpclub.moses.core.model.response.PageResponse;
import cn.vpclub.moses.core.model.response.ResponseConvert;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

//2.1.3后台用户管理
@Slf4j
@Service
public class AdminServiceimpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

   public AdminServiceimpl() {
   }

   public AdminServiceimpl(AdminMapper baseMapper) {
       this.baseMapper = baseMapper;
   }

   public BaseResponse add(AdminListRequset model) {
        BaseResponse baseResponse;
      if(CollectionUtils.isNotEmpty(model.getAdminList())){
          boolean batch = this.insertBatch(model.getAdminList());
          baseResponse= ResponseConvert.convert(batch);
      }else {
          baseResponse= BackResponseUtil.getBaseResponse(ReturnCode.CODE_1006.getCode());
      }
      return baseResponse;
    }

    public BaseResponse query(Admin model) {
        BaseResponse baseResponse;
        Admin query = this.baseMapper.query(model);
        if(null !=query){
            baseResponse= BackResponseUtil.getBaseResponse(ReturnCode.CODE_1000.getCode());
            baseResponse.setDataInfo(query);
        }else {
            baseResponse= BackResponseUtil.getBaseResponse(ReturnCode.CODE_1005.getCode());
        }
        return baseResponse;
    }

    @Override
    public BaseResponse deleteBatch(AdminId model) {
        BaseResponse baseResponse;
        if(StringUtils.isNotEmpty(model.getId())){
            log.info("id"+model.getId());
            EntityWrapper en = new EntityWrapper();
            en.in("id",model.getId());
            boolean batch = this.delete(en);
            baseResponse= ResponseConvert.convert(batch);
            log.info("Response"+baseResponse);
        }else {
            baseResponse= BackResponseUtil.getBaseResponse(ReturnCode.CODE_1006.getCode());
        }
        return baseResponse;
 }

    @Override
    public BaseResponse delete(AdminListid model) {
        BaseResponse baseResponse;
        if(CollectionUtils.isNotEmpty(model.getId())){
          boolean batch = this.deleteBatchIds(model.getId());
            baseResponse= ResponseConvert.convert(batch);
        }else {
             baseResponse= BackResponseUtil.getBaseResponse(ReturnCode.CODE_1005.getCode());
        }
        return baseResponse;
    }

    //2.1.3后台用户管理 分页查询
    @Override
    public Page page(AdminPageParam pageParam) {
        Page<Admin> page = new Page<Admin>();
        Page<Admin> pageResponse = null;
        EntityWrapper<Admin> en = new EntityWrapper<Admin>();
        PageResponse<Admin> pageResponse1 = new PageResponse<Admin>();
       if (pageParam != null && pageParam.getPageNumber() != null && pageParam.getPageSize() != null) {
            page.setSize(pageParam.getPageSize());
            page.setCurrent(pageParam.getPageNumber());
            pageResponse = this.selectPage(page, en);
           BeanUtils.copyProperties(pageResponse,pageResponse1);
        } else {
            List<Admin> selectList = this.selectList(en);
            pageResponse = new Page<>();
            pageResponse.setRecords(selectList);
        }
        pageResponse.setTotal(this.selectCount(en));
        return pageResponse;
    }
}
