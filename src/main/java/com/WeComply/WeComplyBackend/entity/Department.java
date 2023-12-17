package com.WeComply.WeComplyBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @Column(name = "dept_code")
    private String departmentCode;

    @Column(name = "dept_name")
    private String departmentName;
}