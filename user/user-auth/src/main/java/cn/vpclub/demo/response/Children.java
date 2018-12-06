package cn.vpclub.demo.response;

public class Children {
    private String id; //菜单id
    private String text; //菜单名字
    private Boolean leaf;//是否是叶子节点，true:是 false:否

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

    @Override
    public String toString() {
        return "Children{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", leaf=" + leaf +
                '}';
    }
}
