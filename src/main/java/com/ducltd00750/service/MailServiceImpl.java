package com.ducltd00750.service;

import com.google.common.collect.Lists;
import com.ducltd00750.entity.BorrowedDate;
import com.ducltd00750.entity.Car;
import com.ducltd00750.entity.Customer;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * For using gmail as host:
 * -> https://www.google.com/settings/security/lesssecureapps
 * -> https://accounts.google.com/DisplayUnlockCaptcha
 */

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerService customerService;

    public MailServiceImpl(EmailService emailService, CustomerService customerService) {
        this.emailService = emailService;
        this.customerService = customerService;
    }

    @Override
    public void sendMail(Customer customer, BorrowedDate borrowedDate, Car car) {
        try {
            final Email email = DefaultEmail.builder().from(new InternetAddress("springcarrental@interia.pl"))
                    .to(Lists.newArrayList(new InternetAddress(customer.getLogin())))
                    .subject("Resume of your orders in Car Rental")
                    .body("Dear, " + customer.getFullName() + "\n\nThank You for borrowing our car."
                            + "\nHere is resume of your order." + "\nChosen car: " + car.getName() + ", "
                            + car.getPrice() + " EUR/day" + "\nBorrowed date range: " + borrowedDate.getStartDate()
                            + " - " + borrowedDate.getEndDate() + "\nTotal price: " + customer.getTotalPrice() + " EUR")
                    .encoding("UTF-8").build();
            emailService.send(email);
        } catch (AddressException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sendMailTest() {
        try {
            final Email email = DefaultEmail.builder().from(new InternetAddress("springcarrental@interia.pl"))
                    .to(Lists.newArrayList(new InternetAddress("ducltd00750@outlook.com")))
                    .subject("Resume of your orders in Car Rental").body("Dear, ").encoding("UTF-8").build();
            emailService.send(email);
        } catch (AddressException e) {
            System.out.println(e.getMessage());
        }

    }
}
