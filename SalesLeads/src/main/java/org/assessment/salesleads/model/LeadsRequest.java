package org.assessment.salesleads.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeadsRequest implements Serializable {

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

    @JsonCreator
    public LeadsRequest(
            @JsonProperty("lead_id") Integer leadId,
            @JsonProperty("source") String source,
            @JsonProperty("lead_name") String leadName,
            @JsonProperty("lead_mobile_number") String mobileNumber,
            @JsonProperty("lead_email_id") String emailId,
            @JsonProperty("preferred_mobile_communication_mode") String mobileCommunicationMode,
            @JsonProperty("lead_message") String leadMessage) {
        this.leadId = leadId;
        this.source = source;
        this.leadName = leadName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.mobileCommunicationMode = mobileCommunicationMode;
        this.leadMessage = leadMessage;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public String getSource() {
        return source;
    }

    public String getLeadName() {
        return leadName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getMobileCommunicationMode() {
        return mobileCommunicationMode;
    }

    public String getLeadMessage() {
        return leadMessage;
    }

    @Override
    public String toString() {
        return "LeadsRequest{" +
                "leadId=" + leadId +
                ", source='" + source + '\'' +
                ", leadName='" + leadName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileCommunicationMode='" + mobileCommunicationMode + '\'' +
                ", leadMessage='" + leadMessage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeadsRequest that = (LeadsRequest) o;
        return Objects.equals(leadId, that.leadId) && Objects.equals(source, that.source) && Objects.equals(leadName, that.leadName) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(emailId, that.emailId) && Objects.equals(mobileCommunicationMode, that.mobileCommunicationMode) && Objects.equals(leadMessage, that.leadMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leadId, source, leadName, mobileNumber, emailId, mobileCommunicationMode, leadMessage);
    }
}
