package com.qa.ticketManager.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.ticketManager.persistence.domain.Tickets;

@Repository
public interface TicketRepo extends JpaRepository<Tickets, Long> {
	
	

}
