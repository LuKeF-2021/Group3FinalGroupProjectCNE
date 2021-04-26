package com.qa.ticketManager.service;

import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.persistence.repo.TicketRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicketServiceIntegrationTest {

    @Autowired
    private TicketRepo repo;

    @Autowired
    private TicketService service;

    private final Tickets TICKET1 = new Tickets(1L,"Name Naming", LocalDateTime.now().withNano(0).withSecond(0), "Description of ticket","Title of ticket", false);

    private final Tickets TICKET1_CHANGE = new Tickets(1L,"Name2", LocalDateTime.now().withNano(0).withSecond(0), "Name description","hjsdfklgjsdlfkjsd", false);

    private final List<Tickets> TICKETS_LIST = List.of(TICKET1);

    @BeforeEach
    void setup() {
        this.repo.flush();
        this.repo.saveAll(TICKETS_LIST);
    }

    @Test
    void createTest() throws Exception{
        assertThat(this.service.create(TICKET1)).isEqualTo(TICKET1);
    }

    @Test
    void readAllTest() throws Exception{
        assertThat(this.service.getTickets()).isEqualTo(TICKETS_LIST);
    }

    @Test
    void readByIdTest() throws Exception{
        assertThat(this.service.readTicketsById(TICKET1.getId())).isEqualTo(TICKET1);
    }

    @Test
    void updateTest() throws Exception{
        assertThat(this.service.updateTicket(TICKET1_CHANGE, TICKET1.getId()))
                .isEqualTo(TICKET1_CHANGE);
    }

    @Test
    void deleteTest() throws Exception {
        assertThat(this.service.deleteTicket(TICKET1.getId())).isTrue();
    }
}
