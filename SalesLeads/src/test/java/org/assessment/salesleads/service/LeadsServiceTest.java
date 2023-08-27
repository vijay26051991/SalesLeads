package org.assessment.salesleads.service;


import org.assessment.salesleads.model.LeadsRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

public class LeadsServiceTest {
    LeadsService leadsService;

    RabbitTemplate rabbitTemplate;

    @Before
    public void setup() {
        rabbitTemplate = Mockito.mock(RabbitTemplate.class);
        leadsService = new LeadsService(rabbitTemplate);

    }

    @Test
    public void testHappyPath() {
        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", "", "abc@hidubai.com", "SMS", "I'm interested in chocolate flavoured cake of 3kg");

        leadsService.sendJsonMessage(leadsRequest);

        verify(rabbitTemplate, atLeast(1)).convertAndSend(null, null, leadsRequest);
    }

    @Test
    public void testMessageSentForBothMobileAndEmail() {
        LeadsRequest leadsRequest
                = new LeadsRequest(12345, "landing page", "Fazil", "+19876543210", "abc@hidubai.com", "SMS", "I'm interested in chocolate flavoured cake of 3kg");

        leadsService.sendJsonMessage(leadsRequest);

        verify(rabbitTemplate, atLeast(2)).convertAndSend(null, null, leadsRequest);
    }
}
