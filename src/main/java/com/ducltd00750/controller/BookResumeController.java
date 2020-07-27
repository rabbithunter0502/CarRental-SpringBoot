package com.ducltd00750.controller;

import com.ducltd00750.entity.BorrowedDate;
import com.ducltd00750.entity.Car;
import com.ducltd00750.entity.Customer;
import com.ducltd00750.service.BorrowedDateService;
import com.ducltd00750.service.CarService;
import com.ducltd00750.service.CustomerService;
import com.ducltd00750.service.MailService;
import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@EnableEmailTools
@SessionAttributes({ "customer", "borrowedDate" })
public class BookResumeController {
    private CarService carService;
    private BorrowedDateService borrowedDateService;
    private CustomerService customerService;
    private MailService mailService;
    private Car carById;

    public BookResumeController(CarService carService, BorrowedDateService borrowedDateService, CustomerService customerService,
                                MailService mailService) {
        this.carService = carService;
        this.borrowedDateService = borrowedDateService;
        this.customerService = customerService;
        this.mailService = mailService;
    }

    @RequestMapping(value = "bookResume{car_id}", method = RequestMethod.GET)
    public String showCustomerResume(Model model, Customer customer, BorrowedDate borrowedDate,
            @RequestParam(value = "car_id") Long carId) {
        carById = carService.findById(carId);
        model.addAttribute("borrowedDate", borrowedDate);
        model.addAttribute("cust", customer);
        model.addAttribute("carById", carById);
        return "bookResume";
    }

    @RequestMapping(value = "bookResume", method = RequestMethod.POST)
    public String completeAll(Customer customer, BorrowedDate borrowedDate, SessionStatus status) {
        borrowedDateService.save(borrowedDate);
        customerService.save(customer);
        mailService.sendMail(customer, borrowedDate, carById);
        status.setComplete();
        return "redirect:/";
    }
}
