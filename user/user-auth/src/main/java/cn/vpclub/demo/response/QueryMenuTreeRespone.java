package cn.vpclub.demo.response;

import java.util.List;

/**
 * 菜单树查询返回参数
 */
public class QueryMenuTreeRespone {
    private String  status;    //SUCCESS 成功；ERROR 失败；INVALID 无权限
    private String  msg;    //结果说明
    private List<MenuTree> rows;    //字段说明如下：

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<MenuTree> getRows() {
        return rows;
    }

    public void setRows(List<MenuTree> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "QueryMenuTreeRespone{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", rows=" + rows +
                '}';
    }
}
