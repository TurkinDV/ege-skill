package com.result.service.resultService.question;

import com.result.service.resultService.exam.ExamResult;

import javax.persistence.*;

@Entity
@Table
public class QuestionResult {
    @Id
    @SequenceGenerator(
            name = "sequence_question_result",
            sequenceName = "sequence_question_result",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_question_result"
    )
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private String answer;
    private Boolean correctly;

    @ManyToOne
    @JoinColumn(name="exam_result_id")
    private ExamResult examResult;

    public QuestionResult() {
    }

    public QuestionResult(Long userId, Question question, String answer, Boolean correctly, ExamResult examResult) {
        this.userId = userId;
        this.question = question;
        this.answer = answer;
        this.correctly = correctly;
        this.examResult = examResult;
    }

    public QuestionResult(Long userId, Question question, String answer, Boolean correctly) {
        this.userId = userId;
        this.question = question;
        this.answer = answer;
        this.correctly = correctly;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUser_id(Long userId) {
        this.userId = userId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrectly() {
        return correctly;
    }

    public void setCorrectly(Boolean correctly) {
        this.correctly = correctly;
    }

}
