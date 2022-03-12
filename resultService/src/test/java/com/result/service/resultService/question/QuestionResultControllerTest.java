package com.result.service.resultService.question;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionResultController.class)
public class QuestionResultControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    QuestionResultRepository questionResultRepository;

    @MockBean
    QuestionResultService questionResultService;

    Question QUESTION_1 = new Question(1L, "Answer1");
    Question QUESTION_2 = new Question(2L, "Answer2");

    QuestionResult QUESTION_RESULT_1 = new QuestionResult(1L, QUESTION_1, "Answer1", true);
    QuestionResult QUESTION_RESULT_2 = new QuestionResult(1L, QUESTION_2, "Answer2", true);


    @Test
    public void getResultExamTest() throws Exception {
        Mockito.when(questionResultRepository.findAllQuestionResult(1, List.of(1, 2)))
                .thenReturn(List.of(QUESTION_RESULT_1, QUESTION_RESULT_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/result/1/1/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
    }
}
