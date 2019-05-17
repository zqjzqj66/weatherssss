package com.imooc.weatherssss.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.weatherssss.service.WeatherDataService;
import com.imooc.weatherssss.vo.City;
import com.imooc.weatherssss.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherDataServiceImpl
 * @date 2019/5/16 11:10
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    private static final int TIME_OUT=100;

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

    //同步数据 每隔30分钟 自动调用远端的rest程序来同步数据
    @Override
    public void syncWeatherData(String cityId) {
        String url=WEATHER_URL+"citykey="+cityId;
        String strBody=null;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        log.info("sync data");
        //使用restTemplate来获取数据
        //返回的是对象ResponseEntity里面包含的是json
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        //获取json字符串
        if(entity.getStatusCodeValue()==200){
            strBody = entity.getBody();
            ops.set(url,strBody , TIME_OUT, TimeUnit.SECONDS);
        }

    }

    //重构 提取了公共方法
    private WeatherResponse getDataByURL(String url) {


        String strBody=null;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        if(redisTemplate.hasKey(url)){
            strBody = ops.get(url);
            log.info(url+" redis has this data");
        }else{
            log.info(url+"redis don't have this data");
            //使用restTemplate来获取数据
            //返回的是对象ResponseEntity里面包含的是json
            ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

            //获取json字符串
            if(entity.getStatusCodeValue()==200){
                strBody = entity.getBody();
                ops.set(url,strBody , TIME_OUT, TimeUnit.SECONDS);
            }
        }
        //使用jsckson来把json解析为对应的对象
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            //使用readValue来进行直接的转换
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherResponse;
    }
}
