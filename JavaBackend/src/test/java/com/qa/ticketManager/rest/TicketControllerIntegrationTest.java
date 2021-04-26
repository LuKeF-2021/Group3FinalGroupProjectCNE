package com.qa.ticketManager.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.persistence.repo.TicketRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
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
public class TicketControllerIntegrationTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper toJson;

    @Autowired
    private TicketRepo repo;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);


    private final Tickets TICKET1 = new Tickets(1L,"Name Naming", LocalDateTime.now().withNano(0).withSecond(0), "Description of ticket","Title of ticket", false);
    private final Tickets TICKET2 = new Tickets(2L,"Name2", LocalDateTime.now().withNano(0).withSecond(0), "Name description","hjsdfklgjsdlfkjsd",false);
    private final Tickets TICKET3 = new Tickets(3L,"sdfsdf", LocalDateTime.now().withNano(0).withSecond(0), "Name dfgdfgdfg","asdasda",false);

    private final Tickets TICKET1_CHANGE = new Tickets(1L,"Name2", LocalDateTime.now().withNano(0).withSecond(0), "Name description","hjsdfklgjsdlfkjsd",true);

    private final List<Tickets> TICKETS_LIST = List.of(TICKET1,TICKET2);
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
    @Test
    void testReadAll() throws Exception {
        this.mock
                .perform(get("/tickets/readAll")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.toJson.writeValueAsString(TICKETS_LIST)));
    }

    @Test
    void testReadById() throws Exception {
        this.mock
                .perform(get("/tickets/read/"+TICKET1.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.toJson.writeValueAsString(TICKET1)));
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

    @Test
    void testDeleteById() throws Exception {
        this.mock
                .perform(delete("/tickets/delete/"+TICKET1.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
    @Test
    void testDeleteByIdWrong() throws Exception {
        this.mock
                .perform(delete("/tickets/delete/"+TICKET3.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
