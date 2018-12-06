package cn.vpclub.demo.response;
/**
 * 根据策略返回参数
 */
public class SecpolicyScopeResponse {
    /**
     * 状态
     */
    private String status;
    /**
     * 结果说明
     */
    private String msg;

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
        return "SecpolicyScopeResponse{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
