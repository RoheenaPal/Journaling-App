package com.project.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;

public class UserDetailsServiceImplTests {
    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Test
    @ExtendWith(MockitoExtension.class)
    void loadUserByUsernameTests() {
        when(userRepository.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(User.builder().username("Ram").password("encrypted").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsServiceImpl.loadUserByUsername("Ram");
        assertNotNull(user);
    }
}
