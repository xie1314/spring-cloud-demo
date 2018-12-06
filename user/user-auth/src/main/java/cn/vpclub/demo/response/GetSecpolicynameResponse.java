package cn.vpclub.demo.response;

import java.util.List;
/**
 * 根据策略名查询返回参数
 */
public class GetSecpolicynameResponse {
    /**
     * 符合查询条件的策略范围信息
     */
    private List<Secpolic> rows;
    /**
     * 条数
     */
    private Integer total;
    /**
     * 状态
     */
    private String status;
    /**
     * 结果说明
     */
    private String msg;

    public List<Secpolic> getRows() {
        return rows;
    }

    public void setRows(List<Secpolic> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

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

    @Override
    public String toString() {
        return "GetSecpolicynameResponse{" +
                "rows=" + rows +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
