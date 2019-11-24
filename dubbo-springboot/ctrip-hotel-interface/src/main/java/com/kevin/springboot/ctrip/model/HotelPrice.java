package com.kevin.springboot.ctrip.model;

import java.io.Serializable;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
public class HotelPrice implements Serializable
{
    private Integer hotelId;
    private Double totalPrice;
    private String dateTime;

    public Integer getHotelId()
    {
        return hotelId;
    }

    public void setHotelId(Integer hotelId)
    {
        this.hotelId = hotelId;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(String dateTime)
    {
        this.dateTime = dateTime;
    }
}
