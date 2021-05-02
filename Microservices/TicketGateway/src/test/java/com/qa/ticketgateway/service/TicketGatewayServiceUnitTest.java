package com.qa.ticketgateway.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ticketgateway.persistence.domain.Ticket;
import org.junit.Before;
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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.web.client.support.RestGatewaySupport;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.net.URI;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");


    @Test
    void testReadById(){
        when(this.rest.getForObject("https://read-ticket-api/tickets/read/"+TICKET1.getId(),Ticket.class))
                .thenReturn(TICKET1);
        assertThat(this.service.readById(TICKET1.getId())).isEqualTo(TICKET1);
        verify(this.rest, times(1)).getForObject("https://read-ticket-api/tickets/read/"+TICKET1.getId(),Ticket.class);
    }
}
