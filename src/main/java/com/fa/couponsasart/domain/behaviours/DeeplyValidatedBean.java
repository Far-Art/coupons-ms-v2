package com.fa.couponsasart.domain.behaviours;

import com.fa.couponsasart.domain.exceptions.ValidationException;

public interface DeeplyValidatedBean {

    void validate() throws ValidationException;
}
