package com.qa.createticketservice.persistence.repo;

import com.qa.createticketservice.persistence.domain.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepo extends JpaRepository<Tickets, Long> {
	
	

}
