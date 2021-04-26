package com.qa.ticketManager.rest;

import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.service.TicketService;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import static org.mockito.Mockito.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class TicketControllerUnitTest {
    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    @Autowired
    private TicketController controller;
    @MockBean
    private TicketService service;

    private final Tickets TICKET1 = new Tickets(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);
    private final Tickets TICKET2 = new Tickets(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false);
    private final Tickets TICKET1_CHANGE = new Tickets(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", true);

    private final List<Tickets> TICKETS_LIST = List.of(TICKET1,TICKET2);

    @Test
    void testCreate(){
        when(this.service.create(TICKET1)).thenReturn(TICKET1);
        assertThat(this.controller.create(TICKET1)).isEqualTo(new ResponseEntity<>(TICKET1, HttpStatus.CREATED));
        verify(this.service, Mockito.times(1)).create(TICKET1);
    }

//    @Test
//    void createTest() throws Exception {
//        when(this.service.create(test_review)).thenReturn(test_review);
//        assertThat(new ResponseEntity<Reviews>(test_review, HttpStatus.CREATED))
//                .isEqualTo(this.controller.create(test_review));
//        verify(this.service, atLeastOnce()).create(test_review);
//    }

    @Test
    void testReadAll(){
        when(this.service.getTickets()).thenReturn(TICKETS_LIST);
        assertThat(this.controller.getTickets().getBody().isEmpty()).isFalse();
        verify(this.service, Mockito.times(1)).getTickets();
    }

    @Test
    void testUpdateById(){
        when(this.service.updateTicket(TICKET1_CHANGE, TICKET1.getId())).thenReturn(TICKET1_CHANGE);
        assertThat(this.controller.updateById( TICKET1.getId(), TICKET1_CHANGE)).isEqualTo(new ResponseEntity<>(TICKET1_CHANGE, HttpStatus.ACCEPTED));
        verify(this.service, Mockito.times(1)).updateTicket(TICKET1_CHANGE, TICKET1.getId());
    }

    @Test
    void testDeleteById(){
        Mockito.when(this.service.deleteTicket(TICKET1.getId())).thenReturn(false);
        Assertions.assertThat(this.controller.deleteById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        Mockito.verify(this.service, Mockito.times(1)).deleteTicket(TICKET1.getId());

        Mockito.when(this.service.deleteTicket(TICKET1.getId())).thenReturn(true);
        Assertions.assertThat(this.controller.deleteById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        Mockito.verify(this.service, Mockito.times(2)).deleteTicket(TICKET1.getId());
    }

    @Test
    void testReadById(){
        Mockito.when(this.service.readTicketsById(TICKET1.getId())).thenReturn(TICKET1);
        Assertions.assertThat(this.controller.readById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(TICKET1, HttpStatus.OK));
        Mockito.verify(this.service, Mockito.times(1)).readTicketsById(TICKET1.getId());
    }
}
