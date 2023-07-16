package com.mattpus.surveyrestapi.bean;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordResource {

    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("hello-world-bean/{name}")
    public HelloBean helloBean(@PathVariable String name) {
        return new HelloBean("Hello World");
    }
}
