package com.qa.ticketgateway.service;

import com.qa.ticketgateway.persistence.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class TicketGatewayService {

    private final RestTemplate rest;

    @Autowired
    public TicketGatewayService(RestTemplate rest) {
        super();
        this.rest = rest;
    }


    public Ticket[] readAll(){
        return this.rest.getForObject("https://read-all-tickets-api/tickets/readAll", Ticket[].class);

    }

    public Ticket readById(Long id) {
        return this.rest.getForObject("https://read-ticket-api/tickets/read/"+id, Ticket.class);

    }

    public Ticket create(Ticket ticket) {
        Ticket newTicket = rest.postForObject("https://create-ticket-api/tickets/create", ticket, Ticket.class);

        return newTicket;
    }

    public Boolean deleteById(Long id) {
        String url = "https://delete-ticket-api/tickets/delete/"+id;
        try {
            this.rest.delete(url);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Ticket updateById(Long id, Ticket ticket) {
        HttpEntity<Ticket> request = new HttpEntity<>(ticket);
        ResponseEntity<Ticket> response = this.rest.exchange("https://update-ticket-api/tickets/update/"+id, HttpMethod.PUT, request, Ticket.class);
        Ticket updatedTicket = response.getBody();
        return(updatedTicket);
    }

}
