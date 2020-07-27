package com.ducltd00750.controller;

import com.ducltd00750.entity.AvailableCarsResult;
import com.ducltd00750.service.BorrowedDateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;

@Controller
public class IndexController {

    private BorrowedDateService borrowedDateService;

    public IndexController(BorrowedDateService borrowedDateService) {
        this.borrowedDateService = borrowedDateService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model,
            @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar startDate,
            @RequestParam(value = "end_date", defaultValue = "3000-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar endDate) {
        List<AvailableCarsResult> availableCars = borrowedDateService.checkAvailableCars(startDate, endDate);
        model.addAttribute("availableCars", availableCars);
        return "index";
    }
}
