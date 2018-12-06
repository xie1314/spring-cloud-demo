package cn.vpclub.demo.request;

/**
 * 5.15管理员组删除接口（长江证券)
 * 5.15.1功能
 * 实现管理员组的删除功能。
 * URL Demo：
 * http://{IP}:30098/operator?act=deleteOperatorGroup
 */
public class DeleteOperatorGroup {
    private String operatorGroupId;        //管理员组ID	必填

    public String getOperatorGroupId() {
        return operatorGroupId;
    }

    public void setOperatorGroupId(String operatorGroupId) {
        this.operatorGroupId = operatorGroupId;
    }

    @Override
    public String toString() {
        return "DeleteOperatorGroup{" +
                "operatorGroupId='" + operatorGroupId + '\'' +
                '}';
    }
}
