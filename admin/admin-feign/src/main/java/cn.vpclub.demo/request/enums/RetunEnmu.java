package cn.vpclub.demo.request.enums;

public enum RetunEnmu {
    CODE_1000(Integer.valueOf(1000), "成功"),
    CODE_1001(Integer.valueOf(1001), "无权限访问"),
    CODE_1002(Integer.valueOf(1002), "信息不存在"),
    CODE_1003(Integer.valueOf(1003), "支付方式错误"),
    CODE_1004(Integer.valueOf(1004), "服务器处理异常"),
    CODE_1005(Integer.valueOf(1005), "支付请求MD5签名失败"),
    CODE_1006(Integer.valueOf(1006), "未查询到订单信息"),
    CODE_1007(Integer.valueOf(1007), "请求超时"),
    CODE_1008(Integer.valueOf(1008), "信息已存在"),
    CODE_1009(Integer.valueOf(1009), "登录状态已失效, 请重新登录"),
    CODE_1010(Integer.valueOf(1010), "验证失败"),
    CODE_1011(Integer.valueOf(1011), "MD5签名失败"),
    CODE_1012(Integer.valueOf(1012), "用户信息缓存失败"),
    CODE_1013(Integer.valueOf(1013), "登录失败次数超过限制"),
    CODE_1015(Integer.valueOf(1015), "验证码错误，请重新获取验证码"),
    CODE_1100(Integer.valueOf(1100), "MD5签名验证失败"),
     CODE_1016(Integer.valueOf(1016), "{0}"),
    CODE_2000(Integer.valueOf(2000), "网络异常,请稍后再试"),
    CODE_9999(Integer.valueOf(9999), "{0}");

    private Integer code;
    private String value;

    private RetunEnmu(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
    public final Integer getCode() {
        return code;
    }

    public final String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.code + "=" + this.value;
    }
}
