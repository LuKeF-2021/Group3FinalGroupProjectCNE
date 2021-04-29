package com.qa.readallticketsservice.service;

import com.qa.readallticketsservice.persistence.domain.Ticket;
import com.qa.readallticketsservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class ReadAllTicketsServiceUnitTest {
    @Autowired
    private ReadAllTicketsService service;

    @MockBean
    private TicketRepo repo;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);
    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false);

    private final List<Ticket> TICKETS_LIST = List.of(TICKET1,TICKET2);

    @Test
    void testReadAll(){
        when(this.repo.findAll()).thenReturn(TICKETS_LIST);
        assertThat(this.service.readAll().isEmpty()).isFalse();
        verify(this.repo, times(1)).findAll();
    }
}
