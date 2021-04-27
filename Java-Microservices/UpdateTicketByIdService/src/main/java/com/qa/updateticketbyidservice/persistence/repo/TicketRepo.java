package com.qa.updateticketbyidservice.persistence.repo;

import com.qa.updateticketbyidservice.persistence.domain.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepo extends JpaRepository<Tickets, Long> {

}
