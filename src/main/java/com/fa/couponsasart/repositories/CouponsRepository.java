package com.fa.couponsasart.repositories;

import com.fa.couponsasart.domain.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository<ID> extends JpaRepository<Coupon, ID> {
}
