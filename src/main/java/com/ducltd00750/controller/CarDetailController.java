package com.ducltd00750.controller;

import com.ducltd00750.entity.Car;
import com.ducltd00750.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarDetailController {

    private CarService carService;

    public CarDetailController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/carDetail{car_id}", method = RequestMethod.GET)
    public String carDetail(Model model, @RequestParam(value = "car_id") Long carId) {
        Car carById = carService.findById(carId);
        model.addAttribute("carById", carById);
        return "carDetail";
    }
}