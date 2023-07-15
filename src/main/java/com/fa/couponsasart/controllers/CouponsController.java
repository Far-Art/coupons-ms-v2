package com.fa.couponsasart.controllers;

import com.fa.couponsasart.controllers.exceptions.NotFoundException;
import com.fa.couponsasart.domain.dto.CouponDTO;
import com.fa.couponsasart.domain.exceptions.ValidationException;
import com.fa.couponsasart.services.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static com.fa.couponsasart.configurations.ControllersConstants.COUPONS;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping(COUPONS)
@RequiredArgsConstructor
@Validated
public class CouponsController {

    private final CouponService couponService;

    @GetMapping
    public ResponseEntity<Page<CouponDTO>> getAll(@RequestParam Optional<List<String>> category,
                                                  @RequestParam Optional<BigDecimal> minPrice,
                                                  @RequestParam Optional<BigDecimal> maxPrice,
                                                  @RequestParam Optional<Integer> pageNumber,
                                                  @RequestParam Optional<Integer> pageSize) {
        return new ResponseEntity<>(couponService.getAll(category, minPrice, maxPrice, pageNumber, pageSize), OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CouponDTO> getById(@PathVariable(name = "id") BigInteger id) {
        Optional<CouponDTO> coupon = couponService.getById(id);
        return new ResponseEntity<>(coupon.orElseThrow(NotFoundException::new), OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders>
    addNew(@Valid
           @RequestBody
           CouponDTO dto
    ) throws ValidationException {
        dto.validate();
        CouponDTO saved = couponService.addNew(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Identity", String.valueOf(saved.getId()));
        headers.add("Location", COUPONS + "/" + saved.getId());

        return new ResponseEntity<>(headers, CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpStatus> updateById(@PathVariable(name = "id") BigInteger id, @RequestBody CouponDTO dto) {
        couponService.updateById(id, dto);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PatchMapping("{id}")
    public ResponseEntity<HttpStatus> patchById(@PathVariable(name = "id") BigInteger id, @RequestBody CouponDTO dto) {
        couponService.patchById(id, dto);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable(name = "id") BigInteger id) {
        couponService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

}
