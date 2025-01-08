package com.project.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void findByUsernameTests() {
        assertNotNull(userRepository.findByUsername("Ram"));
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumetsProvider.class)
    public void saveNewUserTests(User user) {
        assertTrue(userService.saveNewUser(user));
    }
}
