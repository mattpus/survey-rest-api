package com.mattpus.surveyrestapi.bean;

public class HelloBean {
    private String message;

    @Override
    public String toString() {
        return "Hello world [message=" + message + "]";
    }

    public HelloBean(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
