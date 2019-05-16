package com.imooc.weatherssss.vo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Weather
 * @date 2019/5/16 10:49
 */
@Slf4j
public class Weather {

    private Yesterday yesterday;

    private String city;

    private List<Forecast> forecast;

    private String ganmao;

    private String wendu;

}
