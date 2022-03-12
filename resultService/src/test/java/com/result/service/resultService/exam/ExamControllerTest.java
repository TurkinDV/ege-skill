package com.result.service.resultService.exam;

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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExamController.class)
public class ExamControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ExamRepository examRepository;

    @MockBean
    ExamService examService;

    Exam EXAM_1 = new Exam(1L, List.of(1,2));
    Exam EXAM_2 = new Exam(2L, List.of(2,3));
    Exam EXAM_3 = new Exam(3L, List.of(1,3));

    @Test
    public void createNewExamsTest() throws Exception {
        List<Exam> exams = List.of(EXAM_1, EXAM_2, EXAM_3);

        Mockito.when(examRepository.saveAll(exams)).thenReturn(exams);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/exam/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(exams));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }


    @Test
    public void createNewExamsFailTest() throws Exception {

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/exam/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().is4xxClientError());
    }
}
