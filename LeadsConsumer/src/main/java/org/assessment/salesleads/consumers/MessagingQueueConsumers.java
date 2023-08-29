package org.assessment.salesleads.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assessment.salesleads.factory.MobileCommunicationFactory;
import org.assessment.salesleads.factory.Notification;
import org.assessment.salesleads.model.LeadsModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessagingQueueConsumers {

    @RabbitListener(queues = "${leads.email.queue}")
    public void consumeEmailMessage(String message) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final LeadsModel leadsModel = objectMapper.readValue(message, LeadsModel.class);
        System.out.println(String.format("Subscriber 1:[Channel: Email] [LeadID: %d] [Message: Email Sent]" , leadsModel.getLeadId()));
    }

    @RabbitListener(queues = "${leads.mobile.queue}")
    public void consumePhoneMessage(String message) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final LeadsModel leadsModel = objectMapper.readValue(message, LeadsModel.class);
        final Notification notification = new MobileCommunicationFactory().createNotification(leadsModel);
        notification.sendToMobile(leadsModel);
    }
}
