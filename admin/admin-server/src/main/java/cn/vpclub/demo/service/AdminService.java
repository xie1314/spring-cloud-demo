package cn.vpclub.demo.service;


import cn.vpclub.demo.domain.entity.Admin;

import cn.vpclub.demo.request.AdminId;
import cn.vpclub.demo.request.AdminListRequset;
import cn.vpclub.demo.request.AdminListid;
import cn.vpclub.demo.request.AdminPageParam;
import cn.vpclub.moses.core.model.response.BaseResponse;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;


public interface AdminService extends IService<Admin> {
    public BaseResponse query(Admin model);
    public BaseResponse add(AdminListRequset model);
    public BaseResponse deleteBatch(AdminId model);
    public BaseResponse delete(AdminListid model);
    public Page page(AdminPageParam model);
}
