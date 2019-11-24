package com.kevin.springboot.ctrip.controller;

import com.kevin.springboot.ctrip.api.HotelService;
import com.kevin.springboot.ctrip.api.PriceService;
import com.kevin.springboot.ctrip.model.HotelInfoObject;
import com.kevin.springboot.ctrip.model.HotelPrice;
import org.apache.dubbo.common.utils.PojoUtils;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author: yoli
 * @since: 2019/11/24
 */
@RestController
public class HotelController
{
    private Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Reference(version = "1.0.0")
    private HotelService hotelService;

    @Reference(interfaceClass = PriceService.class,
            timeout = 3000,
            async = true,
            methods = {@Method(name = "getHotelPrice", timeout = 3000, retries = 1)})
    private PriceService priceService;

    @GetMapping("/hotel/{id}")
    public HotelInfoObject getHotel(@PathVariable("id") Integer hotelId)
    {
        logger.info("getHotel {}", hotelId);
        HotelInfoObject hotel = hotelService.getHotel(hotelId);
        return hotel;
    }

    @PutMapping("/hotel/create/{name}")
    public HotelInfoObject createHotel(@PathVariable("name") String hotelName)
    {
        logger.info("createHotel {}", hotelName);
        return hotelService.createHotel(hotelName);
    }

    @GetMapping("/price/{hotelId}")
    public CompletableFuture<HotelPrice> getPrice(@PathVariable("hotelId") Integer hotelId)
    {
        logger.info("getPrice {}", hotelId);
        HotelPrice price = priceService.getHotelPrice(hotelId);

        logger.info("immediatelly returned {}", price);
        CompletableFuture<HotelPrice> future = RpcContext.getContext().getCompletableFuture();
        future.whenComplete((value, t) -> {
            if( t == null)
            {
                logger.info("invokeSayHello(whenComplete): {}" + value);
                logger.info("invokeSayHello(whenComplete): {} {}" + value.getHotelId(), value.getTotalPrice());
            }
            else{
                logger.info("Error {}", t);
            }
            //Object o = PojoUtils.realize(value, HotelPrice.class);
        });
        //here is null
        logger.info("invokeSayHello(return): " + price);

        return future;
    }
}
