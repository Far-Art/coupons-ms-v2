package com.fa.couponsasart.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum CouponFilter {

    PRICE, START_DATE, END_DATE, AMOUNT, CATEGORY
}
