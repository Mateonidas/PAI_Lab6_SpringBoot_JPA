package com.polec.lab6.service;

import com.polec.lab6.entity.CountryEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface CountryService {

    List<CountryEntity> findAll();

    List<CountryEntity> findAllByContinentOrderByCode(String continent);

    List<CountryEntity> findAllByPopulationGreaterThan(int population);

    List<CountryEntity> findAllByPopulationLessThan(int population);

    List<CountryEntity> findAllBySurface(String countries, BigDecimal minArea, BigDecimal maxArea);

}
