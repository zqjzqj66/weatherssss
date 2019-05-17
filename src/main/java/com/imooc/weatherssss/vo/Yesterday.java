package com.imooc.weatherssss.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Yesterday
 * @date 2019/5/16 10:52
 */
@Slf4j
@Data
public class Yesterday implements Serializable {

    @JsonProperty("date")
    private String date;

    @JsonProperty("high")
    private String high;

    @JsonProperty("fx")
    private String fx;

    @JsonProperty("low")
    private String low;

    @JsonProperty("fl")
    private String fl;

    @JsonProperty("type")
    private String type;
}
