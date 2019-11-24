package com.kevin.springboot.ctrip.api;

import com.kevin.springboot.ctrip.model.HotelInfoObject;
import com.kevin.springboot.ctrip.model.Room;
import org.apache.dubbo.config.annotation.Service;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@Service(version = "1.0.0")
public class HotelServiceImpl implements HotelService
{
    private AtomicInteger idGenerate = new AtomicInteger(0);

    private ConcurrentHashMap<Integer, HotelInfoObject> hotels = new ConcurrentHashMap<>();

    @Override public HotelInfoObject createHotel(String hotelName)
    {
        Room room = new Room();
        room.setRoomId(1);
        room.setRoomName("豪华双人间");
        room.setCount(3);

        HotelInfoObject hotel = new HotelInfoObject();
        hotel.setHotelId(idGenerate.incrementAndGet());
        hotel.setHotelName(hotelName);
        hotel.setAddress("北京王府井大街110号");
        hotel.setRooms(Collections.singletonList(room));

        hotels.put(hotel.getHotelId(), hotel);

        return hotel;
    }

    @Override public HotelInfoObject getHotel(Integer hotelId)
    {
        return hotels.get(hotelId);
    }
}
