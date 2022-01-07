package com.valtech.Junit.dummy;

import com.valtech.Junit.service.EmailService;

public class EmailServiceDummy implements EmailService {
   @Override
    public void sendEmail() {
    throw new AssertionError("email service is not implemented");
    }
}
