package com.qa.ticketgateway.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ticketgateway.persistence.domain.Ticket;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;


import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.web.client.RestTemplate;


import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;



//@AutoConfigureMockMvc
//@WebMvcTest(value = TicketGatewayService.class)
//@SpringBootTest(classes = {RestTemplate.class, TicketGatewayService.class})
@RunWith(SpringRunner.class)
@WebMvcTest(TicketGatewayService.class)
@AutoConfigureMockMvc
public class TicketGatewayServiceUnitTest {

    @Autowired
    private TicketGatewayService service;

    @MockBean
    private RestTemplate rest;

//    private final TicketGatewayService service = new TicketGatewayService(rest);

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");

//    @BeforeEach
//    void setup() {
//        service = new TicketGatewayService(rest);
//
//    }
//
//    @Test
//    void testReadById(){
//        when(this.rest.getForObject("https://read-ticket-api/tickets/read/"+TICKET1.getId(),Ticket.class))
//                .thenReturn(TICKET1);
//        assertThat(this.service.readById(TICKET1.getId())).isEqualTo(TICKET1);
//        verify(this.rest, times(1)).getForObject("https://read-ticket-api/tickets/read/"+TICKET1.getId(),Ticket.class);
//    }
}
