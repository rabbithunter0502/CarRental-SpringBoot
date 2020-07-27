package com.ducltd00750.service;

import com.ducltd00750.entity.BorrowedDate;
import com.ducltd00750.entity.Car;
import com.ducltd00750.entity.Customer;

public interface MailService {

    void sendMailTest();

    void sendMail(Customer customer, BorrowedDate borrowedDate, Car car);
}
