package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.dto.AttendanceResponse;
import com.WeComply.WeComplyBackend.entity.Attendance;
import com.WeComply.WeComplyBackend.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> calculateTotalAbsences() {
        List<Attendance> allAttendances = attendanceRepository.findAll();

        for (Attendance attendance : allAttendances) {
            int totalAbsences = 0;

            if (attendance.getInAm() == null || attendance.getOutAm() == null) {
                totalAbsences++;
            }

            if (attendance.getInPm() == null || attendance.getOutPm() == null) {
                totalAbsences++;
            }

            attendance.setAbsentInMorning(totalAbsences > 0 ? 1 : 0);
            attendance.setAbsentInAfternoon(totalAbsences > 1 ? 1 : 0);

            int total = attendance.getAbsentInMorning() + attendance.getAbsentInAfternoon();
            attendance.setTotalAbsences(total);

            // Update the attendance in the database
            attendanceRepository.save(attendance);
        }

        return allAttendances;
    }

    @Override
    public List<AttendanceResponse> getAttendanceSummary(Integer studentId) {
        List<Attendance> allAttendances = attendanceRepository.findByStudentId(studentId);

        return allAttendances.stream()
                .map(this::mapToAttendanceSummaryDTO)
                .collect(Collectors.toList());
    }

    private AttendanceResponse mapToAttendanceSummaryDTO(Attendance attendance) {
        AttendanceResponse dto = new AttendanceResponse();
        dto.setDate(attendance.getDate());
        dto.setEventName(attendance.getEvent().getEventName());
        dto.setTotalAbsences(attendance.getTotalAbsences());
        return dto;
    }

}
