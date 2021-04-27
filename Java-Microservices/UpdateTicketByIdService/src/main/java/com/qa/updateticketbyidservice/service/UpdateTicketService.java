package com.qa.updateticketbyidservice.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.qa.updateticketbyidservice.persistence.domain.Tickets;
import com.qa.updateticketbyidservice.persistence.repo.TicketRepo;
import com.qa.updateticketbyidservice.util.exceptions.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



@Service
public class UpdateTicketService {
	
	private TicketRepo repo;


	@Autowired
	public UpdateTicketService(TicketRepo repo) {
		super();
		this.repo = repo;
	}

	//TODO Make into microservice
	private boolean ticketExists(Long id) {
		return repo.findById(id).isPresent();
	}


	public Tickets updateById(Tickets ticket, Long id) {
		if (ticketExists(id)) {
			Tickets toUpdate = this.repo.findById(id).get();
			toUpdate.setName(ticket.getName());
			toUpdate.setDescription(ticket.getDescription());
			toUpdate.setTitle(ticket.getTitle());
			toUpdate.setComplete(ticket.getComplete());
			return this.repo.save(toUpdate);
		}
		return null;
		
	}
}
