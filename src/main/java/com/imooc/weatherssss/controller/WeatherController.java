package com.imooc.weatherssss.controller;

import com.imooc.weatherssss.service.WeatherDataService;
import com.imooc.weatherssss.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherController
 * @date 2019/5/16 11:51
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId")String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }


    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName")String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }
}
