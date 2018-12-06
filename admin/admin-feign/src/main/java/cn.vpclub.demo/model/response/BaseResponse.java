package cn.vpclub.demo.model.response;


import cn.vpclub.demo.model.response.Result.Code;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


/**
 * 返回数据
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class BaseResponse extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public BaseResponse() {
		put("code", Code.SUCCESS.getCode());
		put("msg", Code.SUCCESS.getMsg());
	}
	
	public static BaseResponse error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static BaseResponse error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static BaseResponse error(int code, String msg) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.put("code", code);
		baseResponse.put("msg", msg);
		return baseResponse;
	}

	public static BaseResponse success(String msg) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.put("msg", msg);
		return baseResponse;
	}
	
	public static BaseResponse success(Map<String, Object> map) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.putAll(map);
		return baseResponse;
	}
	
	public static BaseResponse success() {
		return new BaseResponse();
	}

	public BaseResponse put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public static BaseResponse error(Result.Code code) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.put("code", code.getCode());
		baseResponse.put("msg", code.getMsg());
		return baseResponse;
	}
}
