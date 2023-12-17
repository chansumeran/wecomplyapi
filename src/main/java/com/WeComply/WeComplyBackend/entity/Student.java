package com.WeComply.WeComplyBackend.entity;

import com.WeComply.WeComplyBackend.dto.StudentResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_initial")
    private String middleInitial;

    private String sex;

    @Column(name = "dept_code")
    private String departmentCode;

    private String course;

    @Column(name = "year_level")
    private Integer yearLevel;

    @Column(name = "is_officer")
    private Boolean isOfficer;

    @Column(name = "total_absences")
    private Integer totalAbsences;

    @Column(name = "sanction_id")
    private Integer sanctionId;

    @ManyToOne
    @JoinColumn(name = "dept_code", referencedColumnName = "dept_code", insertable = false, updatable = false, nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "sanction_id", referencedColumnName = "sanction_id", insertable = false, updatable = false)
    private Sanction sanction;

}
