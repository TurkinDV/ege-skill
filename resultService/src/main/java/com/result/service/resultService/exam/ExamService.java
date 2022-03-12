package com.result.service.resultService.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public void addNewExams(List<Exam> exams){
        examRepository.saveAll(exams);
    }
}
