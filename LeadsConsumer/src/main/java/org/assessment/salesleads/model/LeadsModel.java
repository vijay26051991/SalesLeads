package org.assessment.salesleads.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeadsModel {

    @JsonProperty("lead_id")
    private Integer leadId;

    @JsonProperty("source")
    private String source;

    @JsonProperty("lead_name")
    private String leadName;

    @JsonProperty("lead_mobile_number")
    private String mobileNumber;

    @JsonProperty("lead_email_id")
    private String emailId;

    @JsonProperty("preferred_mobile_communication_mode")
    private String mobileCommunicationMode;

    @JsonProperty("lead_message")
    private String leadMessage;

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileCommunicationMode() {
        return mobileCommunicationMode;
    }

    public void setMobileCommunicationMode(String mobileCommunicationMode) {
        this.mobileCommunicationMode = mobileCommunicationMode;
    }

    public String getLeadMessage() {
        return leadMessage;
    }

    public void setLeadMessage(String leadMessage) {
        this.leadMessage = leadMessage;
    }

    @Override
    public String toString() {
        return "LeadsModel{" +
                "leadId=" + leadId +
                ", source='" + source + '\'' +
                ", leadName='" + leadName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileCommunicationMode='" + mobileCommunicationMode + '\'' +
                ", leadMessage='" + leadMessage + '\'' +
                '}';
    }
}
