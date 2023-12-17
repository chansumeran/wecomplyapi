package com.WeComply.WeComplyBackend.repository;

import com.WeComply.WeComplyBackend.dto.StudentResponse;
import com.WeComply.WeComplyBackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // ADVANCED FILTER
    @Query(value = "SELECT s.* FROM student s JOIN Department d ON s.dept_code = d.dept_code WHERE (:departmentCode IS NULL OR d.dept_code = :departmentCode) AND (:course IS NULL OR s.course = :course) AND (:yearLevel IS NULL OR s.year_level = :yearLevel)", nativeQuery = true)
    List<Student> findByDynamicFilters(@Param("departmentCode") String deptCode, @Param("course") String course, @Param("yearLevel") String yearLevel);

    // FILTER BY EVENT
    @Query(value = "SELECT student.* " +
            "FROM student " +
            "JOIN attendance ON student.student_id = attendance.student_id " +
            "JOIN event ON event.event_id = attendance.event_id " +
            "WHERE event.event_name = :eventName", nativeQuery = true)
    List<Student> findByEventFilter(String eventName);

}
