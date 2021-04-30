package com.qa.ticketgateway.rest;

import com.qa.ticketgateway.persistence.domain.Ticket;
import com.qa.ticketgateway.service.TicketGatewayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/tickets")
@RestController
@CrossOrigin
public class TicketGatewayController {
    private final TicketGatewayService service;

    public TicketGatewayController(TicketGatewayService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Ticket> create(@RequestBody Ticket newTicket) {
        return new ResponseEntity<>(this.service.create(newTicket), HttpStatus.CREATED);
    }

    @GetMapping("/readAll")

    public ResponseEntity<List<Ticket>> readAll(){
        return ResponseEntity.ok(this.service.readAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Ticket> readById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(this.service.readById(id));
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (this.service.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateById(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket updatedObject = this.service.updateById(ticket, id);
        return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
    }
}
