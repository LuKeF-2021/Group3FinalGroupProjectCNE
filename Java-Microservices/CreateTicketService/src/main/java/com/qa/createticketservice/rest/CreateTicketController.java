package com.qa.createticketservice.rest;

import com.qa.createticketservice.persistence.domain.Tickets;
import com.qa.createticketservice.service.CreateTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/tickets")
@RestController
public class CreateTicketController {
	
	private CreateTicketService service;

	public CreateTicketController(CreateTicketService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Tickets> create(@RequestBody Tickets newTicket) {
		return new ResponseEntity<>(this.service.create(newTicket), HttpStatus.CREATED);
	}


}
