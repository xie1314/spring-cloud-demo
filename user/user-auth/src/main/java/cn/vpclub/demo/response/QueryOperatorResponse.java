package cn.vpclub.demo.response;

import java.util.List;

/**
 * 管理员查询返回参数
 */
public class QueryOperatorResponse {
   private   String	status;//SUCCESS 成功；ERROR 失败；INVALID 无权限
    private  String	msg;//结果说明
    private List<Stroperator> rows;//符合查询条件的管理员信息

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

    public List<Stroperator> getRows() {
        return rows;
    }

    public void setRows(List<Stroperator> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "QueryOperatorResponse{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", rows=" + rows +
                '}';
    }
}
