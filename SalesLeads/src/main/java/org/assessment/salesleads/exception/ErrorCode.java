package org.assessment.salesleads.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    SERVICE_ERROR("00000", "There is an issue with service", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    MISSING_LEADS_ID("10000", "Leads ID is missing", HttpStatus.BAD_REQUEST.value()),
    MOBILE_OR_EMAIL_EXISTS("10001", "Email or Mobile must be present", HttpStatus.BAD_REQUEST.value()),
    INVALID_MOBILE_NUMBER_FORMAT("10002", "The mobile phone number must be in the international format", HttpStatus.BAD_REQUEST.value()),
    INVALID_EMAIL_FORMAT("10003", "The email ID must be in the proper format", HttpStatus.BAD_REQUEST.value()),
    INVALID_COMMUNICATION_MODE("10004", "Invalid mobile communication mode", HttpStatus.BAD_REQUEST.value()),
    MESSAGE_NOT_PRESENT("10005", "Message must be not null", HttpStatus.BAD_REQUEST.value()),
    INVALID_MESSAGE_LENGTH("10006", "Message must be 10 characters atleast", HttpStatus.BAD_REQUEST.value());

    String code;
    String message;
    int httpStatusCode;

    ErrorCode(String code, String message, int httpCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
