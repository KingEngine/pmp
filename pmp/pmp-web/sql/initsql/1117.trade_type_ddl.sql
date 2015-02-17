CREATE TABLE `trade_type` (
  `trade_code` varchar(3) NOT NULL,
  `trade_name` varchar(30) NOT NULL,
  `trade_type_category_id` varchar(4) NOT NULL,
  PRIMARY KEY (`trade_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;