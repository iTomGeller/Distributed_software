# Distributed_software - 秒杀系统(中期检查版)

这是一个基于 Spring Boot + Spring Cloud 的分布式秒杀系统课程项目。  
当前版本完成了多模块工程搭建、用户服务核心接口、其余业务服务骨架以及网关路由，适合作为中期检查演示基础。

## 1. 项目结构

```text
Distributed_software
├── seckill-common               # 公共模块：统一返回体、异常、JWT工具
├── seckill-user-service         # 用户服务（注册/登录/用户信息）
├── seckill-product-service      # 商品服务（演示接口）
├── seckill-inventory-service    # 库存服务（演示接口）
├── seckill-order-service        # 订单服务（演示接口）
├── seckill-gateway              # 网关服务（统一入口与路由）
├── scripts/sql                  # 初始化数据库脚本
└── pom.xml                      # Maven父工程
```

## 2. 已完成功能

### 2.1 用户服务
- 用户注册：`POST /api/user/register`
- 用户登录：`POST /api/user/login`
- 获取用户信息：`GET /api/user/info`（Bearer Token）
- 用户登出：`POST /api/user/logout`

### 2.2 其他服务骨架
- 商品服务：`/api/product/health`、`/api/product/list`
- 库存服务：`/api/inventory/health`、`/api/inventory/{productId}`
- 订单服务：`/api/order/health`、`/api/order/create`、`/api/order/{orderNo}`
- 网关路由已配置：`/api/user/**`、`/api/product/**`、`/api/inventory/**`、`/api/order/**`

## 3. 技术栈
- Java 11
- Spring Boot 2.7.14
- Spring Cloud 2021.0.5
- Spring Cloud Alibaba 2021.0.5.0
- MyBatis-Plus 3.5.3
- MySQL 8.x
- Redis
- JWT
- Maven 多模块

## 4. 数据库初始化

按顺序执行 `scripts/sql` 下脚本：

1. `01_init_user_db.sql`
2. `02_init_product_db.sql`
3. `03_init_inventory_db.sql`
4. `04_init_order_db.sql`

## 5. 本地启动说明

### 5.1 环境准备
- JDK 11+
- Maven 3.8+
- MySQL 8.x
- Redis

### 5.2 编译项目

```bash
mvn clean compile
```

### 5.3 启动顺序（建议）

1. `seckill-user-service`（8081）
2. `seckill-product-service`（8082）
3. `seckill-inventory-service`（8083）
4. `seckill-order-service`（8084）
5. `seckill-gateway`（8080）

## 6. 接口演示示例

### 6.1 用户注册

`POST http://localhost:8081/api/user/register`

```json
{
  "username": "test01",
  "password": "123456",
  "email": "test01@example.com",
  "phone": "13800000000"
}
```

### 6.2 用户登录

`POST http://localhost:8081/api/user/login`

```json
{
  "username": "test01",
  "password": "123456"
}
```

登录成功后会返回 token，用于访问 `/api/user/info`。

## 7. 中期检查可展示点

- 多模块微服务工程结构清晰，职责拆分明确
- 用户模块已实现完整登录认证链路（注册、登录、JWT鉴权）
- 商品/库存/订单模块完成独立可启动服务骨架
- 网关完成统一入口与路由转发配置
- SQL 脚本和 README 已完善，便于快速复现实验环境

## 8. 后续计划

- 完成商品、库存、订单真实业务逻辑与数据库读写
- 接入服务注册与配置中心（Nacos）
- 增加消息队列异步削峰（RabbitMQ）
- 补充单元测试与接口测试，完善异常处理与日志体系
