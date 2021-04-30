package com.qa.deleteticketservice.rest;

import com.qa.deleteticketservice.service.DeleteTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tickets")
@RestController
@CrossOrigin
public class DeleteTicketController {

    private DeleteTicketService service;

    public DeleteTicketController(DeleteTicketService service) {
        super();
        this.service = service;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        if (this.service.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}