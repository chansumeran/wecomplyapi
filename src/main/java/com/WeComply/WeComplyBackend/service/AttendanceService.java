package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.dto.AttendanceResponse;
import com.WeComply.WeComplyBackend.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    void calculateTotalAbsences();

    List<AttendanceResponse> getAttendanceSummary(Integer studentId);

}
