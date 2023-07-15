package com.fa.couponsasart.controllers;

import com.fa.couponsasart.controllers.exceptions.NotFoundException;
import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.entities.Coupon;
import com.fa.couponsasart.domain.exceptions.ValidationException;
import com.fa.couponsasart.domain.mappers.CouponMapper;
import com.fa.couponsasart.repositories.CouponsRepository;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CouponsControllerIntegrationTest {

    @Autowired
    CouponsController controller;

    @Autowired
    CouponsRepository repository;

    @Autowired
    CouponMapper mapper;

    List<Coupon> createdForTest = new ArrayList<>();


    @BeforeAll
    void setup() {
        Coupon coupon1 = Coupon.builder()
                .title("TestCoupon1")
                .created(LocalDateTime.now())
                .price(new BigDecimal("5.99"))
                .amount(100)
                .category("TestSave")
                .startDate(LocalDateTime.now().plusSeconds(1))
                .endDate(LocalDateTime.now().plusSeconds(2))
                .build();

        Coupon coupon2 = Coupon.builder()
                .title("TestCoupon2")
                .created(LocalDateTime.now())
                .price(new BigDecimal("25.00"))
                .amount(50)
                .category("TestSave2")
                .startDate(LocalDateTime.now().plusSeconds(1))
                .endDate(LocalDateTime.now().plusSeconds(2))
                .build();

        createdForTest = repository.saveAll(List.of(coupon1, coupon2));
    }

    @AfterAll
    void cleanup() {
        repository.deleteAll(createdForTest);
    }

    @Test
    @Transactional
    @Rollback
    void testSave() throws ValidationException {
        CouponDTO coupon = CouponDTO.builder()
                .title("TestSaveCoupon")
                .created(LocalDateTime.now())
                .price(new BigDecimal("999.99"))
                .amount(20)
                .category("TestSave")
                .startDate(LocalDateTime.now().plusSeconds(1))
                .endDate(LocalDateTime.now().plusSeconds(2))
                .build();

        ResponseEntity<HttpHeaders> result = controller.addNew(coupon);
        List<String> identity = result.getHeaders().get("Identity");

        assertThat(identity).isNotNull();
        assertThat(identity).isNotEmpty();
    }

    @Test
    @Transactional
    @Rollback
    void testSaveNotValid() {
        CouponDTO coupon = CouponDTO.builder()
                .title("")
                .created(LocalDateTime.now())
                .price(new BigDecimal("999.99"))
                .amount(20)
                .category("TestSave")
                .build();

        assertThrows(ConstraintViolationException.class, () -> {
            controller.addNew(coupon);
        });

        coupon.setTitle("TestSaveCoupon");

        assertThrows(ConstraintViolationException.class, () -> {
            controller.addNew(coupon);
        });


    }

    @Test
    @Transactional
    @Rollback
    void updateExisting() {
        CouponDTO coupon = mapper.toDto(repository.findAll().get(0));
        String updated = "UPDATED";
        coupon.setTitle(updated);
        controller.updateById(coupon.getId(), coupon);

        CouponDTO couponDto = controller.getById(coupon.getId()).getBody();

        assertThat(couponDto).isNotNull();
        assertThat(couponDto.getTitle()).isEqualTo(updated);
    }

    @Test
    void testNotFound() {
        assertThrows(NotFoundException.class, () -> {
            controller.getById(new BigInteger("-999"));
        });
    }

    @Test
    void testUpdateByIdNotFound(){
        assertThrows(NotFoundException.class, () -> {
            controller.updateById(new BigInteger("-999"), null);
        });
    }

    @Test
    void testPatchByIdNotFound(){
        assertThrows(NotFoundException.class, () -> {
            controller.patchById(new BigInteger("-999"), null);
        });
    }

}