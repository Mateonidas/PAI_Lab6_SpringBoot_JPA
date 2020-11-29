package com.polec.lab6.service.impl;

import com.polec.lab6.entity.CountryEntity;
import com.polec.lab6.repository.CountryRepository;
import com.polec.lab6.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;


    @Override
    public List<CountryEntity> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public List<CountryEntity> findAllByContinentOrderByCode(String continent) {

        Optional<List<CountryEntity>> result = countryRepository.findAllByContinentOrderByCode(continent);

        List<CountryEntity> list;

        if(result.isPresent()){
            list = result.get();
        } else {
            throw new RuntimeException("Did not find countries by continent - " + continent);
        }

        return list;
    }

    @Override
    public List<CountryEntity> findAllByPopulationGreaterThan(int population) {
        return countryRepository.findAllByPopulationGreaterThanOrderByCode(population);
    }

    @Override
    public List<CountryEntity> findAllByPopulationLessThan(int population) {
        return countryRepository.findAllByPopulationLessThanOrderByCode(population);
    }

    @Override
    public List<CountryEntity> findAllBySurface(String countries, BigDecimal minArea, BigDecimal maxArea) {
        return countryRepository.findAllCountriesByContinentWithAreaFromRange(countries, minArea, maxArea);
    }
}
