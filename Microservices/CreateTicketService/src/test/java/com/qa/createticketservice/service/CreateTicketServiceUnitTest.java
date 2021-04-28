package com.qa.createticketservice.service;
import com.qa.createticketservice.persistence.domain.Ticket;
import com.qa.createticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ActiveProfiles(profiles = "test")
public class CreateTicketServiceUnitTest {
    @Autowired
    private CreateTicketService service;

    @MockBean
    private TicketRepo repo;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);

    @Test
    void testCreate(){
        when(this.repo.save(TICKET1)).thenReturn(TICKET1);
        assertThat(this.service.create(TICKET1)).isEqualTo(TICKET1);
        verify(this.repo, times(1)).save(TICKET1);
    }
}
