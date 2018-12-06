package cn.vpclub.demo.response;

import java.util.List;

/**
 * 部门树查询返回参数
 */
public class QueryDeptTreeResponse {
    private String         status;    //SUCCESS 成功；ERROR 失败；INVALID 无权限
    private String         msg;    //结果说明
    private List<DeptTree> rows;    //字段说明如下：

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

    public List<DeptTree> getRows() {
        return rows;
    }

    public void setRows(List<DeptTree> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "QueryDeptTreeResponse{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", rows=" + rows +
                '}';
    }
}
