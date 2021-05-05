package com.qa.readticketservice.rest;


import com.qa.readticketservice.persistence.domain.Ticket;
import com.qa.readticketservice.service.ReadTicketService;
import com.qa.readticketservice.util.exceptions.TicketNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReadTicketController {
	
	private ReadTicketService service;

	public ReadTicketController(ReadTicketService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Ticket> readById(@PathVariable Long id) {

		try {
			return ResponseEntity.ok(this.service.readById(id));
		} catch (Exception e) {
			return null;
		}
	}
}
