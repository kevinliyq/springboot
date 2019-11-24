package com.kevin.springboot.helloworld.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置拦截器
 * 首先实现HandlerInterceptor接口，并加上注解@Component
 * 其次把自定义的拦截器添加到InterceptorRegistry上
 * @author: yoli
 * @since: 2019/11/24
 */
@Component
public class RequestTimeHandlerInterceptor implements HandlerInterceptor
{
    private Logger logger = LoggerFactory.getLogger(RequestTimeHandlerInterceptor.class);
    private ThreadLocal<Long> requestTimeThreadLocal = new ThreadLocal<>();

    //在请求被处理前被调用
    @Override public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        logger.info("preHandle is called");

        requestTimeThreadLocal.set(System.currentTimeMillis());
        return true;
    }

    //Controller返回，View渲染之前被调用
    @Override public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

        logger.info("postHandle is called, time cost from preHandle {} ms", (System.currentTimeMillis() - requestTimeThreadLocal.get()));
    }

    /**
     * 在整个请求结束后被调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        logger.info("afterCompletion is called, time cost from preHandle {} ms", (System.currentTimeMillis() - requestTimeThreadLocal.get()));
    }
}
