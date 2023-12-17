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
public class Sanction {

    @Id
    @Column(name = "sanction_id")
    private Integer sanctionId;

    private String description;

    private Integer triggerValue;

    private String frequency;

}
