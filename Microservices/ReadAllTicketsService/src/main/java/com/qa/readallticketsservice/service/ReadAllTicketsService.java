package com.qa.readallticketsservice.service;

import com.qa.readallticketsservice.persistence.domain.Ticket;
import com.qa.readallticketsservice.persistence.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class ReadAllTicketsService {
	
	private TicketRepo repo;


	@Autowired
	public ReadAllTicketsService(TicketRepo repo) {
		super();
		this.repo = repo;
	}


	public List<Ticket> readAll(){
		return repo.findAll();
	}
	


}
