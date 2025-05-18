package com.hans.coupon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponProductId implements Serializable {

    @Column(name = "coupon_id")
    private long couponId;

    @Column(name = "product_id")
    private long productId;

    public CouponProductId(long couponId, long productId) {
        this.couponId = couponId;
        this.productId = productId;
    }

}
