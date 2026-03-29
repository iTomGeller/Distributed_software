-- 创建商品数据库
CREATE DATABASE IF NOT EXISTS seckill_product DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用商品数据库
USE seckill_product;

-- 创建商品表
CREATE TABLE `product` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
  `name` VARCHAR(200) NOT NULL COMMENT '商品名称',
  `description` TEXT COMMENT '商品描述',
  `price` DECIMAL(10,2) NOT NULL COMMENT '商品价格',
  `category_id` BIGINT COMMENT '分类ID',
  `image_url` VARCHAR(500) COMMENT '商品图片',
  `status` TINYINT DEFAULT 1 COMMENT '状态:0-下架,1-上架',
  `is_seckill` TINYINT DEFAULT 0 COMMENT '是否秒杀商品:0-否,1-是',
  `seckill_price` DECIMAL(10,2) COMMENT '秒杀价格',
  `seckill_start_time` DATETIME COMMENT '秒杀开始时间',
  `seckill_end_time` DATETIME COMMENT '秒杀结束时间',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  INDEX idx_category (`category_id`),
  INDEX idx_seckill (`is_seckill`, `seckill_start_time`, `seckill_end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';