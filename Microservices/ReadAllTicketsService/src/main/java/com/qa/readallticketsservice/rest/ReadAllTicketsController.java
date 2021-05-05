package com.qa.readallticketsservice.rest;

import com.qa.readallticketsservice.persistence.domain.Ticket;
import com.qa.readallticketsservice.service.ReadAllTicketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController
@CrossOrigin
public class ReadAllTicketsController {
	
	private ReadAllTicketsService service;

	public ReadAllTicketsController(ReadAllTicketsService service) {
		super();
		this.service = service;
	}

	@GetMapping()
	public ResponseEntity<List<Ticket>> readAll(){
		return ResponseEntity.ok(this.service.readAll());
	}
	


}
