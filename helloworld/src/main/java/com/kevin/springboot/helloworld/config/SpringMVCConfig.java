package com.kevin.springboot.helloworld.config;

import com.kevin.springboot.helloworld.advice.RequestTimeHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter
{
    @Autowired
    private RequestTimeHandlerInterceptor requestTimeHandlerInterceptor;

    @Override public void addInterceptors(InterceptorRegistry registry)
    {
        super.addInterceptors(registry);
        registry.addInterceptor(requestTimeHandlerInterceptor).addPathPatterns("/**");

    }
}
