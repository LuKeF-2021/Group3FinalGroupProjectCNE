package com.qa.readticketservice.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.qa.readticketservice.persistence.domain.Ticket;
import com.qa.readticketservice.persistence.repo.TicketRepo;
import com.qa.readticketservice.util.exceptions.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



@Service
public class ReadTicketService {
	
	private TicketRepo repo;

	@Autowired
	public ReadTicketService(TicketRepo repo) {
		super();
		this.repo = repo;
	}


	public Ticket readById(Long id) {
		return repo.findById(id).orElseThrow(()-> new TicketNotFoundException(id.toString()));
	}
	

}
