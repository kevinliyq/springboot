package com.kevin.springboot.ctrip.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
public class HotelInfoObject implements Serializable
{

    private Integer hotelId;
    private String hotelName;
    private String address;

    private List<Room> rooms;

    public Integer getHotelId()
    {
        return hotelId;
    }

    public void setHotelId(Integer hotelId)
    {
        this.hotelId = hotelId;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public List<Room> getRooms()
    {
        return rooms;
    }

    public void setRooms(List<Room> rooms)
    {
        this.rooms = rooms;
    }
}
