-- 创建库存数据库
CREATE DATABASE IF NOT EXISTS seckill_inventory DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用库存数据库
USE seckill_inventory;

-- 创建库存表
CREATE TABLE `inventory` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '库存ID',
  `product_id` BIGINT NOT NULL UNIQUE COMMENT '商品ID',
  `total_stock` INT NOT NULL DEFAULT 0 COMMENT '总库存',
  `available_stock` INT NOT NULL DEFAULT 0 COMMENT '可用库存',
  `locked_stock` INT NOT NULL DEFAULT 0 COMMENT '锁定库存',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  INDEX idx_product_id (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存表';