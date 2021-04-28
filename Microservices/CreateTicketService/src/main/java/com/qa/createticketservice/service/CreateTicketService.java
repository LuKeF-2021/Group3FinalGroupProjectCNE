package com.qa.createticketservice.service;

import com.qa.createticketservice.persistence.domain.Ticket;
import com.qa.createticketservice.persistence.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class CreateTicketService {

    private TicketRepo repo;

    @Autowired
    private Clock clock;

    @Autowired
    public CreateTicketService(TicketRepo repo) {
        super();
        this.repo = repo;
    }

    public LocalDateTime getTime(){
        return LocalDateTime.now(clock).withNano(0).withSecond(0);
    }

    public Ticket create(Ticket ticket) {
//		TODO: Use time service here
        ticket.setCreatedAt(getTime());
        Ticket created = this.repo.save(ticket);
        return created;
    }

}
