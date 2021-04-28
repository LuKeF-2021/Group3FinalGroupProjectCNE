package com.qa.createticketservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.createticketservice.persistence.domain.Tickets;
import com.qa.createticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static java.time.Clock.fixed;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.time.*;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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


    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);


    private final Tickets TICKET1 = new Tickets(1L,"Name Naming", LocalDateTime.now().withNano(0).withSecond(0), "Description of ticket","Title of ticket", false);
    private final Tickets TICKET2 = new Tickets(2L,"Name2", LocalDateTime.now().withNano(0).withSecond(0), "Name description","hjsdfklgjsdlfkjsd",false);
    private final Tickets TICKET3 = new Tickets(3L,"sdfsdf", LocalDateTime.now().withNano(0).withSecond(0), "Name dfgdfgdfg","asdasda",false);

    private final Tickets TICKET1_CHANGE = new Tickets(1L,"Name2", LocalDateTime.now().withNano(0).withSecond(0), "Name description","hjsdfklgjsdlfkjsd",true);

    private final List<Tickets> TICKETS_LIST = List.of(TICKET1,TICKET2);

    @BeforeAll
    public void initMocks() {
        fixedClock = fixed(DATE_TIME.toInstant(ZoneOffset.ofHours(0)), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    @BeforeEach
    public void setup() {
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
