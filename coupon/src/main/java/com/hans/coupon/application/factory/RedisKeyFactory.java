package com.hans.coupon.application.factory;

public class RedisKeyFactory {

    public static String makeCouponRemainingKey(long couponId) {
        return "coupon:remaining:" + couponId;
    }
}
