package cn.vpclub.demo.response;

import java.util.List;

/**
 *  管理员组查询返回参数
 */
public class QueryOperatorGroupResponse {
    private String            status;//SUCCESS 成功；ERROR 失败；INVALID 无权限
    private String            msg;//结果说明
    private List<Stropergroup> rows;//符合查询条件的管理员信息
}
