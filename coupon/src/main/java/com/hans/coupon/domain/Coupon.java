package com.hans.coupon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CouponStatus status;

    @Column(name = "discount_amout")
    private float discountAmount;

    @Column(name = "discount_type")
    @Enumerated(EnumType.STRING)
    private CouponDiscountType discountType;

    @Column(name = "initial_count")
    private int initialCount;

    @Column(name = "remaining_count")
    private int remainingCount;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    public Coupon(String name, CouponStatus status, float discountAmount, CouponDiscountType discountType, int initialCount, LocalDateTime startedAt, LocalDateTime expiredAt) {
        this.name = name;
        this.status = status;
        this.discountAmount = discountAmount;
        this.discountType = discountType;
        this.initialCount = initialCount;
        this.startedAt = startedAt;
        this.expiredAt = expiredAt;
        this.createdAt = LocalDateTime.now();
    }
}
