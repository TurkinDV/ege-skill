package com.result.service.resultService.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/question/")
public class QuestionController {


    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public void createQuestions(@RequestBody List<Question> questions){
        questionService.createQuestions(questions);
    }
}
