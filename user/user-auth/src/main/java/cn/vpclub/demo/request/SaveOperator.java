package cn.vpclub.demo.request;

/**
 * 5.8管理员新增接口（长江证券)
 * 5.8.1功能
 * 实现管理员的新增操作。
 * URL Demo：
 * http://{IP}:30098/operator?act=saveOperator
 */
public class SaveOperator {
    private String operatorAccount;//		管理员账号	必填
    private String groupName;//		所属组名称	必填
    private String accountType;//		账号类型,1:本地账号2:Radius账号	必填
    private String operatorPwd;//	String	账号密码(明文传递过来，接口再加密)	必填
    private String strDesc;//	描述
    private String operatorEmail;//	邮箱
    private String operatorPhone;//	电话
    private String startIp;//	起始Ip地址
    private String endIp;//	结束IP地址
    private String ipStartTime;//	账户允许使用开始时间，格式yyyy-MM-dd
    private String ipEndTime;//	账户允许是用结束时间，格式yyyy-MM-dd
    private String ipDesc;//	ip限制描述

    public String getOperatorAccount() {
        return operatorAccount;
    }

    public void setOperatorAccount(String operatorAccount) {
        this.operatorAccount = operatorAccount;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOperatorPwd() {
        return operatorPwd;
    }

    public void setOperatorPwd(String operatorPwd) {
        this.operatorPwd = operatorPwd;
    }

    public String getStrDesc() {
        return strDesc;
    }

    public void setStrDesc(String strDesc) {
        this.strDesc = strDesc;
    }

    public String getOperatorEmail() {
        return operatorEmail;
    }

    public void setOperatorEmail(String operatorEmail) {
        this.operatorEmail = operatorEmail;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public String getIpStartTime() {
        return ipStartTime;
    }

    public void setIpStartTime(String ipStartTime) {
        this.ipStartTime = ipStartTime;
    }

    public String getIpEndTime() {
        return ipEndTime;
    }

    public void setIpEndTime(String ipEndTime) {
        this.ipEndTime = ipEndTime;
    }

    public String getIpDesc() {
        return ipDesc;
    }

    public void setIpDesc(String ipDesc) {
        this.ipDesc = ipDesc;
    }

    @Override
    public String toString() {
        return "SaveOperator{" +
                "operatorAccount='" + operatorAccount + '\'' +
                ", groupName='" + groupName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", operatorPwd='" + operatorPwd + '\'' +
                ", strDesc='" + strDesc + '\'' +
                ", operatorEmail='" + operatorEmail + '\'' +
                ", operatorPhone='" + operatorPhone + '\'' +
                ", startIp='" + startIp + '\'' +
                ", endIp='" + endIp + '\'' +
                ", ipStartTime='" + ipStartTime + '\'' +
                ", ipEndTime='" + ipEndTime + '\'' +
                ", ipDesc='" + ipDesc + '\'' +
                '}';
    }
}
