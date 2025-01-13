package com.project.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {
    @Autowired
    private EmailService emailService;

    @Value("${test.mail}")
    private String testMail;

    @Test
    void testSendMail() {
        emailService.sendEmail(testMail,
                "Testing Java mail sender",
                "Test mail");
    }
}
