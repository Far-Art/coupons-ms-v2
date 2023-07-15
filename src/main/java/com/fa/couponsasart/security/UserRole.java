package com.fa.couponsasart.security;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UserRole {
    ADMIN, CUSTOMER, COMPANY
}
