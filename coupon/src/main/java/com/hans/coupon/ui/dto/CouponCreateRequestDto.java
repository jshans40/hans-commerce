package com.hans.coupon.ui.dto;

import com.hans.coupon.domain.CouponDiscountType;
import com.hans.coupon.domain.CouponStatus;
import lombok.Getter;

@Getter
public class CouponCreateRequestDto {
    private long productId;
    private float discountAmount;
    private CouponDiscountType discountType;
    private String name;
    private long startTimestamp;
    private long endTimestamp;
    private CouponStatus status;
    private int initialCount;
}
