package com.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
