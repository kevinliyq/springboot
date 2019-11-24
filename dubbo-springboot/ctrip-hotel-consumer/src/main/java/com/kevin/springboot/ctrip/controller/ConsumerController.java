package com.kevin.springboot.ctrip.controller;

import com.kevin.springboot.ctrip.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController
{

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name)
    {
        return helloService.sayHello(name);
    }
}