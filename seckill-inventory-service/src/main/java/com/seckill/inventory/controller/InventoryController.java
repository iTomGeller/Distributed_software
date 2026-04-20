package com.seckill.inventory.controller;

import com.seckill.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "库存服务")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @ApiOperation("服务健康检查")
    @GetMapping("/health")
    public Result<?> health() {
        return Result.success("inventory-service is running");
    }

    @ApiOperation("查询库存(演示数据)")
    @GetMapping("/{productId}")
    public Result<?> getInventory(@PathVariable Long productId) {
        Map<String, Object> data = new HashMap<>();
        data.put("productId", productId);
        data.put("totalStock", 100);
        data.put("availableStock", 86);
        data.put("lockedStock", 14);
        return Result.success(data);
    }
}
