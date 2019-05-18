package com.imooc.weatherssss.util;

import com.imooc.weatherssss.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: XMLToJava
 * @date 2019/5/17 8:15
 */
public class XMLToJava {
    public static Object xmlToJava(Class<?> clazz, String fileName) throws JAXBException, IOException {
        //使用jdk提供的JAXB来解析xml到java对象的映射
        JAXBContext context = JAXBContext.newInstance(clazz);
        //创建解组
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //使用解组的unmarshal方法来解析数据
        Object unmarshal = unmarshaller.unmarshal(XMLToJava.class.getClassLoader()
                .getResourceAsStream(fileName));
        return unmarshal;
    }


}
