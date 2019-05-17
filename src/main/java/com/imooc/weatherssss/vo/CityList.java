package com.imooc.weatherssss.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: CityList
 * @date 2019/5/17 8:12
 */
@Data
@XmlRootElement(name ="c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name ="d")
    private List<City> cityList;
}
