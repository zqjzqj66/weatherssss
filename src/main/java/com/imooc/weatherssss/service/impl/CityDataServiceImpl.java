package com.imooc.weatherssss.service.impl;

import com.imooc.weatherssss.service.CityDataService;
import com.imooc.weatherssss.util.XMLToJava;
import com.imooc.weatherssss.vo.City;
import com.imooc.weatherssss.vo.CityList;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: CityDataServiceImpl
 * @date 2019/5/17 11:31
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    //城市xml文件
    public static final String CITY_LIST_FILE="cityList.xml";

    @Override
    public CityList getCityList() {

        CityList cityList=null;
        try {
            cityList = (CityList) XMLToJava.xmlToJava(CityList.class,CITY_LIST_FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return cityList;
    }
}
