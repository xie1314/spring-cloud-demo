package cn.vpclub.demo.response;

public class Secpolic {
    private String  uidrecordid;//记录ID，唯一
    private String  uidsecpolicyid;//策略id
    private String  secpolicyname; //策略名称
    private String  stros;//操作系统
    private String  strlan;//语言
    private String  strdesc; //描述
    private Integer scopetype;//范围类型
    private String  value1;//值1(scopeType不同代表不同含义)
    private String  value2;//值2(scopeType不同代表不同含义)

    public String getUidrecordid() {
        return uidrecordid;
    }

    public void setUidrecordid(String uidrecordid) {
        this.uidrecordid = uidrecordid;
    }

    public String getUidsecpolicyid() {
        return uidsecpolicyid;
    }

    public void setUidsecpolicyid(String uidsecpolicyid) {
        this.uidsecpolicyid = uidsecpolicyid;
    }

    public String getSecpolicyname() {
        return secpolicyname;
    }

    public void setSecpolicyname(String secpolicyname) {
        this.secpolicyname = secpolicyname;
    }

    public String getStros() {
        return stros;
    }

    public void setStros(String stros) {
        this.stros = stros;
    }

    public String getStrlan() {
        return strlan;
    }

    public void setStrlan(String strlan) {
        this.strlan = strlan;
    }

    public String getStrdesc() {
        return strdesc;
    }

    public void setStrdesc(String strdesc) {
        this.strdesc = strdesc;
    }

    public Integer getScopetype() {
        return scopetype;
    }

    public void setScopetype(Integer scopetype) {
        this.scopetype = scopetype;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Secpolic{" +
                "uidrecordid='" + uidrecordid + '\'' +
                ", uidsecpolicyid='" + uidsecpolicyid + '\'' +
                ", secpolicyname='" + secpolicyname + '\'' +
                ", stros='" + stros + '\'' +
                ", strlan='" + strlan + '\'' +
                ", strdesc='" + strdesc + '\'' +
                ", scopetype=" + scopetype +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }
}
