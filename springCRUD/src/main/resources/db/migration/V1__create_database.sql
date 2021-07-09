CREATE TABLE `employees`
(
    `uuid` char(36) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`uuid`)
);

CREATE TABLE `items`
(
    `uuid` char(36) NOT NULL,
    `description` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`uuid`)
);
CREATE TABLE `balances`
(
    `uuid` char(36) NOT NULL,
    `amount` int NOT NULL,
    `spent_amount` int DEFAULT NULL,
    `employee_id` char(36) NOT NULL,
    `item_id` char(36) NOT NULL,
    PRIMARY KEY (`uuid`),
    UNIQUE KEY `unique_item_employee` (`item_id`,`employee_id`),
    CONSTRAINT `foreign_key_items` FOREIGN KEY (`item_id`) REFERENCES `items` (`uuid`),
    CONSTRAINT `foreign_key_employees` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`uuid`)
);