package com.WeComply.WeComplyBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @Column(name = "event_id")
    private Integer eventID;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date")
    private LocalDate eventDate;
}
