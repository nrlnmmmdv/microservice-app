package com.nurlan.ticketservice.entity;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Təcili"),
    LOW("Az"),
    HIGH("Yüksək");

    private String label;

    PriorityType(String label){
        this.label = label;
    }
}
