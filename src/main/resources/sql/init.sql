
insert into TOP_BANKINFO (bank_id, bank_code, bank_name, bank_level, up_bank_code, address, postcode, phone, fax, status, create_date, update_date, update_time, cert_no, cert_start_date, cert_end_date, remark1, remark2, remark3, remark4)
values ('260da8853a234662a07ab71a3eb51665', '9901', '总行', '0', null, '上海', '210000', null, null, null, '20160906', '20160906', '103223', null, null, null, null, null, null, null);
commit;
insert into TOP_BANKINFO (bank_id, bank_code, bank_name, bank_level, up_bank_code, address, postcode, phone, fax, status, create_date, update_date, update_time, cert_no, cert_start_date, cert_end_date, remark1, remark2, remark3, remark4)
values ('260da8853b234662a07ab71a3eb51665', '9801', '南京分行', '1', null, '南京', '210000', null, null, null, '20160906', '20160906', '103223', null, null, null, null, null, null, null);
commit;
----prompt 1 records loaded
----prompt Loading TOP_MENUINFO...
insert into TOP_MENUINFO (menu_id, menu_code, menu_name, up_menu_code, menu_url, status, create_date, update_date, update_time, update_operator, icon, remark1, remark2, remark3, remark4)
values ('975bcca2aa80449ea95a04638775ec06', '0', '移动端菜单', 'YBT_YD', null, '0', '20160701', '20160701', '103409', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, menu_name, up_menu_code, menu_url, status, create_date, update_date, update_time, update_operator, icon, remark1, remark2, remark3, remark4)
values ('260da8853a234662a07ab71a3eb51665', '1004', '机构管理', '1', '../system/bankinfo.jsp', '0', '20160701', '20160701', '103551', '0000', 'icon-user', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, menu_name, up_menu_code, menu_url, status, create_date, update_date, update_time, update_operator, icon, remark1, remark2, remark3, remark4)
values ('5c71f6747bca498db9ea4efd83eecf05', '1', '业务管理', 'YBT', null, '0', '20160701', '20160701', '103428', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, menu_name, up_menu_code, menu_url, status, create_date, update_date, update_time, update_operator, icon, remark1, remark2, remark3, remark4)
values ('bda0c017a1d844edb4cfc24c1125fd05', 'YBT', '后端菜单', '0', null, '0', '20160701', '20160701', '103350', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (menu_id, menu_code, menu_name, up_menu_code, menu_url, status, create_date, update_date, update_time, update_operator, icon, remark1, remark2, remark3, remark4)
values ('260da8853a234652a07ab71a3eb51657', '1001', '用户管理', '1', '../system/userList.jsp', '0', '20160701', '20160701', '103551', '0000', 'icon-user', null, null, null, null);
commit;
----prompt 5 records loaded
----prompt Loading TOP_ROLEINFO...
insert into TOP_ROLEINFO (role_id, role_code, role_name, status, description, create_date, update_date, update_time, update_operator, remark1, remark2, remark3, remark4)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1', '管理员', '0', null, '20160906', '20160906', '103232', null, null, null, null, null);
commit;
----prompt 1 records loaded
----prompt Loading TOP_MENU_ROLE...
insert into TOP_MENU_ROLE (id, role_id, menu_id)
values ('260da8853a234652a07ab71a3eb51665', '1db8d466a1f1458789fb6b031f4a3f10', '5c71f6747bca498db9ea4efd83eecf05');
insert into TOP_MENU_ROLE (id, role_id, menu_id)
values ('260da8853a234652a07ab71a3eb51663', '1db8d466a1f1458789fb6b031f4a3f10', 'bda0c017a1d844edb4cfc24c1125fd05');
insert into TOP_MENU_ROLE (id, role_id, menu_id)
values ('260da8853a234652a07ab71a3eb51664', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234652a07ab71a3eb51657');
commit;
----prompt 3 records loaded
----prompt Loading TOP_USERINFO...
insert into TOP_USERINFO (user_id, login_account, login_pwd, user_name, user_status, user_dept, create_date, operator_phone, update_date, update_time, update_operator, file_path, remark1, remark2, remark3, remark4)
values ('9ee9cfe8c489490795fa056d3ed7be3a', '000000', '111111', '管理员', '0', '9901', '20160906', null, '20160906', '103232', null, null, null, null, null, null);
commit;
----prompt 1 records loaded
----prompt Loading TOP_USER_ROLE...
insert into TOP_USER_ROLE (id, role_id, user_id, create_date, update_date)
values ('97cf7d6e550b41ada81d6c4f54fe85f8', '1db8d466a1f1458789fb6b031f4a3f10', '9ee9cfe8c489490795fa056d3ed7be3a', '20160906', '20160906');
commit;

