package com.qa.createticketservice.rest;

import com.qa.createticketservice.persistence.domain.Ticket;
import com.qa.createticketservice.service.CreateTicketService;
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
public class CreateTicketControllerUnitTest {
    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11, 11, 30);

    @Autowired
    private CreateTicketController controller;
    @MockBean
    private CreateTicketService service;

    private final Ticket TICKET1 = new Ticket(1L, "Name Naming", DATE_TIME, "Description of ticket", "Title of ticket", false);

    @Test
    void testCreate() {
        when(this.service.create(TICKET1)).thenReturn(TICKET1);
        assertThat(this.controller.create(TICKET1)).isEqualTo(new ResponseEntity<>(TICKET1, HttpStatus.CREATED));
        verify(this.service, times(1)).create(TICKET1);
    }
}
