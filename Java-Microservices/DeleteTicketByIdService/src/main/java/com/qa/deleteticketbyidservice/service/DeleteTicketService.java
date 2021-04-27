package com.qa.deleteticketbyidservice.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.qa.deleteticketbyidservice.persistence.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DeleteTicketService {
	
	private TicketRepo repo;



	@Autowired
	public DeleteTicketService(TicketRepo repo) {
		super();
		this.repo = repo;
	}


	public boolean deleteById(Long id) {
		System.out.println(ticketExists(id));
		if (ticketExists(id)) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	//TODO Put this in microservice
	private boolean ticketExists(Long id) {
		return repo.findById(id).isPresent();
	}


}
