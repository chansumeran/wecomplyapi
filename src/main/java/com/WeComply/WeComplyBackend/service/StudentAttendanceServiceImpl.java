package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.dto.AttendanceResponse;
import com.WeComply.WeComplyBackend.dto.StudentAttendanceSummaryResponse;
import com.WeComply.WeComplyBackend.dto.StudentResponse;
import com.WeComply.WeComplyBackend.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAttendanceServiceImpl {
    @Autowired
    private StudentService studentService;

    @Autowired
    private AttendanceService attendanceService;

    public Optional<StudentAttendanceSummaryResponse> getStudentAndAttendanceSummary(Integer studentId) {
        Optional<Student> studentWithSanction = studentService.getStudentWithSanction(studentId);

        if (studentWithSanction.isEmpty()) {
            return Optional.empty();
        }

        Student student = studentWithSanction.get();

        String fullName = student.getFirstName() + " " + student.getLastName();
        String info = student.getDepartmentCode() + ", " + student.getCourse() + "-" + student.getYearLevel();
        String sanctionDescription = student.getSanction().getDescription();

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFullName(fullName);
        studentResponse.setInfo(info);
        studentResponse.setSanctionDescription(sanctionDescription);

        List<AttendanceResponse> attendanceSummaryList = attendanceService.getAttendanceSummary(studentId);

        StudentAttendanceSummaryResponse combinedResponse = new StudentAttendanceSummaryResponse();
        combinedResponse.setStudentResponse(studentResponse);
        combinedResponse.setAttendanceSummaryList(attendanceSummaryList);

        return Optional.of(combinedResponse);
    }
}
