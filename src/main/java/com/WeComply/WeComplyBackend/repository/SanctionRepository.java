package com.WeComply.WeComplyBackend.service;

import com.WeComply.WeComplyBackend.entity.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanctionRepository extends JpaRepository<Sanction, Integer> {
}
