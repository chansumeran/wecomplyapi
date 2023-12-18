package com.WeComply.WeComplyBackend.repository;

import com.WeComply.WeComplyBackend.entity.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SanctionRepository extends JpaRepository<Sanction, Integer> {

    Optional<Sanction> findBySanctionId(int sanctionId);
}
