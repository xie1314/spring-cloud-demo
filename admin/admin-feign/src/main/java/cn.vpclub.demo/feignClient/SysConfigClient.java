package cn.vpclub.demo.feignClient;


import cn.vpclub.demo.domain.entity.SysConfigEntity;
import cn.vpclub.demo.model.request.SysConfigParam;
import cn.vpclub.demo.model.response.PageUtils;
import cn.vpclub.moses.core.model.response.PageResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chentao on 2018/5/31.
 */
@RequestMapping("/sysConfigClient")
public interface SysConfigClient {

    @RequestMapping(value = "queryPage", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    PageResponse queryPage(@RequestBody SysConfigParam params);

    @RequestMapping(value = "selectById")
    SysConfigEntity selectById(@RequestParam("id") Long id);

    @RequestMapping(value = "save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody SysConfigEntity config);

    @RequestMapping(value = "update", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void  update(@RequestBody SysConfigEntity config);

    @RequestMapping(value = "deleteBatch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteBatch(@RequestBody SysConfigParam params);

    @RequestMapping(value = "getValue")
    String getValue(@RequestParam("key") String key);

}
