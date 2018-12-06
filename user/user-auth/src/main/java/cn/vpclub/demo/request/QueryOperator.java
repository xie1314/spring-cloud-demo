package cn.vpclub.demo.request;
/**
 *5.6管理员查询接口（长江证券)
 *5.6.1功能
 *根据管理员名称和所属组查询管理员信息。
 *URL Demo：
 *http://{IP}:30098/operator?act=queryOperator
 *
 */
public class QueryOperator {
    private String searchType;	//检索条件类型,1：管理员名2：用户组名
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
        return "QueryOperator{" +
                "searchType='" + searchType + '\'' +
                ", searchKey='" + searchKey + '\'' +
                '}';
    }
}
