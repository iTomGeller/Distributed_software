package com.seckill.common.result;

public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器内部错误"),
    USER_EXIST(1001, "用户已存在"),
    USER_NOT_EXIST(1002, "用户不存在"),
    PASSWORD_ERROR(1003, "密码错误"),
    PRODUCT_NOT_EXIST(2001, "商品不存在"),
    PRODUCT_OFF_SHELF(2002, "商品已下架"),
    INVENTORY_NOT_ENOUGH(3001, "库存不足"),
    ORDER_NOT_EXIST(4001, "订单不存在"),
    ORDER_STATUS_ERROR(4002, "订单状态错误");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}