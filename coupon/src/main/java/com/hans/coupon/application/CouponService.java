package com.hans.coupon.application;

import com.hans.common.infrastructure.redis.RedisDataService;
import com.hans.coupon.application.factory.CouponFactory;
import com.hans.coupon.application.factory.RedisKeyFactory;
import com.hans.coupon.domain.Coupon;
import com.hans.coupon.domain.CouponRepository;
import com.hans.coupon.ui.dto.CouponCreateRequestDto;
import com.hans.coupon.ui.dto.CouponResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final RedisDataService redisDataService;

    @Transactional
    public CouponResponseDto save(CouponCreateRequestDto couponCreateRequestDto) {
        Coupon savedCoupon = couponRepository.save(CouponFactory.create(couponCreateRequestDto));

        String couponRemainingRedisKey = RedisKeyFactory.makeCouponRemainingKey(savedCoupon.getId());
        boolean isSuccess = redisDataService.setAndVerify(couponRemainingRedisKey, couponCreateRequestDto.getInitialCount());
        if (!isSuccess) {
            throw new RuntimeException("Redis 저장 실패");
        }
        return CouponFactory.createResponseDto(savedCoupon);
    }

}
