package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.entity.Student;
import com.WeComply.WeComplyBackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    @Override
//    public List<Student> getFilteredStudents(String eventName, String deptCode, String course, Integer yearLevel) {
//        return studentRepository.findByDynamicFilters(eventName, deptCode, course, yearLevel);
//    }

    @Override
    public Optional<Student> getStudentWithSanction(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> getFilteredStudents(String deptCode, String course, String yearLevel) {
        return studentRepository.findByDynamicFilters(deptCode, course, yearLevel);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
//
//    @Override
//    public List<Student> getStudentsByEvent(String eventName) {
//        return studentRepository.findByEventFilter(eventName);
//    }
}
