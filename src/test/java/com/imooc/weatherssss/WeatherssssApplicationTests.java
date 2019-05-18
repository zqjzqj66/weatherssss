package com.imooc.weatherssss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherssssApplicationTests {

	@Test
	public void contextLoads() throws MalformedURLException {

        /*final URL resource = this.getClass().getResource("cityList.xml");
        final URL resource1 = this.getClass().getClassLoader().getResource("cityList.xml");
        System.out.println(resource);
        System.out.println(resource1);*/

        String property =System.getProperty("user.dir");
        System.out.println(property);


    }

}
