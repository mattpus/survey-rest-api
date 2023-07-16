package com.mattpus.surveyrestapi.survey;

import java.util.List;

public class Question {
    private String id;
    private String description;
    private List<String> options;
    private String corrcetAnswer;

    public Question() {

    }

    public Question(String id, String description, List<String> options, String corrcetAnswer) {
        this.id = id;
        this.description = description;
        this.options = options;
        this.corrcetAnswer = corrcetAnswer;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrcetAnswer() {
        return corrcetAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", options=" + options +
                ", corrcetAnswer='" + corrcetAnswer + '\'' +
                '}';
    }
}
