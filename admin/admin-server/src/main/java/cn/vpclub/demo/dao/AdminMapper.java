package cn.vpclub.demo.dao;


import cn.vpclub.demo.domain.entity.Admin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;


@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "adminUser", column = "admin_user"),
            @Result(property = "adminPassword", column = "admin_password"),
            @Result(property = "adminEmail", column = "admin_email"),
            @Result(property = "adminPhone", column = "admin_phone"),
            @Result(property = "createTime", column = "create_time")
    })
    @SelectProvider(type = AdminDaoProvider.class,method = "query")
    public Admin query(Admin admin);
    class AdminDaoProvider {
        public String query(Admin admin){
            System.out.print(admin);
            SQL s = new SQL().SELECT("*").FROM("admin");
            if (admin.getId() != null) {
                s.WHERE("id like #{id}");
            }
            if (admin.getAdminUser() != null || admin.getAdminUser() !="") {
                s.WHERE("admin_user like #{adminUser}");
            }
            if (admin.getAdminPassword() != null ||admin.getAdminPassword() != "") {
                s.WHERE("admin_password like #{adminPassword}");
            }
            s.ORDER_BY("id");
            String s1 = s.toString();
            System.out.print(s);
            return s1;
        }
    }
}
