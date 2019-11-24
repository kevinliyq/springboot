package com.kevin.springboot.helloworld.service;

import com.kevin.springboot.helloworld.config.ProductConfig;
import com.kevin.springboot.helloworld.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@Service
public class ProductService
{
    @Autowired
    private ProductConfig productConfig;

    private AtomicLong idGenerate = new AtomicLong(0L);
    private ConcurrentHashMap<Long, Product> products = new ConcurrentHashMap<>();

    public Product getTemplateProduct()
    {
        Product newProduct = new Product();
        newProduct.productId(0L)
                .partnerName(productConfig.getPartner())
                .title(productConfig.getTitle())
                .productCode(UUID.randomUUID().toString());

        return newProduct;

    }

    public Product createProduct(Product product)
    {
        Long id = idGenerate.incrementAndGet();
        Product newProduct = product.productId(id);
        products.put(id, newProduct);

        return newProduct;
    }

    public Product getProduct(Long id)
    {
        return products.get(id);
    }

    public Product updateProduct(Product product)
    {
        Objects.requireNonNull(product, "product is null");

        if (products.containsKey(product.getProductId()))
        {
            products.put(product.getProductId(), product);
        }
        return null;
    }

    public boolean deleteProduct(Long id)
    {
        return products.remove(id) != null;
    }

}
