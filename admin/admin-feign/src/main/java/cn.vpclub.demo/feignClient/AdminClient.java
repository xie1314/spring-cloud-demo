package cn.vpclub.demo.feignClient;

import cn.vpclub.demo.domain.entity.Admin;

import cn.vpclub.demo.request.AdminId;
import cn.vpclub.demo.request.AdminListRequset;
import cn.vpclub.demo.request.AdminListid;
import cn.vpclub.demo.request.AdminPageParam;
import cn.vpclub.moses.core.model.response.BaseResponse;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/sysadmin")
public interface AdminClient {
 @RequestMapping(value = "sdelete", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
        public BaseResponse delete(@RequestBody AdminId id);

        @RequestMapping(value = "squery", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
        public BaseResponse query(@RequestBody Admin id);

        @RequestMapping(value = "sdeleteid", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
        public BaseResponse deleteid(@RequestBody AdminListid id);


        @RequestMapping(value = "sinsertbatch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
        public BaseResponse insertbatch(@RequestBody AdminListRequset admin);


        @RequestMapping(value = "spage", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
        Page page(@RequestBody AdminPageParam param);
}
