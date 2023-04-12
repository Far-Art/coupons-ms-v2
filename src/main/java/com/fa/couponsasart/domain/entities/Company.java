package com.fa.couponsasart.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "companies")
@Getter
@Setter
//@ToString(callSuper = true, exclude = "coupons")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Company extends Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, unique = true, updatable = false, nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private String id;

    private String name;

//    @OneToMany
//    private List<Coupon> coupons;

}
