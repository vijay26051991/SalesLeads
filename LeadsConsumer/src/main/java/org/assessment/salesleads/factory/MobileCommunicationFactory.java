package org.assessment.salesleads.factory;

import org.assessment.salesleads.model.LeadsModel;

public class MobileCommunicationFactory {

    public static final String SMS = "SMS";
    public static final String PUSH_NOTIFICATION = "PUSH_NOTIFICATION";
    public static final String WHATSAPP = "WHATSAPP";

    public Notification createNotification(LeadsModel leadsModel)
    {
        if (leadsModel.getMobileCommunicationMode() == null || leadsModel.getMobileCommunicationMode().isEmpty())
            return null;

        switch (leadsModel.getMobileCommunicationMode()) {
            case SMS:
                return new SMSNotification();
            case PUSH_NOTIFICATION:
                return new PushNotification();
            case WHATSAPP:
                return new WhatsappNotification();
            default:
                throw new IllegalArgumentException("Illegal communication mode : " + leadsModel.getMobileCommunicationMode());
        }
    }
}
