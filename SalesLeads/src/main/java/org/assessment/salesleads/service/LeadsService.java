package org.assessment.salesleads.service;

import org.assessment.salesleads.exception.SalesLeadsException;
import org.assessment.salesleads.model.LeadsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static org.assessment.salesleads.exception.ErrorCode.SERVICE_ERROR;

/**
 * Service class for the Leads.
 */
@Service
public class LeadsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadsService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.mobile.routing.key}")
    private String mobileRoutingKey;

    @Value("${rabbitmq.email.routing.key}")
    private String emailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public LeadsService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(LeadsRequest leadsRequest) {

        try {
            if (leadsRequest.getEmailId() != null) {
                rabbitTemplate.convertAndSend(exchange, emailRoutingKey, leadsRequest);
            }

            if (leadsRequest.getMobileNumber() != null) {
                rabbitTemplate.convertAndSend(exchange, mobileRoutingKey, leadsRequest);
            }
        } catch (final Exception ex) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), SERVICE_ERROR);
        }
    }

}
