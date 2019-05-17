package com.imooc.weatherssss.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Forecast
 * @date 2019/5/16 10:54
 */
@Slf4j
@Data
public class Forecast implements Serializable {

    @JsonProperty("date")
    private String date;

    @JsonProperty("high")
    private String high;

    @JsonProperty("fengli")
    private String fengli;

    @JsonProperty("low")
    private String low;

    @JsonProperty("fengxiang")
    private String fengxiang;

    @JsonProperty("type")
    private String type;
}
