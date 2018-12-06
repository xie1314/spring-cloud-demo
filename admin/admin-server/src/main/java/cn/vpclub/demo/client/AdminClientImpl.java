package cn.vpclub.demo.client;

import cn.vpclub.demo.domain.entity.Admin;
import cn.vpclub.demo.feignClient.AdminClient;

import cn.vpclub.demo.request.AdminId;
import cn.vpclub.demo.request.AdminListRequset;
import cn.vpclub.demo.request.AdminListid;
import cn.vpclub.demo.request.AdminPageParam;
import cn.vpclub.demo.service.AdminService;

import cn.vpclub.moses.core.model.response.BaseResponse;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminClientImpl implements AdminClient{
    @Autowired
    private AdminService service;
    @Override
    public BaseResponse delete(@RequestBody AdminId id) {
        return service.deleteBatch(id);
    }

    @Override
    public BaseResponse query(@RequestBody Admin id) {
        return service.query(id);
    }

    @Override
    public BaseResponse deleteid(@RequestBody AdminListid id) {
        return service.delete(id);
    }

    @Override
    public BaseResponse insertbatch(@RequestBody AdminListRequset admin) {
        return service.add(admin);
    }

    @Override
    public Page page(@RequestBody AdminPageParam param) {
        return service.page(param);
    }
}
