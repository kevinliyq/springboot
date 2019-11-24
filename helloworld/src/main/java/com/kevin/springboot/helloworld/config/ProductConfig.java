package com.kevin.springboot.helloworld.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Has to add set method
 * @author: yoli
 * @since: 2019/11/24
 */
@Component
@PropertySource("classpath:product.properties")
@ConfigurationProperties(prefix = "product")
public class ProductConfig
{
    private String title;

    private String partner;

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setPartner(String partner)
    {
        this.partner = partner;
    }

    public String getTitle()
    {
        return title;
    }

    public String getPartner()
    {
        return partner;
    }
}
