package cn.vpclub.demo.response;

public class Stropergroup {
    private String uidopergroupid; //所属组id
    private String stropergroupname; //管理员组名
    private String strdesc;//描述

    public String getUidopergroupid() {
        return uidopergroupid;
    }

    public void setUidopergroupid(String uidopergroupid) {
        this.uidopergroupid = uidopergroupid;
    }

    public String getStropergroupname() {
        return stropergroupname;
    }

    public void setStropergroupname(String stropergroupname) {
        this.stropergroupname = stropergroupname;
    }

    public String getStrdesc() {
        return strdesc;
    }

    public void setStrdesc(String strdesc) {
        this.strdesc = strdesc;
    }

    @Override
    public String toString() {
        return "Stropergroup{" +
                "uidopergroupid='" + uidopergroupid + '\'' +
                ", stropergroupname='" + stropergroupname + '\'' +
                ", strdesc='" + strdesc + '\'' +
                '}';
    }
}
