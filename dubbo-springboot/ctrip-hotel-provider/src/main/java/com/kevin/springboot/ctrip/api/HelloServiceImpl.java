package com.kevin.springboot.ctrip.api;

import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService
 {
     @Value("${server.port:}")
     private String port;

     private Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override public String sayHello(String name)
    {
        logger.info("Receive sayHello {}", name);
        return "Welcome " + name +" from port " + port;
    }
}
