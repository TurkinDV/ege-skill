package com.result.service.resultService.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {

    @Query(value = "SELECT * FROM exam_result AS er WHERE er.user_id = ?1", nativeQuery = true)
    List<ExamResult> findAllbyUserId(long userId);

}
