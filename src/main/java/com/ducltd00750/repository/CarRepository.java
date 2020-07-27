package com.ducltd00750.repository;

import com.ducltd00750.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("from Car as c where c.id not in (select b.car.id from BorrowedDate as b)")
    List<Car> newCars();

    List<Car> findAll();

    Car findById(Long id);

}
