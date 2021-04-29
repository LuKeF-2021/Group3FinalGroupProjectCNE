package com.qa.updateticketservice.rest;

import com.qa.updateticketservice.persistence.domain.Ticket;
import com.qa.updateticketservice.service.UpdateTicketService;
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
public class UpdateTicketControllerUnitTest {
    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    @Autowired
    private UpdateTicketController controller;
    @MockBean
    private UpdateTicketService service;

    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
    private final Ticket TICKET1_CHANGE = new Ticket(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", true, "This is a new solution", "Medium", "Cohort2");

    @Test
    void testUpdateById(){
        when(this.service.updateById(TICKET1_CHANGE, TICKET1.getId())).thenReturn(TICKET1_CHANGE);
        assertThat(this.controller.updateById( TICKET1.getId(), TICKET1_CHANGE)).isEqualTo(new ResponseEntity<>(TICKET1_CHANGE, HttpStatus.ACCEPTED));
        verify(this.service, times(1)).updateById(TICKET1_CHANGE, TICKET1.getId());
    }
}
