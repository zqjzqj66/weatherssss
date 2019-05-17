package com.imooc.weatherssss.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Weather
 * @date 2019/5/16 10:49
 */
@Slf4j
@Data
public class Weather implements Serializable {

    @JsonProperty("yesterday")
    private Yesterday yesterday;

    @JsonProperty("city")
    private String city;

    @JsonProperty("forecast")
    private List<Forecast> forecast;

    @JsonProperty("ganmao")
    private String ganmao;

    @JsonProperty("wendu")
    private String wendu;

}
