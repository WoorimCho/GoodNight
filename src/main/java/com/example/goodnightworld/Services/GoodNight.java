package com.example.goodnightworld.Services;
import org.springframework.stereotype.Service;

@Service
public class GoodNight implements GoodNightService{

    @Override
    public void goodNight() {
        System.out.println("Good Night");
    }

}
