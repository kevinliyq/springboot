package com.kevin.springboot.helloworld.config;

import com.kevin.springboot.helloworld.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@Configuration
public class HelloWorldConfig
{
    @Bean
    public HelloService getHelloService()
    {
        return new HelloService();
    }
}
