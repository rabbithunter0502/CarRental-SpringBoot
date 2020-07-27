package com.ducltd00750.controller;

import com.ducltd00750.entity.BorrowedDate;
import com.ducltd00750.entity.Car;
import com.ducltd00750.entity.Customer;
import com.ducltd00750.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes({ "customer", "borrowedDate" })
public class BookStepTwoController {

    private CarService carService;

    public BookStepTwoController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "bookPartTwo{car_id}", method = RequestMethod.GET)
    public String showSessionCar(Model model, @RequestParam(value = "car_id") Long carId) {
        Car carById = carService.findById(carId);
        model.addAttribute("carById", carById);
        return "bookStepTwo";
    }

    @RequestMapping(value = "bookPartTwo", method = RequestMethod.POST)
    public String completeCustomer(Customer customer, BorrowedDate borrowedDate, RedirectAttributes redirectAttributes,
            @RequestParam(value = "car_id") Long CarId) {
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/bookStepThree";
    }
}
