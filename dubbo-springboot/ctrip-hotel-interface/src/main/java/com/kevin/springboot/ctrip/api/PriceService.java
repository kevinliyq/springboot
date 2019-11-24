package com.kevin.springboot.ctrip.api;

import com.kevin.springboot.ctrip.model.HotelPrice;

public interface PriceService
{
    HotelPrice getHotelPrice(Integer hotelId);
}
