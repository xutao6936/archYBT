
insert into TOP_BANKINFO (bank_code, bank_name, bank_level, up_bankcode, admin_flag, address, postcode, phone, fax, status, operator_bankcode, operator_code, updatedate, updatetime, certno, certenddate, certstartdate)
values ('01201', '总行', '1', '0', '0', null, null, null, null, '0', '1', 'user', '20160612', '100820', null, null, null);
commit;
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('bda0c017a1d844edb4cfc24c1125fd05', 'YBT', '0', '后端菜单', null, '0', '20160701', '20160701', '103350', '0000', null, null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('975bcca2aa80449ea95a04638775ec06', 'YBT_YD', '0', '移动端菜单', null, '0', '20160701', '20160701', '103409', '0000', null, null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('5c71f6747bca498db9ea4efd83eecf05', '1', 'YBT', '业务管理', null, '0', '20160701', '20160701', '103428', '0000', null, null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51652', '2', 'YBT_YD', '投保业务', null, '0', '20160701', '20160701', '103459', '0000', null, null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('e3dd932ac71248709550672cb86a483e', '3', '1', '用户管理', null, '0', '20160701', '20160701', '103551', '0000', null, null, 'YBT_YD', null, null, null, null);
commit;
insert into TOP_ROLEINFO (role_id, role_code, role_name, description, isreview, status, create_date, update_date, update_time, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1', '管理员', null, '0', '0', '20160628', '20160628', '162215', '444444', null, null, null, null, null);
commit;
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', 'YBT', '20160701', '20160701', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1', '20160701', '20160701', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '3', '20160701', '20160701', null, null, null, null, null);
commit;
insert into TOP_USERINFO (user_id, login_account, login_pwd, user_name, user_level, user_dept, user_status, isreview, create_date, update_date, update_time, update_operator, salt, file_path, remark1, remark2, remark3, remark4, remark5)
values ('1', 'user', '123456', '用户', '1', '01201', '1', '1', '20160611', '20160611', '175323', '000000', null, '/home/user/美女.jpg', null, null, null, null, null);
insert into TOP_USERINFO (user_id, login_account, login_pwd, user_name, user_level, user_dept, user_status, isreview, create_date, update_date, update_time, update_operator, salt, file_path, remark1, remark2, remark3, remark4, remark5)
values ('9ee9cfe8c489490795fa056d3ed7be3a', 'admin', 'admin', '管理员', null, '01201', '0', '0', '20160611', '20160611', '181816', 'user', null, '/home/user/美女.jpg', null, null, null, null, null);
commit;
insert into TOP_USER_ROLE (user_id, role_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1', '1db8d466a1f1458789fb6b031f4a3f10', '20160628', '111111', null, null, null, null, null);
commit;
