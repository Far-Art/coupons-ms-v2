package com.fa.couponsasart.services;

import com.fa.couponsasart.domain.entities.Coupon;
import com.fa.couponsasart.domain.entities.Customer;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface CustomerService {

    int buyCoupons(BigInteger customerId, BigInteger couponId, BigInteger... moreCouponIds);

    List<Coupon> getMyCoupons(BigInteger customerId, Optional<Predicate<Coupon>> filter);

    Customer getMyInfo(BigInteger customerId);

}
