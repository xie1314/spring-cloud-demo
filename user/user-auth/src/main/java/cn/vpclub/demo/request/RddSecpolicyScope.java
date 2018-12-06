package cn.vpclub.demo.request;
/**
 * 增加策略应用范围接口
 * 对某个策略增加应用范围。
 * URL Demo：
 * http://{IP}:30098/secpolicy?act=addSecpolicyScope
 */
public class RddSecpolicyScope {
    private String secpolicyname;	//策略名称
    private	Integer scopetype;	//范围类型，具体含义详见表5-1-2
    private String	value;//根据scopeType不同表示不同含义，详见表5-1-2
    private	String	strdesc;//描述
    private String extrastarttime;	 //例外开始生效时间，格式:yyyy-MM-dd HH:mm。例如:2018-11-10 12:01
    private	String extraendtime;	 //例外结束生效时间，格式:yyyy-MM-dd HH:mm。例如:2018-11-10 12:01

    public String getSecpolicyname() {
        return secpolicyname;
    }

    public void setSecpolicyname(String secpolicyname) {
        this.secpolicyname = secpolicyname;
    }

    public Integer getScopetype() {
        return scopetype;
    }

    public void setScopetype(Integer scopetype) {
        this.scopetype = scopetype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStrdesc() {
        return strdesc;
    }

    public void setStrdesc(String strdesc) {
        this.strdesc = strdesc;
    }

    public String getExtrastarttime() {
        return extrastarttime;
    }

    public void setExtrastarttime(String extrastarttime) {
        this.extrastarttime = extrastarttime;
    }

    public String getExtraendtime() {
        return extraendtime;
    }

    public void setExtraendtime(String extraendtime) {
        this.extraendtime = extraendtime;
    }

    @Override
    public String toString() {
        return "RddSecpolicyScope{" +
                "secpolicyname='" + secpolicyname + '\'' +
                ", scopetype=" + scopetype +
                ", value='" + value + '\'' +
                ", strdesc='" + strdesc + '\'' +
                ", extrastarttime='" + extrastarttime + '\'' +
                ", extraendtime='" + extraendtime + '\'' +
                '}';
    }
}
