package com.WeComply.WeComplyBackend.repository;

import com.WeComply.WeComplyBackend.entity.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanctionRepository extends JpaRepository<Sanction, Integer> {
}
