package org.assessment.salesleads.exception;

public class SalesLeadsException extends RuntimeException {

    String code;
    Integer leadsId;
    int statusCode;

    public SalesLeadsException(Integer leadsId, ErrorCode errorCode) {
        super(errorCode.message);
        this.leadsId = leadsId;
        this.code = errorCode.code;
        this.statusCode = errorCode.getHttpStatusCode();
    }

    public String getCode() {
        return code;
    }

    public Integer getLeadsId() {
        return leadsId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "SalesLeadsException{" +
                "code='" + code + '\'' +
                ", leadsId=" + leadsId +
                ", statusCode=" + statusCode +
                '}';
    }
}
