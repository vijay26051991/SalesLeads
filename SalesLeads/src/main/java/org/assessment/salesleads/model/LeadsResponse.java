package org.assessment.salesleads.model;

public class LeadsResponse {
    private Integer leadsId;
    private String code;
    private String message;

    public LeadsResponse(Integer leadsId, String code, String message) {
        this.leadsId = leadsId;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getLeadsId() {
        return leadsId;
    }

    @Override
    public String toString() {
        return "SalesResponse{" +
                "leadsId='" + leadsId + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
