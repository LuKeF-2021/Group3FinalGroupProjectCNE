package com.qa.ticketManager.service;

import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.persistence.repo.TicketRepo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static java.time.Clock.*;

import java.time.*;
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

    @Mock
    private Clock clock;

    private Clock fixedClock;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    private final Tickets TICKET1 = new Tickets(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);

    private final Tickets TICKET1_CHANGE = new Tickets(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false);

    private final List<Tickets> TICKETS_LIST = List.of(TICKET1);

    @BeforeAll
    public void initMocks() {
        fixedClock = fixed(DATE_TIME.toInstant(ZoneOffset.ofHours(0)), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

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
