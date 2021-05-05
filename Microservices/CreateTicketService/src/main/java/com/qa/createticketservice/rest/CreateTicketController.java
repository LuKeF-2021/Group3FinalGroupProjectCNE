package com.qa.createticketservice.rest;

import com.qa.createticketservice.persistence.domain.Ticket;

import com.qa.createticketservice.service.CreateTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CreateTicketController {

    private CreateTicketService service;

    public CreateTicketController(CreateTicketService service) {
        super();
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Ticket> create(@RequestBody Ticket newTicket) {
        return new ResponseEntity<>(this.service.create(newTicket), HttpStatus.CREATED);
    }


}
