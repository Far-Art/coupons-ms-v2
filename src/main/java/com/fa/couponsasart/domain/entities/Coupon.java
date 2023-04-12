package com.fa.couponsasart.domain.entities;

import com.fa.couponsasart.configurations.ValidationConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
//@ToString(callSuper = true, exclude = "owningCompany") // TODO fix the owning company lazy exception
public class Coupon extends BasicEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, unique = true, updatable = false, nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private String id;

//    @ManyToOne
//    private Company owningCompany;

    @NotNull
    @NotBlank
    private String category;

    @NotNull
    @NotBlank
    @Size(min = ValidationConstants.Coupon.TITLE_MIN_LEN, max = ValidationConstants.Coupon.TITLE_MAX_LEN)
    @Column(length = ValidationConstants.Coupon.TITLE_MAX_LEN)
    private String title;

    @Size(max = ValidationConstants.Coupon.DESCRIPTION_MAX_LEN)
    @Column(length = ValidationConstants.Coupon.DESCRIPTION_MAX_LEN)
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startDate;

    @NotNull
    @Future
    private LocalDateTime endDate;

    @PositiveOrZero
    private long amount;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;

    @Column(length = 500)
    private String imageUrl;

//    @ManyToMany
//    @JoinTable(name = "customers_coupons", joinColumns = @JoinColumn(name = "coupon_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
//    @ToString.Exclude
//    @JsonIgnoreProperties({"coupons"})
//    private final Set<Customer> customers = new HashSet<>();
}
