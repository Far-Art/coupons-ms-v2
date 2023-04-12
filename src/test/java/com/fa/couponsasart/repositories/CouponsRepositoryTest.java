package com.fa.couponsasart.repositories;

import com.fa.couponsasart.domain.entities.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CouponsRepositoryTest {

    // TODO make more validations
    @Autowired
    CouponsRepository repo;

    @Test
    void testSaveValid() {
        Coupon coupon = Coupon.builder()
                .title("SaveTestCoupon")
                .price(BigDecimal.ONE)
                .created(LocalDateTime.now())
                .build();

        Coupon saved = repo.save(coupon);
        repo.flush(); // flush is needed for validations to perform

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
    }
}
