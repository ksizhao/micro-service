package com.example.microserviceprovider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "CART")
public interface CartFeignClient {
    @PostMapping("/cart/{productId}")
    Long addCart(@PathVariable("productId")Long productId);

}
