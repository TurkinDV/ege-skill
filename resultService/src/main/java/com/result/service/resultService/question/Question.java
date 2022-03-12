package com.result.service.resultService.question;

import javax.persistence.*;

@Entity
@Table
public class Question {

    @Id
    private Long id;
    private String answer;

    public Question() {
    }

    public Question(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getId() {
        return id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
