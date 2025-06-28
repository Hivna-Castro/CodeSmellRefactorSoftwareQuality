package org.example.studycards;

public class Card {
    private String question;
    private String answer;

    public Card(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void edit(String question, String answer) {
        setQuestion(question);
        setAnswer(answer);
    }

    public boolean contains(String keyword) {
        return question.contains(keyword) || answer.contains(keyword);
    }

    public String format(int id) {
        return "[id: " + id + "] Question: " + question + " Answer: " + answer;
    }
}