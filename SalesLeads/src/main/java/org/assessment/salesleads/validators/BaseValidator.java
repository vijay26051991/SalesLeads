package org.assessment.salesleads.validators;

import java.io.Serializable;

public interface BaseValidator<T extends Serializable> {
    public void validate(T t);
}
