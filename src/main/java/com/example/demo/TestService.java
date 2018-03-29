package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class TestService {

    private Integer i = 0;

    public void doJob() {
        i = i + 1;
    }

    public Integer count() {
        return i;
    }
}
