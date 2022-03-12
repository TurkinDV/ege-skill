package com.result.service.resultService.exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.result.service.resultService.question.Question;
import com.result.service.resultService.question.QuestionResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExamResultController.class)
public class ExamResultControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ExamResultRepository examResultRepository;

    @MockBean
    ExamResultService examResultService;

    QuestionResult QUESTION_RESULT_1 = new QuestionResult(1L, new Question(1L, "Answer"), "Answer1", false);
    QuestionResult QUESTION_RESULT_2 = new QuestionResult(1L, new Question(2L, "Answer2"), "Answer2", true);
    QuestionResult QUESTION_RESULT_3 = new QuestionResult(1L, new Question(3L, "Answer3"), "Answer3", true);

    ExamResult EXAM_RESULT_1 = new ExamResult(
            1L,
            new Exam(1L, List.of(1,2)),
            1,
            2,
            "Exam1",
            List.of(QUESTION_RESULT_1, QUESTION_RESULT_2)
    );
    ExamResult EXAM_RESULT_2 = new ExamResult(
            1L,
            new Exam(2L, List.of(2,3)),
            2,
            2,
            "Exam1",
            List.of(QUESTION_RESULT_2, QUESTION_RESULT_3)
    );

    @Test
    public void getHistoryResultTest() throws Exception {
        Mockito.when(examResultRepository.findAllbyUserId(1)).thenReturn(List.of(EXAM_RESULT_1, EXAM_RESULT_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/exam_result/history/1/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
    }

    // TODO: POST api/v1/exam_result/
}
