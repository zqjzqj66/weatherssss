package com.imooc.weatherssss.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherResponse
 * @date 2019/5/16 10:56
 */
@JsonIgnoreProperties
@Data
public class WeatherResponse implements Serializable {

    //数据
    @JsonProperty(value = "data")
    private Weather data;

    //返回的状态码
    @JsonProperty(value = "status")
    private Integer status;

    //描述
    @JsonProperty(value = "desc")
    private String desc;
}
