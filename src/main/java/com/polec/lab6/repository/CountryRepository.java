package com.polec.lab6.repository;

import com.polec.lab6.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, String> {
    Optional<List<CountryEntity>> findAllByContinentOrderByCode(String continent);

    List<CountryEntity> findAllByPopulationGreaterThanOrderByCode(int population);

    List<CountryEntity> findAllByPopulationLessThanOrderByCode(int population);

    @Query("SELECT c FROM CountryEntity c WHERE c.continent = :continent AND c.surfaceArea >= :minArea AND c.surfaceArea <= :maxArea")
    List<CountryEntity> findAllCountriesByContinentWithAreaFromRange(
            @Param("continent") String continent,
            @Param("minArea") BigDecimal minArea,
            @Param("maxArea") BigDecimal maxArea);
}
