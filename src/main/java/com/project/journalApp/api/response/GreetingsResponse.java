package com.project.journalApp.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingsResponse {
    public Main main;

    @Getter
    @Setter
    public class Main {
        private double temp;
        private double feels_like;
    }
}
