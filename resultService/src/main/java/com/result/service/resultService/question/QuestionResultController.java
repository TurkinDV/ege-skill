package com.result.service.resultService.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/result/")
public class QuestionResultController {


    private final QuestionResultService questionResultService;

    @Autowired
    public QuestionResultController(QuestionResultService questionResultService) {
        this.questionResultService = questionResultService;
    }

    @GetMapping(path = "{user_id}/{exam_id}")
    public List<QuestionResult> getResultExam(@PathVariable("user_id") long userId, @PathVariable("exam_id") long examId){
        return questionResultService.getResultExam(userId, examId);
    }
}
