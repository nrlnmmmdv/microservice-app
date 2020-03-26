package com.nurlan.ticketservice.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Açıq"),
    IN_PROGRESS("Davam Edən"),
    RESOLVED("Bitmiş"),
    CLOSED("Bağlanmış");

    private String label;

    TicketStatus(String label){
        this.label = label;
    }
}
