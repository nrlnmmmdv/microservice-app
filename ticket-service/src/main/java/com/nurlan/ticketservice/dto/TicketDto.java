package com.nurlan.ticketservice.dto;

import com.nurlan.ticketservice.entity.PriorityType;
import com.nurlan.ticketservice.entity.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder // Builder design pattern yarada bilmek ucun
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private String id;

    private String description;

    private String notes;

    private String assignee;

    private LocalDate ticketDate;

    private String priorityType;

    private String ticketStatus;
}
