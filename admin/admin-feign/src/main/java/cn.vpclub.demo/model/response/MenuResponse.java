package cn.vpclub.demo.model.response;

import cn.vpclub.demo.domain.entity.SysMenuEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MenuResponse {
    private List<SysMenuEntity> menuList;
    private Set<String> permissions;
}
