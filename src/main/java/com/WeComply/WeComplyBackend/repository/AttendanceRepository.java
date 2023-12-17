package com.WeComply.WeComplyBackend.repository;

import com.WeComply.WeComplyBackend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByStudentId(Integer studentId);

}
