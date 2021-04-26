package com.qa.ticketManager.rest;

import java.util.List;

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

import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.service.TicketService;


@RequestMapping("/tickets")
@RestController
public class TicketController {
	
	private TicketService service;

	public TicketController(TicketService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public Tickets create(@RequestBody Tickets newTicket) {
		return this.service.create(newTicket);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Tickets>> getTickets(){
		return ResponseEntity.ok(this.service.getTickets());
	}
	
	@GetMapping("/read/{id}")
    public ResponseEntity<Tickets> readById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.readTicketsById(id));
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (this.service.deleteTicket(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Tickets> updateById(@PathVariable Long id, @RequestBody Tickets ticket) {
        Tickets updatedObject = this.service.updateTicket(ticket, id);
        return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
    }
	

}
