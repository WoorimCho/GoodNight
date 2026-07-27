package com.example.goodnightworld.Services;
import org.springframework.stereotype.Service;

@Service
public class GoodNight implements GoodNightService{
    private boolean asleep = false;


    @Override
    public boolean goodNight() {
        asleep = !asleep;
        System.out.println("Good Night - sleeping now " + asleep);
        return asleep;
    }
    @Override
    public boolean isBedtimeSafe(String snackName) {
        java.util.List<String> heavy = java.util.List.of("chips", "pizza", "chocolate", "soda", "coffee");
        return heavy.stream().noneMatch(h -> snackName.toLowerCase().contains(h));
    }
}
