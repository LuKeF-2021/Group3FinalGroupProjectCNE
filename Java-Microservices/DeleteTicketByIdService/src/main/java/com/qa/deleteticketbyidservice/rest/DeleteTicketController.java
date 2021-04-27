package com.qa.deleteticketbyidservice.rest;

import com.qa.deleteticketbyidservice.service.DeleteTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/tickets")
@RestController
public class DeleteTicketController {
	
	private DeleteTicketService service;

	public DeleteTicketController(DeleteTicketService service) {
		super();
		this.service = service;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (this.service.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
