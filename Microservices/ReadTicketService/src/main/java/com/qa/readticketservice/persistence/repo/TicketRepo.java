package com.qa.readticketservice.persistence.repo;


import com.qa.readticketservice.persistence.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
