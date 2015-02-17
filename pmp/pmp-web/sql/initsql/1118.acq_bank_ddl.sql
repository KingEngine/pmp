DROP TABLE IF EXISTS `acq_bank`;
CREATE TABLE `acq_bank` (
  `acq_bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `acp_bank_name` varchar(30) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `xpe_system_num` int(11) DEFAULT NULL COMMENT '核心系统代码',
  `institution_code` varchar(20) DEFAULT NULL COMMENT '机构代码',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0:启用 1:停用',
  PRIMARY KEY (`acq_bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;