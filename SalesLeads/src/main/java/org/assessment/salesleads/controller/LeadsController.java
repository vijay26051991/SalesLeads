package org.assessment.salesleads.controller;

import org.assessment.salesleads.model.LeadsResponse;
import org.assessment.salesleads.model.LeadsRequest;
import org.assessment.salesleads.service.LeadsService;
import org.assessment.salesleads.validators.LeadsRequestValidator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * API class for sales leads*
 */
@RestController
@RequestMapping("/leads")
public class LeadsController {

    private final LeadsService leadsService;

    private final LeadsRequestValidator leadsRequestValidator;

    public LeadsController(LeadsService leadsService, LeadsRequestValidator leadsRequestValidator) {
        this.leadsRequestValidator = leadsRequestValidator;
        this.leadsService = leadsService;
    }

    @PostMapping(value = "/publish",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeadsResponse> publishLeads(@Valid @RequestBody LeadsRequest leadsRequest) {

        //validate the request fields.
        leadsRequestValidator.validate(leadsRequest);

        //send json field
        leadsService.sendJsonMessage(leadsRequest);

        final LeadsResponse salesResponse = new LeadsResponse(leadsRequest.getLeadId(), "PUBLISHED", "Message has been published successfully.");

        return ResponseEntity.ok().body(salesResponse);
    }
}
