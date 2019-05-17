package com.imooc.weatherssss.controller;

import com.imooc.weatherssss.service.CityDataService;
import com.imooc.weatherssss.service.WeatherDataService;
import com.imooc.weatherssss.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherReportController
 * @date 2019/5/17 10:22
 */
@Controller
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView reportWeather(@PathVariable("cityId") String cityId, Model model){
        model.addAttribute("title","格调的天气预报" );
        model.addAttribute("cityId",cityId );
        model.addAttribute("cityList",cityDataService.getCityList().getCityList() );
        model.addAttribute("report",weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
    }

}
