package com.qa.ticketManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.persistence.repo.TicketRepo;
import com.qa.ticketManager.util.exceptions.TicketNotFoundException;

@Service
public class TicketService {
	
	private TicketRepo repo;
    
	@Autowired
	public TicketService(TicketRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<Tickets> getTickets(){
		return repo.findAll();
	}
	
	public Tickets readTicketsById(Long id) {
		return repo.findById(id).orElseThrow(()-> new TicketNotFoundException(id.toString()));
	}
	
	public Tickets create(Tickets ticket) {
		ticket.setCreatedAt(java.time.LocalDateTime.now());
		Tickets created = this.repo.save(ticket);
		return created;	
	}
	
	public boolean deleteTicket(Long id) {
		if (ticketExists(id)) {
			repo.deleteById(id);
		}
		return repo.existsById(id);
	}
	
	private boolean ticketExists(Long id) {
		return repo.findById(id).isPresent();
	}
	
	public Tickets updateTicket(Tickets ticket, Long id) {
		if (ticketExists(id)) {
			Tickets toUpdate = this.repo.findById(id).get();
			toUpdate.setFirstName(ticket.getFirstName());
			toUpdate.setLastName(ticket.getLastName());
			toUpdate.setDescription(ticket.getDescription());
			toUpdate.setTitle(ticket.getTitle());
			return repo.save(ticket);
		}
		return null;
		
	}
}
