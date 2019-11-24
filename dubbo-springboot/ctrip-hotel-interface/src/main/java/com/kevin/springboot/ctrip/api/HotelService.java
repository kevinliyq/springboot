package com.kevin.springboot.ctrip.api;

import com.kevin.springboot.ctrip.model.HotelInfoObject;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
public interface HotelService
{
    HotelInfoObject createHotel(String hotelName);

    HotelInfoObject getHotel(Integer hotelId);
}
