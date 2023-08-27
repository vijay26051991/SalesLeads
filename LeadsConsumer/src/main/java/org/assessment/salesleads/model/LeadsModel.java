package org.assessment.salesleads.model;

public class LeadsModel {

    private Integer leadId;

    private String source;

    private String leadName;

    private String mobileNumber;

    private String emailId;

    private String mobileCommunicationMode;

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
