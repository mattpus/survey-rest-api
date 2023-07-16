package com.mattpus.surveyrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SurveyRestApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(SurveyRestApiApplication.class, args);
        System.out.println("build successful!");
    }
}
