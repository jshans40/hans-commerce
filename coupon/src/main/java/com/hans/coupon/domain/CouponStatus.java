package com.hans.coupon.domain;

public enum CouponStatus {
    /**
     * N : None (대기)
     * A : Available (사용 가능)
     * S : Stop (사용 중지)
     * E : Expired 기간 만료
     * C : Completed (사용 완료)
     */
    N, A, S, E, C;
}
