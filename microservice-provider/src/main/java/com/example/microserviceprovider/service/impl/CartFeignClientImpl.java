package com.example.microserviceprovider.service.impl;

import com.example.microserviceprovider.service.CartFeignClient;

public class CartFeignClientImpl implements CartFeignClient {

    @Override
    public Long addCart(Long productId) {
        return 1L;
    }
}
