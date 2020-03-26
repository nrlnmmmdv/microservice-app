package com.nurlan.ticketservice.api;

import com.nurlan.ticketservice.dto.TicketDto;
import com.nurlan.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ticket")
@RestController
@RequiredArgsConstructor
public class TicketApi {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.save(ticketDto));

    }

    @PutMapping
    public ResponseEntity<TicketDto> updateTicket(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.update(ticketDto));
    }

    @GetMapping
    public ResponseEntity<Page<TicketDto>> getAll(@PathVariable Pageable pageable) {
        return ResponseEntity.ok(ticketService.getPagination(pageable));

    }
}
