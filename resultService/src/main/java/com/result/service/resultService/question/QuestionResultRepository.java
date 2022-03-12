package com.result.service.resultService.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionResultRepository  extends JpaRepository<QuestionResult, Long> {

    @Query(value = "SELECT e.questions FROM exam_questions AS e WHERE e.exam_id = ?1", nativeQuery = true)
    List<Integer> findAllQuestionsbyExamId(long examId);

    @Query(value = "SELECT * FROM question_result AS qr WHERE qr.user_id = ?1 AND qr.question_id in ?2", nativeQuery = true)
    List<QuestionResult> findAllQuestionResult(long userId, List<Integer> questions);
}
