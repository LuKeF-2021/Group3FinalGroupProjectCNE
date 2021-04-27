package com.qa.readallticketsservice.rest;

import java.util.List;

import com.qa.readallticketsservice.persistence.domain.Tickets;
import com.qa.readallticketsservice.service.ReadAllTicketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/tickets")
@RestController
public class ReadAllTicketsController {
	
	private ReadAllTicketsService service;

	public ReadAllTicketsController(ReadAllTicketsService service) {
		super();
		this.service = service;
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Tickets>> readAll(){
		return ResponseEntity.ok(this.service.readAll());
	}
	


}
