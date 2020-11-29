package com.polec.lab6.controller;

import com.polec.lab6.entity.CountryEntity;
import com.polec.lab6.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("/")
    public String home(HttpSession session){
        List<CountryEntity> list = countryService.findAll();

        session.setAttribute("countries", list);

        return "/countryList";
    }

    @RequestMapping("/findAll")
    public String findAll(HttpSession session){
        List<CountryEntity> list = countryService.findAll();

        session.setAttribute("countries", list);

        return "/countryList";
    }

    @RequestMapping("/continent")
    public String continent(@RequestParam("continent") String continent, HttpSession session){
        List<CountryEntity> list = countryService.findAllByContinentOrderByCode(continent);

        session.setAttribute("countries", list);

        return "countryList";
    }

    @RequestMapping("/populationGreaterThen")
    public String populationGreaterThen(@RequestParam("population") Integer population, HttpSession session){
        List<CountryEntity> list = countryService.findAllByPopulationGreaterThan(population);

        session.setAttribute("countries", list);

        return "countryList";
    }

    @RequestMapping("/populationLessThen")
    public String populationLessThen(@RequestParam("population") Integer population, HttpSession session){
        List<CountryEntity> list = countryService.findAllByPopulationLessThan(population);

        session.setAttribute("countries", list);

        return "countryList";
    }

    @RequestMapping("/surface")
    public String populationLessThen(
            @RequestParam("continent") String continent,
            @RequestParam("minArea") BigDecimal minArea,
            @RequestParam("maxArea") BigDecimal maxArea,
            HttpSession session){
        List<CountryEntity> list = countryService.findAllBySurface(continent, minArea, maxArea);

        session.setAttribute("countries", list);

        return "countryList";
    }
}
