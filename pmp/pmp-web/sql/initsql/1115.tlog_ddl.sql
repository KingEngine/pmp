DROP TABLE IF EXISTS `tlog`;
CREATE TABLE `tlog` (
  `id` bigint(20) NOT NULL,
  `tseq` varchar(55) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `ip` int(10) unsigned DEFAULT NULL,
  `mdate` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `bid` varchar(9) DEFAULT NULL,
  `oid` varchar(40) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `type` tinyint(4) DEFAULT '0',
  `gate` int(11) DEFAULT NULL,
  `sys_date` int(11) DEFAULT NULL,
  `init_sys_date` int(11) DEFAULT NULL,
  `sys_time` int(11) DEFAULT NULL,
  `batch` bigint(20) DEFAULT '0',
  `fee_amt` int(11) DEFAULT '0',
  `bank_fee` int(11) DEFAULT '0',
  `tstat` tinyint(4) DEFAULT '0',
  `bk_flag` int(11) DEFAULT '0',
  `org_seq` bigint(20) DEFAULT '0',
  `ref_seq` bigint(20) DEFAULT '0',
  `refund_amt` int(11) DEFAULT '0',
  `mer_priv` varchar(120) DEFAULT NULL,
  `bk_send` int(11) DEFAULT '0',
  `bk_recv` int(11) DEFAULT '0',
  `bk_url` varchar(120) DEFAULT NULL,
  `fg_url` varchar(120) DEFAULT NULL,
  `bk_chk` tinyint(4) DEFAULT '0',
  `bk_date` int(11) DEFAULT '0',
  `bk_seq1` varchar(24) DEFAULT NULL,
  `bk_seq2` varchar(24) DEFAULT NULL,
  `bk_resp` varchar(6) DEFAULT NULL,
  `mobile_no` varchar(12) DEFAULT NULL,
  `trans_period` int(11) DEFAULT '0',
  `card_no` varchar(25) DEFAULT NULL,
  `error_code` varchar(10) DEFAULT '000000',
  `author_type` int(4) DEFAULT NULL,
  `phone_no` varchar(12) DEFAULT '',
  `oper_id` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT '0',
  `pre_amt` int(11) DEFAULT '0',
  `pre_amt1` int(11) DEFAULT '0',
  `bk_fee_model` varchar(120) DEFAULT '',
  `terminal_number` varchar(30) DEFAULT NULL,
  `xpep_mercode` varchar(15) DEFAULT NULL,
  `xpep_termid` varchar(8) DEFAULT NULL,
  `xpep_trancode` varchar(3) DEFAULT NULL,
  `xpep_trace` varchar(6) DEFAULT NULL,
  `xpep_trade_datetime` bigint(20) DEFAULT NULL,
  `xpep_outcard` varchar(19) DEFAULT NULL,
  `xpep_trade_resp` varchar(2) DEFAULT NULL,
  `xpe_tradetype` int(11) DEFAULT NULL,
  `xpe_deduct_mercode` varchar(15) DEFAULT NULL,
  `xpe_deduct_termid` varchar(8) DEFAULT NULL,
  `xpe_deduct_trace` varchar(6) DEFAULT NULL,
  `xpe_deduct_insid` int(11) DEFAULT NULL,
  `xpe_deduct_resp` varchar(2) DEFAULT NULL,
  `xpe_deduct_refer` varchar(12) DEFAULT NULL,
  `xpe_deduct_authcode` varchar(6) DEFAULT NULL,
  `xpe_deduct_rollbk_flag` tinyint(1) DEFAULT NULL,
  `xpe_deduct_rollbk_reason` varchar(2) DEFAULT NULL,
  `xpe_deduct_rollbk_stance` varchar(6) DEFAULT NULL,
  `xpe_deduct_rollbk_resp` varchar(2) DEFAULT NULL,
  `xpe_deduct_roll_bk_response` varchar(20) DEFAULT NULL,
  `xpep_term_id` varchar(25) DEFAULT NULL,
  `xpep_term_idm` varchar(25) DEFAULT NULL,
  `xpep_intcd_no` varchar(40) DEFAULT NULL,
  `xpep_deduct_sys_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `xpep_deduct_stlm_date` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `xpep_trademsg_type` int(3) DEFAULT NULL COMMENT '交易类型',
  `flag` int(11) DEFAULT '0',
  `xpep_sendcde` char(8) DEFAULT NULL,
  `xpep_trade_card_type` varchar(20) DEFAULT NULL,
  `xpep_gain_sys_id` int(11) DEFAULT NULL,
  `xpep_gain_sys_stance` varchar(32) DEFAULT NULL,
  `xpep_gain_mer_code` varchar(32) DEFAULT NULL,
  `xpep_gain_mer_term_id` varchar(16) DEFAULT NULL,
  `xpep_gain_trade_amount` bigint(20) DEFAULT NULL,
  `xpep_gain_sys_response` varchar(6) DEFAULT NULL,
  `xpep_gain_sys_reference` varchar(12) DEFAULT NULL,
  `xpep_gain_result` int(11) DEFAULT NULL,
  `xpep_auth_code` varchar(55) DEFAULT NULL,
  `pos_flag` int(11) DEFAULT '0',
  `xpe_deduct_roll_bk_sys_reference` varchar(12) DEFAULT NULL,
  `xpep_posmercode` varchar(30) DEFAULT NULL,
  `xpep_postermcode` varchar(30) DEFAULT NULL,
  `chinnal_id` int(11) DEFAULT NULL,
  `xpep_intcdbank` varchar(30) DEFAULT NULL,
  `xpep_intcdname` varchar(30) DEFAULT NULL,
  `xpep_poitcde` char(3) DEFAULT NULL,
  `xpep_gpsid` varchar(32) DEFAULT NULL,
  `xpep_outcdtype` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `batch` (`batch`),
  KEY `gate` (`gate`),
  KEY `mid` (`mid`),
  KEY `sys_date` (`sys_date`,`mid`,`gate`,`tstat`),
  KEY `xpep_posmercode` (`xpep_posmercode`),
  KEY `terminal_number` (`terminal_number`),
  KEY `xpep_gpsid` (`xpep_gpsid`),
  KEY `xpe_deduct_mercode` (`xpe_deduct_mercode`),
  KEY `xpep_trade_resp` (`xpep_trade_resp`),
  KEY `gid` (`gid`),
  KEY `xpe_deduct_refer` (`xpe_deduct_refer`),
  KEY `xpep_mercode` (`xpep_mercode`),
  KEY `xpep_outcard` (`xpep_outcard`),
  KEY `chinnal_id` (`chinnal_id`),
  KEY `xpe_deduct_resp` (`xpe_deduct_resp`),
  KEY `xpep_term_id` (`xpep_term_id`),
  KEY `xpep_postermcode` (`xpep_postermcode`),
  KEY `oid` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;