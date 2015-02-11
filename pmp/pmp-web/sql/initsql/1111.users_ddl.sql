DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  id bigint(20) primary key AUTO_INCREMENT,
  user_name varchar(50) unique key not null comment '用户名',
  user_password varchar(50) not null comment'密码',
  role_type varchar(50) comment'角色类型:ROLE_USER,ROLE_ADMIN',
  status char not null comment'状态,1:关闭 0:正常',
  last_login_time datetime comment'上次登录时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into users('user_name','user_password','status')values("admin","admin",1);