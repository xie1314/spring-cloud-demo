package cn.vpclub.demo.test;

import cn.vpclub.demo.request.AddOperatorGroup;
import cn.vpclub.demo.response.Children;
import cn.vpclub.demo.response.DeptTree;
import cn.vpclub.demo.response.QueryDeptTreeResponse;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static void main(String[] args) {
        AddOperatorGroup addOperatorGroup = new AddOperatorGroup();
        addOperatorGroup.setDeptIds("6456");
        addOperatorGroup.setMenuIds("4654");
        addOperatorGroup.setOperatorGroupDesc("desc");
        String s2 = JSONUtils.beanToJson(addOperatorGroup);

      //  String s3 = HttpClientUtil.doPostJson("http://172.16.64.29:30098/operator?act=addOperatorGroup", s2);

        QueryDeptTreeResponse queryDeptTreeResponse = new QueryDeptTreeResponse();
        queryDeptTreeResponse.setMsg("成功");
        queryDeptTreeResponse.setStatus("SUCCESS");
        List list = new ArrayList();
        DeptTree deptTree = new DeptTree();
        deptTree.setId("45");
        deptTree.setLeaf(true);
        Children children = new Children();
        children.setId("12");
        children.setLeaf(true);
        children.setText("子节点");
        List lists = new ArrayList();
        lists.add(children);
        deptTree.setChildren(lists);
        list.add(deptTree);
        queryDeptTreeResponse.setRows(list);
        String s = JSONUtils.beanToJson(queryDeptTreeResponse);

        QueryDeptTreeResponse o = (QueryDeptTreeResponse) JSONUtils.jsonToBean(s, new QueryDeptTreeResponse());
        String s1 = JSONUtils.beanToJson(o);
        System.out.println(s1);
        System.out.println(s);

    }
}
