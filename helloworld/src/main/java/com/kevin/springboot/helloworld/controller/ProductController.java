package com.kevin.springboot.helloworld.controller;

import com.kevin.springboot.helloworld.model.Product;
import com.kevin.springboot.helloworld.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@RestController
@RequestMapping("/product")
public class ProductController
{
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/template")
    public Product getProductTemplate()
    {
        logger.info("Receive getProductTemplate");
        return productService.getTemplateProduct();
    }

    @PutMapping("/create")
    public Product createProduct(@RequestBody Product product)
    {
        logger.info("Receive createProduct {}", product);
        return productService.createProduct(product);
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable("id") Long id)
    {
        logger.info("Receive getProduct id {}", id);
        return productService.getProduct(id);
    }

    @PostMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        logger.info("Receive updateProduct {}", product);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id)
    {
        logger.info("Receive deleteProduct {}", id);
        return productService.deleteProduct(id);
    }


}
