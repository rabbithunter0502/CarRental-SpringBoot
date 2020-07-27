package com.ducltd00750.service;

import com.ducltd00750.entity.AvailableCarsResult;
import com.ducltd00750.entity.BorrowedDate;

import java.util.Calendar;
import java.util.List;

public interface BorrowedDateService {

    List<AvailableCarsResult> checkAvailableCarById(Calendar startDate, Calendar endDate, Long id);

    List<AvailableCarsResult> checkAvailableCars(Calendar startDate, Calendar endDate);

    List<BorrowedDate> findAll();

    BorrowedDate findByCustomerId(Long id);

    BorrowedDate findByCarId(Long id);

    void save(BorrowedDate borrowedDate);

    long countDays(BorrowedDate borrowedDate);
}
