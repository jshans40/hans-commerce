package com.hans.coupon.ui;

import com.hans.coupon.application.CouponService;
import com.hans.coupon.domain.Coupon;
import com.hans.coupon.ui.dto.CouponCreateRequestDto;
import com.hans.coupon.ui.dto.CouponResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<CouponResponseDto> create(@RequestBody CouponCreateRequestDto couponCreateRequestDto) {
        CouponResponseDto couponResponseDto = couponService.save(couponCreateRequestDto);
        return new ResponseEntity<>(couponResponseDto, HttpStatus.CREATED);
    }

}
