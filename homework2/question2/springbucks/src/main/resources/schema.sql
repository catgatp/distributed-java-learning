-- 删除旧表（如果存在）
DROP TABLE IF EXISTS `t_order_item`;
DROP TABLE IF EXISTS `t_order`;
DROP TABLE IF EXISTS `t_coffee`;

-- Coffee 商品表
CREATE TABLE `t_coffee` (
                            `id` BIGINT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(32) NOT NULL,
                            `price` DECIMAL(10,2) NOT NULL,
                            `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
                            `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_name` (`name`)
);







订单明细表
CREATE TABLE `t_order_item` (
                                `id` BIGINT NOT NULL AUTO_INCREMENT,
                                `order_id` BIGINT NOT NULL,
                                `coffee_id` BIGINT NOT NULL,
                                PRIMARY KEY (`id`),
                                CONSTRAINT `fk_order` FOREIGN KEY (`order_id`) REFERENCES `t_order`(`id`),
                                CONSTRAINT `fk_coffee` FOREIGN KEY (`coffee_id`) REFERENCES `t_coffee`(`id`)
);

CREATE TABLE t_order (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         customer VARCHAR(255) NOT NULL,
                         state INT NOT NULL,
                         create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                         update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

insert into t_coffee (name, price, create_time, update_time) values ('espresso', 2000, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('latte', 2500, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('capuccino', 2500, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('mocha', 3000, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('macchiato', 3000, now(), now());






