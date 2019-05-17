package com.imooc.weatherssss.service;

import com.imooc.weatherssss.vo.Weather;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherReportService
 * @date 2019/5/17 10:18
 */
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
