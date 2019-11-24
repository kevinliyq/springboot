package com.kevin.springboot.helloworld.controller;

import com.kevin.springboot.helloworld.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@RestController
public class HelloWorldController
{
    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    private HelloService helloService;
    private HelloWorldController(HelloService helloService)
    {
        this.helloService = helloService;
    }
    @RequestMapping("/home")
    public String hello(@RequestParam(name = "name", defaultValue="beijing") String name)
    {
        logger.info("Receive request from {}", name);
        return helloService.hello(name);
    }

    @RequestMapping("/exception")
    public String exception() throws Exception
    {
        logger.info("Receive exception request");
        throw new Exception("For test exception");
    }
}
