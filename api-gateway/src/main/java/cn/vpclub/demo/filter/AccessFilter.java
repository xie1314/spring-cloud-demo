package cn.vpclub.demo.filter;


import cn.vpclub.demo.domain.entity.Result;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 泥水佬
 * @date 2017/12/14
 */
@Component
@ConfigurationProperties
public class AccessFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);


    /***
     * 前置过滤器
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /***
     *  优先级，数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER;
    }

    /***
     * 是否执行该过滤器，true代表需要过滤
     */
    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
       /* //检查是否需要鉴权的URL
        String uri = request.getRequestURI();
        uri = uri.substring(1, uri.length());
        //暂时关闭鉴权
        return !FunctionUrlConstant.ignoreUrl.contains(uri);*/
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();


       /* logger.info("***************************Token拦截校验******************************");
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            return responseErrorResult(ResponseResult.paramNotNull("Token 不能为空"));
        }
        String userCode = request.getParameter("userCode");
        if (StringUtils.isBlank(userCode)) {
            return responseErrorResult(ResponseResult.paramNotNull("userCode 不能为空"));
        }*/



        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }



    /***
     * 结果响应
     */
    private Object responseErrorResult(Result result) {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //不进行路由
        requestContext.setSendZuulResponse(false);
        requestContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        requestContext.setResponseStatusCode(result.getCode());
        requestContext.setResponseBody(JSON.toJSONString(result));
        requestContext.set("isSuccess", false);
        return null;
    }
}