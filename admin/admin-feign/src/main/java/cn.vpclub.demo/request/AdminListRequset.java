package cn.vpclub.demo.request;

import cn.vpclub.demo.domain.entity.Admin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AdminListRequset{
    private List<Admin> adminList;
}
