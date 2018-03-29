package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestSingletonBean testSingletonBean;

    @RequestMapping(value = "/test1")
    @ResponseBody
    public String test1() {
        testService.doJob();
        return "ok";
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public String test2() {
        testSingletonBean.doJob();
        return "ok";
    }
}
