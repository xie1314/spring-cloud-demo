package cn.vpclub.demo.request;

/**
 * 5.13管理员组新增接口（长江证券)
 * 5.13.1功能
 * 实现管理员组的新增功能。
 * URL Demo：
 * http://{IP}:30098/operator?act=addOperatorGroup
 */
public class AddOperatorGroup {
    private String operatorGroupName;    //	管理员组名称	必填
    private String operatorGroupDesc;//		管理员组描述
    private String menuIds;//	该组拥有的菜单权限。多个菜单id之间用“,”隔开，例如: "fff7","eff7"
    private String deptIds;//	该组拥有的部门权限。多个部门ID之间用“,”隔开，例如: "abb2","ccc-"

    public String getOperatorGroupName() {
        return operatorGroupName;
    }

    public void setOperatorGroupName(String operatorGroupName) {
        this.operatorGroupName = operatorGroupName;
    }

    public String getOperatorGroupDesc() {
        return operatorGroupDesc;
    }

    public void setOperatorGroupDesc(String operatorGroupDesc) {
        this.operatorGroupDesc = operatorGroupDesc;
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }
}
