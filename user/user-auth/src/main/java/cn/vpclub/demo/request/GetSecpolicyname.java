package cn.vpclub.demo.request;
/**
 * 根据策略名查询请求参数
 * 实现通过策略名查询该策略的应用范围。
 * URL Demo：
 * http://{IP}:30098/secpolicy?act=getSecScopeByName
 */
public class GetSecpolicyname {
    /**
     * 策略名
     */
    private String secpolicyname;

    public String getSecpolicyname() {
        return secpolicyname;
    }

    public void setSecpolicyname(String secpolicyname) {
        this.secpolicyname = secpolicyname;
    }

    @Override
    public String toString() {
        return "GetSecpolicyname{" +
                "secpolicyname='" + secpolicyname + '\'' +
                '}';
    }
}
