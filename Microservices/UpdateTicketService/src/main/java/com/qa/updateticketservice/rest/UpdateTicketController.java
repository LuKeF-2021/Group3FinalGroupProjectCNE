package com.qa.updateticketservice.rest;

import com.qa.updateticketservice.persistence.domain.Ticket;
import com.qa.updateticketservice.service.UpdateTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/tickets")
@RestController
@CrossOrigin
public class UpdateTicketController {
	
	private UpdateTicketService service;

	public UpdateTicketController(UpdateTicketService service) {
		super();
		this.service = service;
	}

    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateById(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket updatedObject = this.service.updateById(ticket, id);
        return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
    }
	

}
