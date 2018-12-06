package cn.vpclub.demo.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminRequset {

    private String adminUser;

//管理员密码

    private String adminPassword;

//邮箱

    private String  adminEmail;

//电话

    private String  adminPhone;


}
