package cn.vpclub.demo.response;

import java.util.List;

public class DeptTree {
    private String         id; //菜单id
    private String         text; //菜单名字
    private Boolean        leaf;//是否是叶子节点，true:是 false:否
    private List<Children> children;//孩子节点数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "DeptTree{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", leaf=" + leaf +
                ", children=" + children +
                '}';
    }
}
