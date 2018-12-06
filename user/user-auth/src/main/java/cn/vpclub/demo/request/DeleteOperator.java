package cn.vpclub.demo.request;

/**
 * 5.10管理员删除接口（长江证券)
 * 5.10.1功能
 * 实现管理员的删除操作。
 * URL Demo：
 * http://{IP}:30098/operator?act=deleteOperator
 */
public class DeleteOperator {
    private String operatorId;    //管理员Id	必填

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String toString() {
        return "DeleteOperator{" +
                "operatorId='" + operatorId + '\'' +
                '}';
    }
}
