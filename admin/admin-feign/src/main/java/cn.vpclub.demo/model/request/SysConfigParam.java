package cn.vpclub.demo.model.request;

import cn.vpclub.moses.core.model.request.PageBaseSearchParam;
import lombok.Data;

import java.util.List;

/**
 * Created by chentao on 2018/6/1.
 */
@Data
public class SysConfigParam extends PageBaseSearchParam {
    private Long id;
    private String key;
    private String value;

    private Integer deleted;
    private String remark;

    private List<Long> ids;//根据id批量删除
    private Long userId;
}
