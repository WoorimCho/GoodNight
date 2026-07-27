package com.example.goodnightworld.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snack {
    int id;
    String name;
    boolean bedtimeSafe;

    public Snack(){
        id = 0;
        name = "cookies";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBedtimeSafe() { return bedtimeSafe; }
    public void setBedtimeSafe(boolean bedtimeSafe) { this.bedtimeSafe = bedtimeSafe; }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
