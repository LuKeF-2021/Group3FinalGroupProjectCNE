package com.qa.updateticketbyidservice.rest;

import java.util.List;

import com.qa.updateticketbyidservice.persistence.domain.Tickets;
import com.qa.updateticketbyidservice.service.UpdateTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/tickets")
@RestController
public class UpdateTicketController {
	
	private UpdateTicketService service;

	public UpdateTicketController(UpdateTicketService service) {
		super();
		this.service = service;
	}

    @PutMapping("/update/{id}")
    public ResponseEntity<Tickets> updateById(@PathVariable Long id, @RequestBody Tickets ticket) {
        Tickets updatedObject = this.service.updateById(ticket, id);
        return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
    }
	

}
