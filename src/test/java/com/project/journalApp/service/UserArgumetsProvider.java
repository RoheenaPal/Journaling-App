package com.project.journalApp.service;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.project.journalApp.entity.User;

public class UserArgumetsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().username("Testuser1").password("testuser1").build()),
                Arguments.of(User.builder().username("Testuser2").password("").build()));
    }

}
