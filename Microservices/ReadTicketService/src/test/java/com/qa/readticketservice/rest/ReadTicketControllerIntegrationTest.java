package com.qa.readticketservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.readticketservice.persistence.domain.Ticket;
import com.qa.readticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ReadTicketControllerIntegrationTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper toJson;

    @Autowired
    private TicketRepo repo;
    private final static LocalDateTime DATE_TIME = LocalDateTime.now().withNano(0).withSecond(0);

    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd",false, "This is a new solution", "Medium", "Cohort2");

    private final List<Ticket> TICKETS_LIST = List.of(TICKET1,TICKET2);

    @BeforeEach
    public void setup() {
        this.repo.saveAll(TICKETS_LIST);

    }

    @Test
    void testReadById() throws Exception {
        this.mock
                .perform(get("/"+TICKET1.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.toJson.writeValueAsString(TICKET1)));
    }

    @AfterEach
    void cleanUp() {
        this.repo.deleteAll();
    }

}
