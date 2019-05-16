package com.imooc.weatherssss.service;

import com.imooc.weatherssss.vo.Weather;
import com.imooc.weatherssss.vo.WeatherResponse;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherDataService
 * @date 2019/5/16 11:09
 */
public interface WeatherDataService {

    //根据cityId来获取数据
    WeatherResponse getDataByCityId(String cityId);

    //根据cityName来获取数据
    WeatherResponse getDataByCityName(String cityName);
}
