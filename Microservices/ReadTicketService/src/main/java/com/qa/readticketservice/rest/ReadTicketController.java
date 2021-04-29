package com.qa.readticketservice.rest;


import com.qa.readticketservice.persistence.domain.Ticket;
import com.qa.readticketservice.service.ReadTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tickets")
@RestController
public class ReadTicketController {
	
	private ReadTicketService service;

	public ReadTicketController(ReadTicketService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/read/{id}")
    public ResponseEntity<Ticket> readById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.readById(id));
    }
}
