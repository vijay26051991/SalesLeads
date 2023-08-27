package org.assessment.salesleads.exception;

import org.assessment.salesleads.model.LeadsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SalesLeadsControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SalesLeadsException.class)
    public ResponseEntity<LeadsResponse> handleCityNotFoundException(
            SalesLeadsException salesLeadsException) {
        LeadsResponse salesResponse
                = new LeadsResponse(salesLeadsException.getLeadsId(), salesLeadsException.getCode(), salesLeadsException.getMessage());

        return ResponseEntity.status(salesLeadsException.getStatusCode())
                .body(salesResponse);
    }
}
