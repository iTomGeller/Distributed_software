-- 创建订单数据库
CREATE DATABASE IF NOT EXISTS seckill_order DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用订单数据库
USE seckill_order;

-- 创建订单表
CREATE TABLE `order` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
  `order_no` VARCHAR(50) NOT NULL UNIQUE COMMENT '订单号',
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `product_id` BIGINT NOT NULL COMMENT '商品ID',
  `quantity` INT NOT NULL DEFAULT 1 COMMENT '购买数量',
  `total_price` DECIMAL(10,2) NOT NULL COMMENT '总价格',
  `status` TINYINT DEFAULT 0 COMMENT '订单状态:0-待支付,1-已支付,2-已取消,3-已完成',
  `payment_method` TINYINT COMMENT '支付方式:1-支付宝,2-微信,3-银行卡',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  INDEX idx_user_id (`user_id`),
  INDEX idx_product_id (`product_id`),
  INDEX idx_order_no (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';