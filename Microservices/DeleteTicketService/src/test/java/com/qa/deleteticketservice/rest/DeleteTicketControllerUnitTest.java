package com.qa.deleteticketservice.rest;


import com.qa.deleteticketservice.persistence.domain.Ticket;
import com.qa.deleteticketservice.service.DeleteTicketService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class DeleteTicketControllerUnitTest {
    @Autowired
    private DeleteTicketController controller;
    @MockBean
    private DeleteTicketService service;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);

    @Test
    void testDeleteById(){
        when(this.service.deleteById(TICKET1.getId())).thenReturn(false);
        assertThat(this.controller.deleteById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        verify(this.service, Mockito.times(1)).deleteById(TICKET1.getId());

        when(this.service.deleteById(TICKET1.getId())).thenReturn(true);
        assertThat(this.controller.deleteById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        verify(this.service, Mockito.times(2)).deleteById(TICKET1.getId());
    }
}
