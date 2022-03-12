package com.result.service.resultService.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionResultService {

    private final QuestionResultRepository questionResultRepository;

    @Autowired
    public QuestionResultService(QuestionResultRepository questionResultRepository) {
        this.questionResultRepository = questionResultRepository;
    }

    public List<QuestionResult> getResultExam(long userId, long examId){
        // TODO: подключить репозиторий questionRepository и сделать поиск из него
        List<Integer> questions = questionResultRepository.findAllQuestionsbyExamId(examId);
        return questionResultRepository.findAllQuestionResult(userId, questions);
    }

    public void createQuestionResult(QuestionResult questionResult){
      questionResultRepository.save(questionResult);
    }

}
