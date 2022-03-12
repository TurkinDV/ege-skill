package com.result.service.resultService.question;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    QuestionRepository questionRepository;

    @MockBean
    QuestionService questionService;

    Question QUESTION_1 = new Question(1L, "Answer1");
    Question QUESTION_2 = new Question(2L, "Answer2");

    @Test
    public void createNewQuestionsTest() throws Exception {
        List<Question> questions = List.of(QUESTION_1, QUESTION_2);

        Mockito.when(questionRepository.saveAll(questions)).thenReturn(questions);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/question/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(questions));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }
}
