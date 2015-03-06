DROP TABLE IF EXISTS `users_authorities`;
CREATE TABLE `users_authorities` (
  id  bigint(20) primary key AUTO_INCREMENT comment '主键',
  user_id bigint(20),
  menu_id varchar(10),
  unique KEY  (`user_id`,`menu_id`),
  constraint fk_user_id Foreign Key(user_id) 
  References users(id),
  constraint fk_menu_id Foreign Key(menu_id) 
  References menu(menu_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert users_authorities(user_id,menu_id) values(1,1);
insert users_authorities(user_id,menu_id) values(1,8);
insert users_authorities(user_id,menu_id) values(1,212);
insert users_authorities(user_id,menu_id) values(1,199);
insert users_authorities(user_id,menu_id) values(1,221);
insert users_authorities(user_id,menu_id) values(1,6);
insert users_authorities(user_id,menu_id) values(1,2);
insert users_authorities(user_id,menu_id) values(1,321);
insert users_authorities(user_id,menu_id) values(1,322);
insert users_authorities(user_id,menu_id) values(1,323);