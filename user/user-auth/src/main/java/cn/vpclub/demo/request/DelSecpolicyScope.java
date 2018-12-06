package cn.vpclub.demo.request;
/**
 *5.3删除策略应用范围接口（长江证券)
 *  5.3.1功能
 *  实现通过条件删除策略应用范围。
 *  URL Demo：
 *  http://{IP}:30098/secpolicy?act=delSecpolicyScope
 *
 */
public class DelSecpolicyScope {
    private String secpolicyname;//策略名称	必填
    private	String	scopetype;//范围类型，具体值详见表5-1-1	必填
    private	String	value1;//具体含义根据scopeType改变
    private	String	value2;//具体含义根据scopeType改变

    public String getSecpolicyname() {
        return secpolicyname;
    }

    public void setSecpolicyname(String secpolicyname) {
        this.secpolicyname = secpolicyname;
    }

    public String getScopetype() {
        return scopetype;
    }

    public void setScopetype(String scopetype) {
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
        return "DelSecpolicyScope{" +
                "secpolicyname='" + secpolicyname + '\'' +
                ", scopetype='" + scopetype + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }
}
