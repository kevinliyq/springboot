package com.kevin.springboot.ctrip.model;

import java.io.Serializable;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
public class Room implements Serializable
{
    private Integer roomId;
    private String roomName;
    private int count;

    public Integer getRoomId()
    {
        return roomId;
    }

    public void setRoomId(Integer roomId)
    {
        this.roomId = roomId;
    }

    public String getRoomName()
    {
        return roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }
}
