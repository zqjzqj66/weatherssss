package com.imooc.weatherssss.service;

import com.imooc.weatherssss.vo.WeatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherDataServiceTest
 * @date 2019/5/16 11:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDataServiceTest {

    @Autowired
    private WeatherDataService weatherDataService;

    private String cityId = "101010100";

    private String cityName = "北京";

    @Test
    public void getDataByCityId() {
        WeatherResponse dataByCityId = weatherDataService.getDataByCityId(cityId);
        System.out.println(dataByCityId);
    }

    @Test
    public void getDataByCityName() {
        WeatherResponse dataByCityId = weatherDataService.getDataByCityId(cityId);
        System.out.println(dataByCityId);
    }
}