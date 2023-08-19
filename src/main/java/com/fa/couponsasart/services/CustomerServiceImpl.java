package com.fa.couponsasart.services;

import com.fa.couponsasart.domain.entities.Coupon;
import com.fa.couponsasart.domain.entities.Customer;
import com.fa.couponsasart.repositories.CouponsRepository;
import com.fa.couponsasart.repositories.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CouponsRepository couponsRepository;

    private final CustomersRepository customersRepository;

    @Override
    @Transactional
    public int buyCoupons(BigInteger customerId, BigInteger couponId, BigInteger... moreCouponIds) {
        AtomicInteger boughtNum = new AtomicInteger(0);
        customersRepository.findById(customerId).ifPresent(customer -> {
            List<BigInteger> ids = Stream.concat(Stream.of(couponId), Stream.of(moreCouponIds)).toList();
            List<Coupon> result = couponsRepository.findAllById(ids);
            result.forEach(c -> c.getCustomers().add(customer));
            customer.getCoupons().addAll(result);
            couponsRepository.saveAll(result);
            boughtNum.set(result.size());
        });

        return boughtNum.get();
    }

    @Override
    public List<Coupon> getMyCoupons(BigInteger customerId, Optional<Predicate<Coupon>> filter) {
        return null;
    }

    @Override
    public Customer getMyInfo(BigInteger customerId) {
        return null;
    }

}
