package com.fa.couponsasart.repositories;

import com.fa.couponsasart.domain.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository extends JpaRepository<Coupon, String> {
}
