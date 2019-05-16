package com.imooc.weatherssss.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.weatherssss.service.WeatherDataService;
import com.imooc.weatherssss.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherDataServiceImpl
 * @date 2019/5/16 11:10
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_URL="http://wthrcdn.etouch.cn/weather_mini?";

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url=WEATHER_URL+"citykey="+cityId;
        return getDataByURL(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url=WEATHER_URL+"city="+cityName;
        return getDataByURL(url);
    }

    //重构 提取了公共方法
    private WeatherResponse getDataByURL(String url) {
        //使用restTemplate来获取数据
        //返回的是对象ResponseEntity里面包含的是json
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

        //使用jsckson来把json解析为对应的对象
        ObjectMapper objectMapper = new ObjectMapper();
        //获取json字符串
        String strBody=null;
        if(entity.getStatusCodeValue()==200){
            strBody = entity.getBody();
        }
        System.out.println(strBody);


        WeatherResponse weatherResponse = null;
        try {
            //使用readValue来进行直接的转换
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
            System.out.println(weatherResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherResponse;
    }
}
