
insert into TOP_BANKINFO (bank_code, bank_name, bank_level, up_bankcode, admin_flag, address, postcode, phone, fax, status, operator_bankcode, operator_code, updatedate, updatetime, certno, certenddate, certstartdate)
values ('01201', '总行', '1', '0', '0', null, null, null, null, '0', '1', 'user', '20160612', '100820', null, null, null);
commit;
----prompt 1 records loaded
----prompt Loading TOP_MENUINFO...
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234662a07ab71a3eb51665', '1004', '1', '机构管理', '../system/bankinfo.jsp', '0', '20160701', '20160701', '103551', '0000', 'icon-user', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('bda0c017a1d844edb4cfc24c1125fd05', 'YBT', '0', '后端菜单', null, '0', '20160701', '20160701', '103350', '0000', null, null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('975bcca2aa80449ea95a04638775ec06', 'YBT_YD', '0', '移动端菜单', null, '0', '20160701', '20160701', '103409', '0000', null, null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('5c71f6747bca498db9ea4efd83eecf05', '1', 'YBT', '业务管理', null, '0', '20160701', '20160701', '103428', '0000', 'icon-group', null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51652', '2', 'YBT_YD', '投保业务', null, '0', '20160701', '20160701', '103459', '0000', null, null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('e3dd932ac71248709550672cb86a483e', '3', 'YBT', '合规管理', null, '0', '20160701', '20160701', '103551', '0000', 'icon-desktop', null, 'YBT_YD', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51653', '4', 'YBT', '运营管理', null, '0', '20160701', '20160701', '103551', '0000', 'icon-desktop', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51654', '5', 'YBT', '系统管理', null, '0', '20160701', '20160701', '103551', '0000', 'icon-cog', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51655', '6', 'YBT', 'job管理', null, '0', '20160701', '20160701', '103551', '0000', 'icon-desktop', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51656', '7', 'YBT', '系统监控', null, '0', '20160701', '20160701', '103551', '0000', 'icon-desktop', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51657', '1001', '1', '用户管理', '../system/userList.jsp', '0', '20160701', '20160701', '103551', '0000', 'icon-user', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51658', '6003', '6', '计划任务列表', 'job/toQueryPlanJobList.do', '0', '20160701', '20160701', '103551', '0000', 'icon-leaf', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51659', '1002', '1', '角色管理', '../system/roleinfo.jsp', '0', '20160701', '20160701', '103551', '0000', 'icon-user', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51664', '1003', '1', '菜单管理', '../system/menuinfo.jsp', '0', '20160701', '20160701', '103551', '0000', 'icon-lock', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51661', '6001', '6', '增加job任务', 'job/toAddJob.do', '0', '20160701', '20160701', '103551', '0000', 'icon-leaf', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51662', '6002', '6', '新增任务列表', 'job/toScheduleJobList.do', '0', '20160701', '20160701', '103551', '0000', 'icon-leaf', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51663', '7001', '7', 'druid监控', 'druid/index.html', '0', '20160701', '20160701', '103551', '0000', 'icon-leaf', null, null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, fa_menu_code, menu_name, menu_url, status, create_date, update_date, update_time, update_operator, icon, belong_system, remark1, remark2, remark3, remark4, remark5)
values ('260da8853a234652a07ab71a3eb51665', '7002', '7', 'JavaMelody应用监控', 'monitoring', '0', '20160701', '20160701', '103551', '0000', 'icon-leaf', null, null, null, null, null, null);
commit;
----prompt 18 records loaded
----prompt Loading TOP_ROLEINFO...
insert into TOP_ROLEINFO (role_id, role_code, role_name, description, isreview, status, create_date, update_date, update_time, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1', '管理员', null, '0', '0', '20160628', '20160628', '162215', '444444', null, null, null, null, null);
insert into TOP_ROLEINFO (role_id, role_code, role_name, description, isreview, status, create_date, update_date, update_time, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '2', '产品管理员', null, '0', '0', '20160704', '20160704', '225102', '0000', null, null, null, null, null);
commit;
----prompt 2 records loaded
----prompt Loading TOP_TASK_MENU...
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1001', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1002', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1003', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '1004', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '1001', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '1002', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '1003', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '3', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '4', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '5', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '6', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '6003', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '6001', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '6002', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '7', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '7001', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '7002', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', 'YBT_YD', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '2', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', 'YBT', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '1', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', 'YBT', '20160705', '20160705', null, null, null, null, null);
insert into TOP_TASK_MENU (role_id, menu_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1004', '20160705', '20160705', null, null, null, null, null);
commit;
----prompt 23 records loaded
----prompt Loading TOP_USERINFO...
insert into TOP_USERINFO (user_id, login_account, login_pwd, user_name, user_level, user_dept, user_status, isreview, create_date, update_date, update_time, update_operator, salt, file_path, remark1, remark2, remark3, remark4, remark5)
values ('1', 'user', '123456', '用户', '1', '01201', '1', '1', '20160611', '20160611', '175323', '000000', null, '/home/user/美女.jpg', null, null, null, null, null);
insert into TOP_USERINFO (user_id, login_account, login_pwd, user_name, user_level, user_dept, user_status, isreview, create_date, update_date, update_time, update_operator, salt, file_path, remark1, remark2, remark3, remark4, remark5)
values ('9ee9cfe8c489490795fa056d3ed7be3a', 'admin', 'admin', '管理员', null, '01201', '0', '0', '20160611', '20160611', '181816', 'user', null, '/home/user/美女.jpg', null, null, null, null, null);
commit;
----prompt 2 records loaded
----prompt Loading TOP_USER_ROLE...
insert into TOP_USER_ROLE (user_id, role_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('9ee9cfe8c489490795fa056d3ed7be3a', '97cf7d6e550b41ada81d6c4f54fe85f8', '20160705', '20160705', null, null, null, null, null);
insert into TOP_USER_ROLE (user_id, role_id, create_date, update_operator, remark1, remark2, remark3, remark4, remark5)
values ('1', '1db8d466a1f1458789fb6b031f4a3f10', '20160628', '111111', null, null, null, null, null);
commit;

----prompt Done.
