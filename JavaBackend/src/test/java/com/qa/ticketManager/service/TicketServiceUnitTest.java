package com.qa.ticketManager.service;

import com.qa.ticketManager.persistence.domain.Tickets;
import com.qa.ticketManager.persistence.repo.TicketRepo;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class TicketServiceUnitTest {
    @Autowired
    private TicketService service;

    @MockBean
    private TicketRepo repo;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Tickets TICKET1 = new Tickets(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);
    private final Tickets TICKET2 = new Tickets(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false);
    private final Tickets TICKET1_CHANGE = new Tickets(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", true);

    private final List<Tickets> TICKETS_LIST = List.of(TICKET1,TICKET2);

    @Test
    void testCreate(){
        when(this.repo.save(TICKET1)).thenReturn(TICKET1);
        assertThat(this.service.create(TICKET1)).isEqualTo(TICKET1);
        verify(this.repo, Mockito.times(1)).save(TICKET1);
    }


    @Test
    void testReadById(){
        when(this.repo.findById(TICKET1.getId())).thenReturn(Optional.of(TICKET1));
        Assertions.assertThat(this.service.readTicketsById(TICKET1.getId())).isEqualTo(TICKET1);
        verify(this.repo, Mockito.times(1)).findById(TICKET1.getId());
    }

    @Test
    void testReadAll(){
        when(this.repo.findAll()).thenReturn(TICKETS_LIST);
        Assertions.assertThat(this.service.getTickets().isEmpty()).isFalse();
        verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdateById(){
        when(this.repo.findById(TICKET1.getId())).thenReturn(Optional.of(TICKET1));
        when(this.repo.save(TICKET1_CHANGE)).thenReturn(TICKET1_CHANGE);
        Assertions.assertThat(this.service.updateTicket(TICKET1_CHANGE, TICKET1.getId())).isEqualTo(TICKET1_CHANGE);
        verify(this.repo, Mockito.times(2)).findById(TICKET1.getId());
        verify(this.repo, Mockito.times(1)).save(TICKET1_CHANGE);
    }

//    @Test
//    void testDeleteById(){
//        Mockito.when(this.repo.findById(TICKET1.getId())).thenReturn(Optional.of(TICKET1));
//        Mockito.when(this.repo.existsById(TICKET1.getId())).thenReturn(false);
//        Assertions.assertThat(this.service.deleteTicket(TICKET1.getId())).isEqualTo(true);
//        Mockito.verify(this.repo, Mockito.times(1)).findById(TICKET1.getId());
//        Mockito.verify(this.repo, Mockito.times(1)).deleteById(TICKET1.getId());
//        Mockito.verify(this.repo, Mockito.times(1)).existsById(TICKET1.getId());
//    }

    @Test
    void testDelete(){
        //TODO CHECK
        when(this.repo.findById(TICKET1.getId())).thenReturn(Optional.of(TICKET1));
        assertThat(this.service.deleteTicket(TICKET1.getId())).isEqualTo(true);
        verify(this.repo, atLeastOnce()).findById(TICKET1.getId());

    }
}
