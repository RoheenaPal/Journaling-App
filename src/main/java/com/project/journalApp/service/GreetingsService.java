package com.project.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.journalApp.api.response.GreetingsResponse;

@Service
public class GreetingsService {
    @Value("${weather.api.key}")
    private String apiKey;

    private static final String API = "https://api.openweathermap.org/data/2.5/weather?q=CITY&units=metric&appid=API_KEY";

    @Autowired
    private RestTemplate restTemplate;

    public GreetingsResponse getWeather(String city) {
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);
        ResponseEntity<GreetingsResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null,
                GreetingsResponse.class);
        GreetingsResponse body = response.getBody();
        return body;
    }
}
