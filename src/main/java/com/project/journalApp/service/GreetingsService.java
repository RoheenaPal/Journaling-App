package com.project.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.journalApp.api.response.GreetingsResponse;
import com.project.journalApp.cache.AppCache;
import com.project.journalApp.constants.Placeholders;

@Service
public class GreetingsService {
    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public GreetingsResponse getWeather(String city) {
        GreetingsResponse greetingsResponse = redisService.get("weather_of_" + city, GreetingsResponse.class);
        if (greetingsResponse != null) {
            return greetingsResponse;
        } else {
            String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString())
                    .replace(Placeholders.CITY, city)
                    .replace(Placeholders.API_KEY, apiKey);
            ResponseEntity<GreetingsResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null,
                    GreetingsResponse.class);
            GreetingsResponse body = response.getBody();
            if (body != null) {
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }

    }
}
