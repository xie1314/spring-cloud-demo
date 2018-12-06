package cn.vpclub.demo.domain.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@TableName("admin")
public class Admin extends Model<Admin> {
    @TableId(value = "id")
    private Long id;

    //管理员账号
    @TableField("admin_user")
    private String adminUser;

//管理员密码
    @TableField("admin_password")
    private String adminPassword;

//邮箱
    @TableField("admin_email")
    private String  adminEmail;

//电话
    @TableField("admin_phone")
    private String  adminPhone;


//创建时间
    @TableField("create_time")
    private String  createTime;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
