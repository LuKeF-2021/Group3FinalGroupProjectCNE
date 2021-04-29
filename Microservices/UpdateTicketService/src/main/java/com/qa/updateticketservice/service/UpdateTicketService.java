package com.qa.updateticketservice.service;

import com.qa.updateticketservice.persistence.domain.Ticket;
import com.qa.updateticketservice.persistence.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
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


	public Ticket updateById(Ticket ticket, Long id) {
		if (ticketExists(id)) {
			Ticket toUpdate = this.repo.findById(id).get();
			toUpdate.setName(ticket.getName());
			toUpdate.setDescription(ticket.getDescription());
			toUpdate.setTitle(ticket.getTitle());
			toUpdate.setComplete(ticket.getComplete());
			toUpdate.setSolution(ticket.getSolution());
			toUpdate.setUrgency(ticket.getUrgency());
			toUpdate.setCohort(ticket.getCohort());
			return this.repo.save(toUpdate);
		}
		return null;
		
	}
}
