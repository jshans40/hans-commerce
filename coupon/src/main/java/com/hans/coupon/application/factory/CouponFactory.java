package com.hans.coupon.application.factory;

import com.hans.coupon.domain.Coupon;
import com.hans.coupon.ui.dto.CouponCreateRequestDto;
import com.hans.coupon.ui.dto.CouponResponseDto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CouponFactory {

    public static Coupon create(CouponCreateRequestDto couponCreateRequestDto) {
        LocalDateTime startLocalDateTime = Instant.ofEpochMilli(couponCreateRequestDto.getStartTimestamp())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        LocalDateTime endLocalDateTime = Instant.ofEpochMilli(couponCreateRequestDto.getEndTimestamp())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return new Coupon(
                couponCreateRequestDto.getName(),
                couponCreateRequestDto.getStatus(),
                couponCreateRequestDto.getDiscountAmount(),
                couponCreateRequestDto.getDiscountType(),
                couponCreateRequestDto.getInitialCount(),
                startLocalDateTime,
                endLocalDateTime
        );
    }

    public static CouponResponseDto createResponseDto(Coupon coupon) {
        return new CouponResponseDto(
                coupon.getId(),
                coupon.getName(),
                coupon.getStatus(),
                coupon.getDiscountAmount(),
                coupon.getDiscountType(),
                coupon.getInitialCount(),
                coupon.getRemainingCount(),
                coupon.getStartedAt(),
                coupon.getExpiredAt()
        );
    }
}
