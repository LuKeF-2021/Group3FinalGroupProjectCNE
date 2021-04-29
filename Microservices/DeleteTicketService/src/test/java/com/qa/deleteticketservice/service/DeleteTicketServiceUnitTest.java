package com.qa.deleteticketservice.service;


import com.qa.deleteticketservice.persistence.domain.Ticket;
import com.qa.deleteticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class DeleteTicketServiceUnitTest {
    @Autowired
    private DeleteTicketService service;

    @MockBean
    private TicketRepo repo;


    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");

    @Test
    void testDelete(){
        when(this.repo.findById(TICKET1.getId())).thenReturn(Optional.of(TICKET1));
        assertThat(this.service.deleteById(TICKET1.getId())).isEqualTo(true);
        verify(this.repo, times(1)).findById(TICKET1.getId());
        verify(this.repo, times(1)).deleteById(TICKET1.getId());

    }
}
