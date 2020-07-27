package com.ducltd00750.service;

import com.ducltd00750.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    List<Car> newCars();

    Car findById(Long id);

    void save(Car car);
}
