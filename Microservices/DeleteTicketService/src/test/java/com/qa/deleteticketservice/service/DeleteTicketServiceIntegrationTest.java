package com.qa.deleteticketservice.service;

import com.qa.deleteticketservice.persistence.domain.Ticket;
import com.qa.deleteticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static java.time.Clock.*;




@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeleteTicketServiceIntegrationTest {

    @Autowired
    private TicketRepo repo;

    @Autowired
    private DeleteTicketService service;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    private final Ticket TICKET1 = new Ticket(2L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");

    private final List<Ticket> TICKETS_LIST = List.of(TICKET1);


    @BeforeEach
    void setup() {
        this.repo.saveAndFlush(TICKET1);

    }

    @Test
    void testDeleteById(){
        assertThat(this.service.deleteById(TICKET1.getId())).isTrue();
    }
}
