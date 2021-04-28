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
        System.out.println("1" + repo.findAll());
        if (ticketExists(id)) {
            System.out.println("2" + repo.findById(id));
            this.repo.deleteById(id);
            return true;
        } else {
            System.out.println("4" + repo.findById(id));
            return false;
        }
    }

    private boolean ticketExists(Long id) {
        return repo.findById(id).isPresent();
    }

}
