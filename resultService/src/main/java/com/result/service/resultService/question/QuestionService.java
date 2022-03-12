package com.result.service.resultService.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestions(List<Question> questions){
        questionRepository.saveAll(questions);
    }

    public String getQuestion(long id){
        return questionRepository.findById(id).map(Question::getAnswer).orElse("");
    }

}
