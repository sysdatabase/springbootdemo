use springboot;
insert into t_user(username,password) values ('admin','acfd49ac226850a955ee2928c90583edf4cc8c9fdee8fc448a0431ba10c58e23a4931695aa63f5f7');
insert into t_user(username,password) values ('guest','0b396dc4a7c505a74fafc555df25ad4b288124c01ca2f6e4553edad64bc806b3ea48f9a8649c7436');

insert into t_role(role_name) values ('管理员');
insert into t_role(role_name) values ('访客');

insert into t_permission(permission_name) values ('/index');
insert into t_permission(permission_name) values ('/admin');

insert into t_user_role(u_id, r_id) values(1,1);
insert into t_user_role(u_id, r_id) values(2,2);

insert into t_role_permission(r_id, p_id) values(1,2);
insert into t_role_permission(r_id, p_id) values(2,1);