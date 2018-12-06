package cn.vpclub.demo.response;

/**
 * 管理员查询返回参数
 */
public class Stroperator {

    private String stroperatorname;//管理员账号
    private String strdesc;//描述
    private String uidopergroupid;//所属组id
    private String uidoperatorid;//管理员id
    private String stropergroupname;//管理员组名
    private String startip;//起始IP地址
    private String endip;//结束IP地址

    public String getStroperatorname() {
        return stroperatorname;
    }

    public void setStroperatorname(String stroperatorname) {
        this.stroperatorname = stroperatorname;
    }

    public String getStrdesc() {
        return strdesc;
    }

    public void setStrdesc(String strdesc) {
        this.strdesc = strdesc;
    }

    public String getUidopergroupid() {
        return uidopergroupid;
    }

    public void setUidopergroupid(String uidopergroupid) {
        this.uidopergroupid = uidopergroupid;
    }

    public String getUidoperatorid() {
        return uidoperatorid;
    }

    public void setUidoperatorid(String uidoperatorid) {
        this.uidoperatorid = uidoperatorid;
    }

    public String getStropergroupname() {
        return stropergroupname;
    }

    public void setStropergroupname(String stropergroupname) {
        this.stropergroupname = stropergroupname;
    }

    public String getStartip() {
        return startip;
    }

    public void setStartip(String startip) {
        this.startip = startip;
    }

    public String getEndip() {
        return endip;
    }

    public void setEndip(String endip) {
        this.endip = endip;
    }

    @Override
    public String toString() {
        return "Stroperator{" +
                "stroperatorname='" + stroperatorname + '\'' +
                ", strdesc='" + strdesc + '\'' +
                ", uidopergroupid='" + uidopergroupid + '\'' +
                ", uidoperatorid='" + uidoperatorid + '\'' +
                ", stropergroupname='" + stropergroupname + '\'' +
                ", startip='" + startip + '\'' +
                ", endip='" + endip + '\'' +
                '}';
    }
}
