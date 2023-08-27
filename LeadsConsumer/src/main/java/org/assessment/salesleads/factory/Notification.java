package org.assessment.salesleads.factory;

import org.assessment.salesleads.model.LeadsModel;

public interface Notification {
    void sendToMobile(LeadsModel leadsModel);
}
