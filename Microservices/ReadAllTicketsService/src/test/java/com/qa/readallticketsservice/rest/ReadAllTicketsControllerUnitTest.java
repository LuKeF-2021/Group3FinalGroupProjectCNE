package com.qa.readallticketsservice.rest;

import com.qa.readallticketsservice.persistence.domain.Ticket;
import com.qa.readallticketsservice.service.ReadAllTicketsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class ReadAllTicketsControllerUnitTest {
    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);

    @Autowired
    private ReadAllTicketsController controller;
    @MockBean
    private ReadAllTicketsService service;

    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false);
    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false);

    private final List<Ticket> TICKETS_LIST = List.of(TICKET1,TICKET2);

    @Test
    void testReadAll(){
        when(this.service.readAll()).thenReturn(TICKETS_LIST);
        assertThat(this.controller.readAll().getBody().isEmpty()).isFalse();
        verify(this.service, times(1)).readAll();
    }
}
