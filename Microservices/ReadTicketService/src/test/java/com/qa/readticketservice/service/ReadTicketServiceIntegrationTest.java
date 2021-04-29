package com.qa.readticketservice.service;

import com.qa.readticketservice.persistence.domain.Ticket;
import com.qa.readticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static java.time.Clock.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReadTicketServiceIntegrationTest {

    @Autowired
    private TicketRepo repo;

    @Autowired
    private ReadTicketService service;

    @Mock
    private Clock clock;

    private Clock fixedClock;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);

    private final List<Ticket> TICKETS_LIST = List.of(TICKET1);

    @BeforeEach
    void setup() {
        fixedClock = fixed(DATE_TIME.toInstant(ZoneOffset.ofHours(0)), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();

        this.repo.flush();
        this.repo.saveAll(TICKETS_LIST);
    }

    @Test
    void testReadById(){
        assertThat(this.service.readById(TICKET1.getId())).isEqualTo(TICKET1);
    }

    @AfterAll
    void cleanUp() {
        this.repo.flush();
    }

}
