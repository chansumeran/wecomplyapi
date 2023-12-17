package com.WeComply.WeComplyBackend.repository;

import com.WeComply.WeComplyBackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
