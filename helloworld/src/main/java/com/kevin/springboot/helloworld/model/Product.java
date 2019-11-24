package com.kevin.springboot.helloworld.model;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
public class Product
{
    private Long productId;
    private String productCode;
    private String partnerName;
    private String title;

    public Long getProductId()
    {
        return productId;
    }

    public Product productId(Long productId)
    {
        this.productId = productId;
        return this;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public Product productCode(String productCode)
    {
        this.productCode = productCode;
        return this;
    }

    public String getPartnerName()
    {
        return partnerName;
    }

    public Product partnerName(String partnerName)
    {
        this.partnerName = partnerName;
        return this;
    }

    public String getTitle()
    {
        return title;
    }

    public Product title(String title)
    {
        this.title = title;
        return this;
    }

}
