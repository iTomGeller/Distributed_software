package com.seckill.gateway.controller;

import com.seckill.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayHealthController {

    @GetMapping("/health")
    public Result<?> health() {
        return Result.success("gateway is running");
    }
}
