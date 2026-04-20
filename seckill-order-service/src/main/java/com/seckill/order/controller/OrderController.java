package com.seckill.order.controller;

import com.seckill.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "订单服务")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @ApiOperation("服务健康检查")
    @GetMapping("/health")
    public Result<?> health() {
        return Result.success("order-service is running");
    }

    @ApiOperation("创建订单(演示接口)")
    @PostMapping("/create")
    public Result<?> createOrder(@RequestBody Map<String, Object> request) {
        String orderNo = "ORD" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Map<String, Object> data = new HashMap<>();
        data.put("orderNo", orderNo);
        data.put("status", "CREATED");
        data.put("request", request);
        return Result.success(data);
    }

    @ApiOperation("查询订单状态(演示数据)")
    @GetMapping("/{orderNo}")
    public Result<?> getOrder(@PathVariable String orderNo) {
        Map<String, Object> data = new HashMap<>();
        data.put("orderNo", orderNo);
        data.put("status", "PENDING_PAYMENT");
        return Result.success(data);
    }
}
