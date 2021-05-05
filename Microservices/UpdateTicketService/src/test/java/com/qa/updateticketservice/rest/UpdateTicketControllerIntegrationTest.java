package com.qa.updateticketservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.updateticketservice.persistence.domain.Ticket;
import com.qa.updateticketservice.persistence.repo.TicketRepo;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class UpdateTicketControllerIntegrationTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper toJson;

    @Autowired
    private TicketRepo repo;

    private final static LocalDateTime DATE_TIME = LocalDateTime.now().withNano(0).withSecond(0);

    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd",false, "This is a new solution", "Medium", "Cohort2");

    private final Ticket TICKET1_CHANGE = new Ticket(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd",true, "This is a new solution", "Medium", "Cohort2");

    private final List<Ticket> TICKETS_LIST = List.of(TICKET1,TICKET2);


    @BeforeEach
    public void setup() {
        this.repo.flush();
        this.repo.saveAll(TICKETS_LIST);

    }

    @Test
    void testUpdateById() throws Exception {
        this.mock
                .perform(put("/tickets/update/"+TICKET1.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.toJson.writeValueAsString(TICKET1_CHANGE)))
                .andExpect(status().isAccepted())
                .andExpect(content().json(this.toJson.writeValueAsString(TICKET1_CHANGE)));
    }

}
