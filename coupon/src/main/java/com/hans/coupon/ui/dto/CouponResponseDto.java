package com.hans.coupon.ui.dto;

import com.hans.coupon.domain.CouponDiscountType;
import com.hans.coupon.domain.CouponStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CouponResponseDto {
    private final long id;
    private final String name;
    private final CouponStatus status;
    private final float discountAmount;
    private final CouponDiscountType discountType;
    private final int initialCount;
    private final int remainingCount;
    private final LocalDateTime startedAt;
    private final LocalDateTime expiredAt;

    public CouponResponseDto(long id, String name, CouponStatus status, float discountAmount, CouponDiscountType discountType, int initialCount, int remainingCount, LocalDateTime startedAt, LocalDateTime expiredAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.discountAmount = discountAmount;
        this.discountType = discountType;
        this.initialCount = initialCount;
        this.remainingCount = remainingCount;
        this.startedAt = startedAt;
        this.expiredAt = expiredAt;
    }
}
