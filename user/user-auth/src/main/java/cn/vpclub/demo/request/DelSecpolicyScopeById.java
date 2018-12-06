package cn.vpclub.demo.request;
/**
 5.4根据策略范围ID删除策略范围接口（长江证券)
 5.4.1功能
 根据策略范围的ID来删除该策略范围。
 URL Demo：
 http://{IP}:30098/secpolicy?act=delSecpolicyScopeById
 *
 */
public class DelSecpolicyScopeById {
    	private String scopeId;	//策略范围ID	必填

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    @Override
    public String toString() {
        return "DelSecpolicyScopeById{" +
                "scopeId='" + scopeId + '\'' +
                '}';
    }
}
