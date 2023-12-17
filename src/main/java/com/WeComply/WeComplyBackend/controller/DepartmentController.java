package com.WeComply.WeComplyBackend.controller;

import com.WeComply.WeComplyBackend.entity.Department;
import com.WeComply.WeComplyBackend.service.DepartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> allDepartment = departmentService.getAllDepartment();
        return new ResponseEntity<>(allDepartment, HttpStatus.OK);
    }
}
