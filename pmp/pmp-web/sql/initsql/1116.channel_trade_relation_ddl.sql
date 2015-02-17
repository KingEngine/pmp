DROP TABLE IF EXISTS `channel_trade_relation`;
CREATE TABLE `channel_trade_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `trade_code` char(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;