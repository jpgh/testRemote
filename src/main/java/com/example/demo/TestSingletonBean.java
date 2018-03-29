package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TestSingletonBean {

    private Integer i = 0;

    public void doJob() {
        System.out.println("task not async - " + i);
        i = i + 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doJobSync() {
        System.out.println("task1 - " + i + "  -  " + System.currentTimeMillis());
        i = i + 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doJobSync2();
    }

    public void doJobSync2() {
        System.out.println("task2 - " + i + "  -  " + System.currentTimeMillis());
        doJobSync();
        i = i + 1;
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer count() {
        return i;
    }
}
