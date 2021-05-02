package com.qa.ticketgateway.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ticketgateway.persistence.domain.Ticket;
import com.qa.ticketgateway.service.TicketGatewayService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TicketGatewayController.class)
@AutoConfigureMockMvc
public class TicketGatewayControllerIntegrationTest {

//    @Autowired
//    private MockMvc mockMVC;
//
//    @MockBean
//    private TicketGatewayService service;
//
//    @MockBean
//    private RestTemplate rest;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
//    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
//    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false, "This is a new solution", "Medium", "Cohort2");
//
//
//    @Test
//    void testReadById() throws Exception {
//        mockMVC.perform(post("/account/register").contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(TICKET1)).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andDo(print());
//    }
}
