package com.result.service.resultService.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/exam_result/")
public class ExamResultController {

    private final ExamResultService examResultService;

    @Autowired
    public ExamResultController(ExamResultService examResultService) {
        this.examResultService = examResultService;
    }

    @GetMapping(path = "history/{user_id}/")
    public List<ExamResult> getHistoryResult(@PathVariable("user_id") long userId){
        return examResultService.getHistoryResult(userId);
    }

    @PostMapping
    public void postResultExam(@RequestBody ExamResult examResult){
        examResultService.postResultExam(examResult);
    }


}
