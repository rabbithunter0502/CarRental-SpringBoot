package com.ducltd00750.service;

import com.ducltd00750.entity.Car;
import com.ducltd00750.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void save(Car car) {
        this.carRepository.save(car);
    }

    @Override
    public List<Car> newCars() {
        return this.carRepository.newCars();
    }

    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return this.carRepository.findById(id);
    }
}
