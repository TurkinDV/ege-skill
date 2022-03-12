package com.result.service.resultService.exam;

import com.result.service.resultService.question.QuestionResult;
import com.result.service.resultService.question.QuestionResultService;
import com.result.service.resultService.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ExamResultService {

    private final ExamResultRepository examResultRepository;
    private final QuestionResultService questionResultService;
    private final QuestionService questionService;


    @Autowired
    public ExamResultService(ExamResultRepository examResultRepository, QuestionResultService questionResultService, QuestionService questionService) {
        this.examResultRepository = examResultRepository;
        this.questionResultService = questionResultService;
        this.questionService = questionService;
    }

    public List<ExamResult> getHistoryResult(long user_id){
        return examResultRepository.findAllbyUserId(user_id);
    }

    @Transactional
    public void postResultExam(ExamResult examResult){
        Long userId = examResult.getUserId();
        ExamResult examResult1 = examResultRepository.save(examResult);

        int correctlyAnswers = 0;
        for (QuestionResult questionResult:examResult.getQuestions()){
            String correctlyAnswer = questionService.getQuestion(questionResult.getQuestion().getId());
            Boolean correctly = correctlyAnswer.equals(questionResult.getAnswer());
            if (correctly){
                correctlyAnswers ++;
            }
            questionResultService.createQuestionResult(
                    new QuestionResult(
                            userId,
                            questionResult.getQuestion(),
                            questionResult.getAnswer(),
                            correctly,
                            examResult1
                            )
                    );
        }
        examResult1.setAllQuestions(examResult.getQuestions().size());
        examResult1.setCorrectAnswers(correctlyAnswers);
        examResultRepository.save(examResult1);
    }
}
