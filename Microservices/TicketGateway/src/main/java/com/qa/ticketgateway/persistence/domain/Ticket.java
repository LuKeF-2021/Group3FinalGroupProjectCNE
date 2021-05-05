package com.qa.ticketgateway.persistence.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private Long id;

    private String name;

    private LocalDateTime createdAt;

    private String description;

    private String title;

    private Boolean complete;

    private String solution;

    private String urgency;

    private String cohort;
}
