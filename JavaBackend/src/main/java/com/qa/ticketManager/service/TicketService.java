package com.qa.ticketManager.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.persistence.repo.TicketRepo;
import com.qa.ticketManager.util.exceptions.TicketNotFoundException;
import com.qa.ticketManager.util.config.*;

@Service
public class TicketService {
	
	private TicketRepo repo;

	@Autowired
	private Clock clock;

	public LocalDateTime getTime(){
		return LocalDateTime.now(clock).withNano(0).withSecond(0);
	}


	@Autowired
	public TicketService(TicketRepo repo) {
		super();
		this.repo = repo;
	}


	public List<Tickets> readAll(){
		return repo.findAll();
	}
	
	public Tickets readById(Long id) {
		return repo.findById(id).orElseThrow(()-> new TicketNotFoundException(id.toString()));
	}
	
	public Tickets create(Tickets ticket) {
		ticket.setCreatedAt(getTime());
//		ticket.setCreatedAt(java.time.LocalDateTime.now());
		Tickets created = this.repo.save(ticket);
		return created;	
	}
	
	public boolean deleteById(Long id) {
		System.out.println(ticketExists(id));
		if (ticketExists(id)) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
//		return !repo.existsById(id);
	}
	
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
			
			return this.repo.save(ticket);
		}
		return null;
		
	}
}
