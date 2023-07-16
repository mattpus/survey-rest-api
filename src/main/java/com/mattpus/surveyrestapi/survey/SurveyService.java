package com.mattpus.surveyrestapi.survey;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class SurveyService {
    private static final List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question(
                "Question1",
                "Most Popular Cloud Platform Today", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"),
                "AWS");
        Question question2 = new Question(
                "Question2",
                "Fastest Growing Cloud Platform", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"),
                "Google Cloud");
        Question question3 = new Question(
                "Question3",
                "Most Popular DevOps Tool", Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"),
                "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

        Survey survey = new Survey(
                "Survey1",
                "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
    }

    public List<Survey> retrieveAllSurveys() {
        return surveys;
    }

    public Survey retrieveSurveyById(String id) {
        Predicate<? super Survey> predicate = survey -> survey.getId().equalsIgnoreCase(id);
        Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();

        return optionalSurvey.orElse(null);
    }

    public List<Question> retrieveSurveyQuestions(String id) {
        Survey survey = retrieveSurveyById(id);
        if (survey == null) return null;

        return survey.getQuestions();
    }

    public Question retrieveSpecificSurveyQuestion(String surveyId, String questionId) {
        List<Question> questions = retrieveSurveyQuestions(surveyId);
        if (questions == null) return null;
        Predicate<? super Question> predicate = (question -> question.getId().equalsIgnoreCase(questionId));
        Optional<Question> question = questions.stream().filter(predicate).findFirst();

        return question.orElse(null);
    }

    public String addNewSurveyQuestion(String surveyId, Question question) {
        List<Question> questions = retrieveSurveyQuestions(surveyId);
        String randomId = generateRandomId();
        question.setId(randomId);
        questions.add(question);
        return question.getId();
    }

    private static String generateRandomId() {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(32, secureRandom).toString();
    }

    public boolean deleteSurveyQuestion(String surveyId, String questionId) {
        List<Question> surveyQuestions = retrieveSurveyQuestions(surveyId);
        if (surveyQuestions == null)
            return false;
        Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);
        return surveyQuestions.removeIf(predicate);
    }
}
