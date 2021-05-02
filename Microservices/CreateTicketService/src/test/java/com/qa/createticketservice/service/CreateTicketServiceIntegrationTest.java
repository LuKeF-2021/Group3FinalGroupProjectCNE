package com.qa.createticketservice.service;

import com.qa.createticketservice.persistence.domain.Ticket;
import com.qa.createticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static java.time.Clock.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateTicketServiceIntegrationTest {

    @Autowired
    private TicketRepo repo;

    @Autowired
    private CreateTicketService service;

    @Mock
    private Clock clock;

    private Clock fixedClock;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11, 11, 30);

    private final Ticket TICKET1 = new Ticket(1L, "Name Naming", DATE_TIME, "Description of ticket", "Title of ticket", false, "This is a new solution", "Medium", "Cohort2");

    private final Ticket TICKET2 = new Ticket(2L, "Name2", DATE_TIME, "Name description", "hjsdfklgjsdlfkjsd", false, "This is a new solution", "Medium", "Cohort2");

    private final List<Ticket> TICKETS_LIST = List.of(TICKET1);

    @BeforeEach
    public void setup() {
        fixedClock = fixed(DATE_TIME.toInstant(ZoneOffset.ofHours(0)), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
        this.repo.flush();
        this.repo.saveAll(TICKETS_LIST);
    }

    @Test
    void testCreate(){
        assertThat(this.service.create(TICKET2)).isEqualTo(TICKET2);
    }

}
