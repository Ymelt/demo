package com.example.config;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    private boolean tof;
    private String token;
    private Object object;

    public Result(boolean tof, String token, Object object) {
        this.tof = tof;
        this.token = token;
        this.object = object;
    }

    public Result(boolean tof, Object object) {
        this.tof = tof;
        this.object = object;
    }
}
