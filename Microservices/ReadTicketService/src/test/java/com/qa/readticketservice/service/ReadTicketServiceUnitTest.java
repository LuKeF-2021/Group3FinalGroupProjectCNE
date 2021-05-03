package com.qa.readticketservice.service;

import com.qa.readticketservice.persistence.domain.Ticket;
import com.qa.readticketservice.persistence.repo.TicketRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class ReadTicketServiceUnitTest {
    @Autowired
    private ReadTicketService service;

    @MockBean
    private TicketRepo repo;

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false, "This is a new solution", "Medium", "Cohort2");

    @Test
    void testReadById(){
        when(this.repo.findById(TICKET1.getId())).thenReturn(Optional.of(TICKET1));
        assertThat(this.service.readById(TICKET1.getId())).isEqualTo(TICKET1);
        verify(this.repo, times(1)).findById(TICKET1.getId());
    }

}
