package com.qa.createticketservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static java.time.Clock.fixed;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class CreateTicketControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper toJson;

    @Autowired
    private TicketRepo repo;

    @Mock
    private Clock clock;

    private Clock fixedClock;

    private final static LocalDateTime DATE_TIME = LocalDateTime.now().withNano(0).withSecond(0);

    private final Ticket TICKET1 = new Ticket(1L, "Name Naming", DATE_TIME, "Description of ticket", "Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
    private final Ticket TICKET2 = new Ticket(2L, "Name2", DATE_TIME, "Name description", "hjsdfklgjsdlfkjsd", false, "This is a new solution", "Medium", "Cohort2");
    private final Ticket TICKET3 = new Ticket(3L, "sdfsdf", DATE_TIME, "Name dfgdfgdfg", "asdasda", false, "This is a new solution", "Medium", "Cohort2");


    private final List<Ticket> TICKETS_LIST = List.of(TICKET1, TICKET2);

    @BeforeEach
    public void setup() {
        fixedClock = fixed(DATE_TIME.toInstant(ZoneOffset.ofHours(0)), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
        this.repo.flush();
        this.repo.saveAll(TICKETS_LIST);
    }

    @Test
    void testCreate() throws Exception {
        this.mock
                .perform(post("/tickets/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.toJson.writeValueAsString(TICKET3)))
                .andExpect(status().isCreated())
                .andExpect(content().json(this.toJson.writeValueAsString(TICKET3)));
    }
}