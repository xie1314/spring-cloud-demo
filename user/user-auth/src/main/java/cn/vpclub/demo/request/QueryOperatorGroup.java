package cn.vpclub.demo.request;

/**
 * 5.7管理员组查询接口（长江证券)
 * 5.7.1功能
 * 根据管理员组名称和描述查询管理员组信息。
 * URL Demo：
 * http://{IP}:30098/operator?act=queryOperatorGroup
 */
public class QueryOperatorGroup {
    private String	searchType;//检索条件类型,1：管理员组名2：描述
    private	String	searchKey;//检索条件关键字

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public String toString() {
        return "QueryOperatorGroup{" +
                "searchType='" + searchType + '\'' +
                ", searchKey='" + searchKey + '\'' +
                '}';
    }
}
