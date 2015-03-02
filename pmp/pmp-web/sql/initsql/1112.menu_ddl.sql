DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  id int primary key AUTO_INCREMENT comment '主键',
  menu_id int unique key not null comment '菜单编号',
  menu_name varchar(100) not null comment '菜单名称',
  menu_url varchar(50) not null comment '请求url,*.do 或者 #',
  menu_level int comment '菜单级别:1:一级  2:二级 3:三级',
  parent_menu_id int comment '父级菜单,一级菜单为0',
  menu_status int comment'菜单状态:1:关闭 0:启用',
  menu_type varchar(50) comment'菜单类型:work_flow:工作流 mms:管理平台',
  menu_department varchar(50) comment '菜单对应的部门权限:风控:RISK_DEPARTMENT,业管:BUSINESS_DEAPARTMENT,运行:OPERATION_DEPARTMENT'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 一级菜单
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type)values(1,"交易管理","#",1,0,0,'mms');
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type)values(2,"退款管理","#",1,0,0,'mms');
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type,menu_department)values(212,"运行部门","#",1,0,0,'work_flow','RISK_DEPARTMENT');
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type)values(3,"用户管理","#",1,0,0,'mms');
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type)values(4,"商户管理","#",1,0,0,'mms');
-- 二级菜单
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(199,"交易查询","#",2,1,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(221,"运行部门","#",2,212,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(231,"用户管理","#",2,3,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(241,"POS商户信息管理","#",2,4,0);
-- 三级菜单
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(6,"当天交易查询","getCurrentTradePagePre.do",3,199,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(2,"历史明细查询","getHistoryTradePagePre.do",3,199,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(321,"商户申请","fillMerchantInfoPre.do",3,221,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(322,"商户查询","merInfoQueryPre.do",3,221,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(323,"任务查看","workFlowTaskQueryPre.do",3,221,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(331,"操作员管理","managerOperationPre.do",3,231,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(341,"POS商户基本信息修改","merchantBaseInfoModifyPre.do",3,241,0);