package cn.vpclub.demo.request;
/**
 *5.5根据策略范围ID修改策略范围接口（长江证券)
 *5.5.1功能
 *根据策略范围的ID来修改该策略范围。
 *URL Demo：
 *http://{IP}:30098/secpolicy?act=updateSecpolicyScopeById
 *
 */
public class UpdateSecpolicyScopeById {
    private String	scopeid;//策略范围ID参见如下接口的返回值定义 必填
    private	Integer	scopetype;//范围类型，具体含义详见表5-1-1	必填
    private	String	value1;//根据scopeType不同表示不同含义，详见表5-1-1
    private	String	value2;//根据scopeType不同表示不同含义，详见表5-1-1
    private	String	strdesc;//描述
    private	String	extrastarttime;//例外开始生效时间，格式:yyyy-MM-dd HH:mm。例如:2018-11-10 12:01
    private	String	extraendtime;//例外结束生效时间，格式:yyyy-MM-dd HH:mm。例如:2018-11-10 12:01

    public String getScopeid() {
        return scopeid;
    }

    public void setScopeid(String scopeid) {
        this.scopeid = scopeid;
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
        return "UpdateSecpolicyScopeById{" +
                "scopeid='" + scopeid + '\'' +
                ", scopetype=" + scopetype +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", strdesc='" + strdesc + '\'' +
                ", extrastarttime='" + extrastarttime + '\'' +
                ", extraendtime='" + extraendtime + '\'' +
                '}';
    }
}
