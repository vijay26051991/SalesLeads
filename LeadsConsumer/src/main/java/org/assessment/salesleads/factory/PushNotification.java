package org.assessment.salesleads.factory;

import org.assessment.salesleads.model.LeadsModel;

public class PushNotification implements Notification {
    @Override
    public void sendToMobile(LeadsModel leadsModel) {
        System.out.println(String.format("Subscriber 2: [Channel: Mobile] [LeadID: %d] [Message: Push Notification Sent]", leadsModel.getLeadId()));
    }
}
