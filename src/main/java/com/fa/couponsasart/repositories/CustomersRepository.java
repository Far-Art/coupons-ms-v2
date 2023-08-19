package com.fa.couponsasart.repositories;

import com.fa.couponsasart.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, BigInteger> {
}
