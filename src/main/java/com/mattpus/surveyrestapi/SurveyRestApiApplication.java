package com.mattpus.surveyrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class SurveyRestApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(SurveyRestApiApplication.class, args);
        System.out.println("build successful!");
    }
}
