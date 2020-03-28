package com.nurlan.ticketservice.service.impl;

import com.nurlan.client.AccountServiceClient;
import com.nurlan.client.contract.AccountDto;
import com.nurlan.ticketservice.dto.TicketDto;
import com.nurlan.ticketservice.entity.PriorityType;
import com.nurlan.ticketservice.entity.Ticket;
import com.nurlan.ticketservice.entity.TicketStatus;
import com.nurlan.ticketservice.entity.es.TicketModel;
import com.nurlan.ticketservice.repository.TicketRepository;
import com.nurlan.ticketservice.repository.es.TicketElasticRepository;
import com.nurlan.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketElasticRepository ticketElasticRepository;
    @Autowired
     TicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountServiceClient accountServiceClient;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {

        //Ticket Entity
        Ticket ticket = new Ticket();

        //Account API - dan yoxla
        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());
        accountDtoResponseEntity.getBody().getNameSurname();

        //ticket.setAssignee();
        if(ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Decription bosh olmamalidir!");

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

        //mysql create
         ticket = ticketRepository.save(ticket);

        //TicketModel Object
        TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        //elastic create
        ticketElasticRepository.save(ticketModel);

        //return object
        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
