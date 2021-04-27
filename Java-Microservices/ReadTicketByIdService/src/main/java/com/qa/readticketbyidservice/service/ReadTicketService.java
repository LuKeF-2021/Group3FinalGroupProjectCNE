package com.qa.readticketbyidservice.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.qa.readticketbyidservice.persistence.domain.Tickets;
import com.qa.readticketbyidservice.persistence.repo.TicketRepo;
import com.qa.readticketbyidservice.util.exceptions.TicketNotFoundException;
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


	public Tickets readById(Long id) {
		return repo.findById(id).orElseThrow(()-> new TicketNotFoundException(id.toString()));
	}
	

}
