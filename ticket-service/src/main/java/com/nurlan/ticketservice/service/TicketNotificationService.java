package com.nurlan.ticketservice.service;

import com.nurlan.ticketservice.entity.Ticket;
import org.springframework.stereotype.Service;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);


}
