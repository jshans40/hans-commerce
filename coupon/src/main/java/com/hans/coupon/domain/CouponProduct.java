package com.hans.coupon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupon_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponProduct {

    @EmbeddedId
    private CouponProductId id;


}
