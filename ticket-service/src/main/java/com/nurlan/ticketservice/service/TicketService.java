package com.nurlan.ticketservice.service;

import com.nurlan.ticketservice.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketDto save(TicketDto ticketDto);


    TicketDto update(TicketDto ticketDto);


    TicketDto getById(String ticketId);


    Page<TicketDto> getPagination(Pageable pageable);

}
