package com.WeComply.WeComplyBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attendance {

    @Id
    @Column(name = "attendance_id")
    private Integer attendanceID;

    @Column(name = "attendance_date")
    private LocalDate date;

    @Column(name = "in_am")
    private LocalTime inAm;

    @Column(name = "out_am")
    private LocalTime outAm;

    @Column(name = "in_pm")
    private LocalTime inPm;

    @Column(name = "out_pm")
    private LocalTime outPm;

    @Column(name = "absent_in_morning")
    private Integer absentInMorning;

    @Column(name = "absent_in_afternoon")
    private Integer absentInAfternoon;

    @Column(name = "total_absences")
    private Integer totalAbsences;

    @Column(name = "student_id")
    private Integer studentId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    private Event event;

}
