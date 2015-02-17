DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '渠道id',
  `chan_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '渠道全称',
  `chan_abbrev` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '渠道简称',
  `industry` int(11) DEFAULT NULL COMMENT '渠道行业',
  `chan_status` tinyint(4) DEFAULT '1' COMMENT '渠道状态',
  `chan_sign` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `key_index` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `chan_name` (`chan_name`),
  UNIQUE KEY `chan_abbrev` (`chan_abbrev`),
  UNIQUE KEY `chan_sign` (`chan_sign`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;