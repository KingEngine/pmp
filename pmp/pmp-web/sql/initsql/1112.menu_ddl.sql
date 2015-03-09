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
-- 管理平台一级菜单(3位)
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type)
values(1000,"交易管理","#",1,0,0,'mms');

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type)
values(3000,"商户管理","#",1,0,0,'mms');

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type)
values(4000,"用户管理","#",1,0,0,'mms');
-- 管理平台二级菜单(3位)
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(1010,"交易查询","#",2,1,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(4010,"用户管理","#",2,4000,0);
-- 管理平台三级菜单(3位)
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(1011,"当天交易查询","getCurrentTradePagePre.do",3,1010,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(1012,"历史明细查询","getHistoryTradePagePre.do",3,1010,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(4011,"操作员管理","managerOperationPre.do",3,4010,0);

-- 工作流一级菜单(4位)
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type,menu_department)
values(10000,"运行部门","#",1,0,0,'work_flow','OPERATION_DEPARTMENT');

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type,menu_department)
values(20000,"风控部门","#",1,0,0,'work_flow','RISK_DEPARTMENT');

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type,menu_department)
values(30000,"业管部门","#",1,0,0,'work_flow','BUSINESS_DEAPARTMENT');

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status,menu_type,menu_department)
values(40000,"终端部门","#",1,0,0,'work_flow','TERMMANAGER_DEPARTMENT');
-- 工作流二级菜单(4位)
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(10100,"运行部门","#",2,10000,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(20100,"风控部门","#",2,20000,0);
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)values(30100,"业管部门","#",2,30000,0);
-- 工作流三级菜单(4位)
insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(10101,"商户查询","operationMerInfoQueryPre.do",3,10100,0);

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(10102,"商户申请","operationAddMerInfoPre.do",3,10100,0);

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(20101,"商户查询","riskMerInfoQueryPre.do",3,20100,0);

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(20102,"任务办理","riskTaskHandlePre.do",3,20100,0);

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(30101,"商户查询","businessMerInfoQueryPre.do",3,30100,0);

insert into menu(menu_id,menu_name,menu_url,menu_level,parent_menu_id,menu_status)
values(30102,"任务办理","businessTaskHandlePre.do",3,30100,0);


