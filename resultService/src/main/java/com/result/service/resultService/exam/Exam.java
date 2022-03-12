package com.result.service.resultService.exam;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class Exam {

    @Id
    private Long id;

    @ElementCollection
    private List<Integer> questions;

    public Exam() {
    }

    public Exam(Long id, List<Integer> questions) {
        this.id = id;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Integer> questions) {
        this.questions = questions;
    }
}
