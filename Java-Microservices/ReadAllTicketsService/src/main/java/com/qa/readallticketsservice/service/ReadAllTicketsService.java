package com.qa.readallticketsservice.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.qa.readallticketsservice.persistence.domain.Tickets;
import com.qa.readallticketsservice.persistence.repo.TicketRepo;
import com.qa.readallticketsservice.util.exceptions.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;




@Service
public class ReadAllTicketsService {
	
	private TicketRepo repo;


	@Autowired
	public ReadAllTicketsService(TicketRepo repo) {
		super();
		this.repo = repo;
	}


	public List<Tickets> readAll(){
		return repo.findAll();
	}
	


}
