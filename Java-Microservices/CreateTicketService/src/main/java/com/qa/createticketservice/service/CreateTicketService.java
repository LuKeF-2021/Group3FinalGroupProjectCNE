package com.qa.createticketservice.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.qa.createticketservice.persistence.domain.Tickets;
import com.qa.createticketservice.persistence.repo.TicketRepo;
import com.qa.createticketservice.util.exceptions.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;




@Service
public class CreateTicketService {

	private TicketRepo repo;


	public Tickets create(Tickets ticket) {
//		ticket.setCreatedAt(getTime());
//		TODO: Use time service here
		ticket.setCreatedAt(java.time.LocalDateTime.now());
		Tickets created = this.repo.save(ticket);
		return created;	
	}

}
