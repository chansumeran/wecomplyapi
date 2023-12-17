package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getFilteredStudents(String deptCode, String course, String yearLevel);

    List<Student> getStudentsByEvent(String eventName);

    Optional<Student> getStudentWithSanction(int studentID);

}
