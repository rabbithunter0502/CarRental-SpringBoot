package com.ducltd00750.service;

import com.ducltd00750.entity.AvailableCarsResult;
import com.ducltd00750.entity.BorrowedDate;
import com.ducltd00750.repository.BorrowedDateRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BorrowedDateServiceImpl implements BorrowedDateService {

    private BorrowedDateRepository borrowedDateRepository;

    public BorrowedDateServiceImpl(BorrowedDateRepository borrowedDateRepository) {
        this.borrowedDateRepository = borrowedDateRepository;
    }

    @Override
    public BorrowedDate findByCustomerId(Long id) {
        return this.borrowedDateRepository.findByCustomerId(id);
    }

    @Override
    public BorrowedDate findByCarId(Long id) {
        return this.borrowedDateRepository.findByCarId(id);
    }

    @Override
    public List<BorrowedDate> findAll() {
        return this.borrowedDateRepository.findAll();
    }

    @Override
    public void save(BorrowedDate borrowedDate) {
        this.borrowedDateRepository.save(borrowedDate);
    }

    @Override
    public List<AvailableCarsResult> checkAvailableCars(Calendar startDate, Calendar endDate) {
        return this.borrowedDateRepository.checkAvailableCars(startDate, endDate);
    }

    @Override
    public List<AvailableCarsResult> checkAvailableCarById(Calendar startDate, Calendar endDate, Long id) {
        return this.borrowedDateRepository.checkAvailableCarById(startDate, endDate, id);
    }

    @Override
    public long countDays(BorrowedDate borrowedDate) {
        long days;
        Calendar start = borrowedDate.getStartDate();
        Calendar end = borrowedDate.getEndDate();
        days = daysBetween(start, end);
        return days;
    }

    private long daysBetween(Calendar startDate, Calendar endDate) {
        endDate.add(Calendar.DATE, 1);
        long end = endDate.getTimeInMillis();
        long start = startDate.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
    }
}
