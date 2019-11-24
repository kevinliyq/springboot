package com.kevin.springboot.ctrip.api;

import com.kevin.springboot.ctrip.model.HotelPrice;
import org.apache.dubbo.config.annotation.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@Service
public class PriceServiceImpl implements PriceService
{
    private Random random = new Random(400);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd kk:HH:mm:ss.SSS");

    @Override public HotelPrice getHotelPrice(Integer hotelId)
    {
        HotelPrice price = new HotelPrice();
        price.setHotelId(hotelId);

        BigDecimal decimal = new BigDecimal(random.nextDouble());
        double totalPrice = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
        price.setTotalPrice(totalPrice);
        price.setDateTime(formatter.format(LocalDateTime.now()));

        return price;
    }
}
