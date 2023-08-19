package com.fa.couponsasart.repositories;

import com.fa.couponsasart.domain.entities.Coupon;
import com.fa.couponsasart.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CouponsRepository extends JpaRepository<Coupon, BigInteger> {

    Page<Coupon> findByCategoryIgnoreCaseIn(List<String> categories, Pageable pageable);

}
