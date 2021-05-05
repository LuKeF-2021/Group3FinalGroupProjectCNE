package com.qa.ticketgateway.service;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.*;


@ActiveProfiles(profiles = "test")

@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TicketGatewayServiceIntegrationTest {
}
