package com.qa.deleteticketservice.service;

import com.qa.deleteticketservice.persistence.repo.TicketRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTicketService {

    private TicketRepo repo;



    @Autowired
    public DeleteTicketService(TicketRepo repo) {
        super();
        this.repo = repo;
    }


    public boolean deleteById(Long id) {
        if (ticketExists(id)) {
            this.repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private boolean ticketExists(Long id) {
        return repo.findById(id).isPresent();
    }

}
