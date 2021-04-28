package com.qa.updateticketservice.service;

import com.qa.updateticketservice.persistence.domain.Ticket;
import com.qa.updateticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class UpdateTicketServiceUnitTest {
    @Autowired
    private UpdateTicketService service;

    @MockBean
    private TicketRepo repo;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);
    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false);
    private final Ticket TICKET1_CHANGE = new Ticket(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", true);

    @Test
    void testUpdateById(){
        when(this.repo.findById(TICKET1.getId())).thenReturn(Optional.of(TICKET1));
        when(this.repo.save(TICKET1_CHANGE)).thenReturn(TICKET1_CHANGE);
        assertThat(this.service.updateById(TICKET1_CHANGE, TICKET1.getId())).isEqualTo(TICKET1_CHANGE);
        verify(this.repo, times(2)).findById(TICKET1.getId());
        verify(this.repo, times(1)).save(TICKET1_CHANGE);
    }
}
