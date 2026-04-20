package com.seckill.product.controller;

import com.seckill.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "商品服务")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @ApiOperation("服务健康检查")
    @GetMapping("/health")
    public Result<?> health() {
        return Result.success("product-service is running");
    }

    @ApiOperation("获取商品列表(演示数据)")
    @GetMapping("/list")
    public Result<?> listProducts() {
        List<Map<String, Object>> products = Arrays.asList(
                buildProduct(1L, "机械键盘", new BigDecimal("299.00"), false),
                buildProduct(2L, "秒杀鼠标", new BigDecimal("99.00"), true)
        );
        return Result.success(products);
    }

    private Map<String, Object> buildProduct(Long id, String name, BigDecimal price, boolean seckill) {
        Map<String, Object> item = new HashMap<>();
        item.put("id", id);
        item.put("name", name);
        item.put("price", price);
        item.put("isSeckill", seckill);
        return item;
    }
}
