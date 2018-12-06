package cn.vpclub.demo.common.exception;


import cn.vpclub.demo.model.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public BaseResponse handleRRException(RRException e){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.put("code", e.getCode());
		baseResponse.put("msg", e.getMessage());

		return baseResponse;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public BaseResponse handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return BaseResponse.error("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public BaseResponse handleException(Exception e){
		logger.error(e.getMessage(), e);
		return BaseResponse.error();
	}
}
