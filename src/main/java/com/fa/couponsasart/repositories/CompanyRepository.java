package com.fa.couponsasart.repositories;

import com.fa.couponsasart.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CompanyRepository extends JpaRepository<Company, BigInteger> {
}
