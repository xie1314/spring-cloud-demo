package cn.vpclub.demo.web;
import cn.vpclub.demo.domain.entity.Admin;

import cn.vpclub.demo.request.AdminId;
import cn.vpclub.demo.request.AdminListRequset;
import cn.vpclub.demo.request.AdminListid;
import cn.vpclub.demo.request.AdminPageParam;
import cn.vpclub.demo.service.AdminService;

import cn.vpclub.moses.core.model.response.BaseResponse;
import com.baomidou.mybatisplus.plugins.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;



@Slf4j
@AllArgsConstructor
@RequestMapping("/app")
@RestController
public class AdminController{
    private AdminService service;

    @PostMapping(value = "/delete")
    public BaseResponse delete(@RequestBody AdminId id) {
        return service.delete(id);
    }

    @PostMapping(value = "/query")
    public BaseResponse query(@RequestBody Admin id) {
        return service.query(id);
    }

    @PostMapping(value = "/deleteid")
    public BaseResponse deleteid(@RequestBody AdminListid id) {
        return service.deleteid(id);
    }


    @PostMapping(value = "/insertbatch")
    public BaseResponse impexport(AdminListRequset file) {

        return  service.insertbatch(file);
    }


    @PostMapping(value = "/page")
    public Page export(@RequestBody AdminPageParam param) {
        return  service.page(param);
 }

}

