package com.result.service.resultService.exam;

import com.result.service.resultService.question.QuestionResult;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exam_result")
public class ExamResult {

    @Id
    @SequenceGenerator(
            name = "sequence_exam_result",
            sequenceName = "sequence_exam_result",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_exam_result"
    )
    private Long id;
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Column(name = "correct_answers")
    private Integer correctAnswers;

    @Column(name = "all_questions")
    private Integer allQuestions;

    private String name;

    @OneToMany(mappedBy="examResult")
    private List<QuestionResult> questions;

    public ExamResult() {
    }

    public ExamResult(Long userId, Exam exam, Integer correctAnswers, Integer allQuestions, String name, List<QuestionResult> questions) {
        this.userId = userId;
        this.exam = exam;
        this.correctAnswers = correctAnswers;
        this.allQuestions = allQuestions;
        this.name = name;
        this.questions = questions;
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Integer getAllQuestions() {
    return allQuestions;
    }

    public void setAllQuestions(Integer all_questions) {
        this.allQuestions = all_questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionResult> getQuestions() {
        return questions;
    }
}
