package com.qa.readticketservice.rest;

import com.qa.readticketservice.persistence.domain.Ticket;
import com.qa.readticketservice.service.ReadTicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class ReadTicketControllerUnitTest {
    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    @Autowired
    private ReadTicketController controller;
    @MockBean
    private ReadTicketService service;

    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");

    @Test
    void testReadById(){
        when(this.service.readById(TICKET1.getId())).thenReturn(TICKET1);
        assertThat(this.controller.readById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(TICKET1, HttpStatus.OK));
        verify(this.service, times(1)).readById(TICKET1.getId());
    }
}
