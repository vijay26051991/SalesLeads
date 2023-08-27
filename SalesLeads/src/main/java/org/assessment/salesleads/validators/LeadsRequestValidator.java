package org.assessment.salesleads.validators;

import org.apache.commons.lang3.StringUtils;
import org.assessment.salesleads.exception.ErrorCode;
import org.assessment.salesleads.exception.SalesLeadsException;
import org.assessment.salesleads.model.LeadsRequest;
import org.assessment.salesleads.utils.CommunicationMode;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assessment.salesleads.exception.ErrorCode.MISSING_LEADS_ID;

/**
 * Validator class for validating leads request fields
 */
@Component
public class LeadsRequestValidator implements BaseValidator<LeadsRequest> {

    private static final Pattern INT_PHONE_REGEX = Pattern.compile("^\\+(?:[0-9]?){6,14}[0-9]$");

    private static final Pattern EMAIL_REGEX = Pattern.compile("^(.+)@(\\S+)$");

    private static final List<String> COMMUNICATION_MODES
            = Stream.of(CommunicationMode.values()).map(CommunicationMode::name).collect(Collectors.toList());

    @Override
    public void validate(final LeadsRequest leadsRequest) {

        if (leadsRequest.getLeadId() == null) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), MISSING_LEADS_ID);
        }

        if (leadsRequest.getLeadId() < 0) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), ErrorCode.MOBILE_OR_EMAIL_EXISTS);
        }

        if (StringUtils.isEmpty(leadsRequest.getEmailId()) && StringUtils.isEmpty(leadsRequest.getMobileNumber())) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), ErrorCode.MOBILE_OR_EMAIL_EXISTS);
        }

        /*if (leadsRequest.getMobileNumber() != null && INT_PHONE_REGEX.matcher(leadsRequest.getMobileNumber()).find()) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), ErrorCode.INVALID_MOBILE_NUMBER_FORMAT);
        }*/

        if (leadsRequest.getEmailId() != null && !EMAIL_REGEX.matcher(leadsRequest.getEmailId()).find()) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), ErrorCode.INVALID_EMAIL_FORMAT);
        }

        if (!(COMMUNICATION_MODES.contains(leadsRequest.getMobileCommunicationMode()))) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), ErrorCode.INVALID_COMMUNICATION_MODE);
        }

        if (StringUtils.isEmpty(leadsRequest.getLeadMessage())) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), ErrorCode.MESSAGE_NOT_PRESENT);
        }

        if (leadsRequest.getLeadMessage().length() < 10) {
            throw new SalesLeadsException(leadsRequest.getLeadId(), ErrorCode.INVALID_MESSAGE_LENGTH);
        }
    }
}
