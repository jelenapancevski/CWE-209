package com.rbs.cwe209.model;

public class Question {
    private Long _id;
    private String email;
    private String question;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question(Long _id, String email, String question) {
        this._id = _id;
        this.email = email;
        this.question = question;
    }
}
