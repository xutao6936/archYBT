create sequence SEQ_MENU
increment by 1
start with 10
 cache 20;

create sequence SEQ_ROLE
increment by 1
start with 10
 cache 20;

/*==============================================================*/
/* Table: TOP_BANKINFO                                          */
/*==============================================================*/
create table TOP_BANKINFO  (
   BANK_ID              VARCHAR2(40)                    not null,
   BANK_CODE            VARCHAR2(40)                    not null,
   BANK_NAME            VARCHAR2(60)                    not null,
   BANK_LEVEL           VARCHAR2(2)                     not null,
   UP_BANK_CODE         VARCHAR2(40),
   ADDRESS              VARCHAR2(60),
   POSTCODE             VARCHAR2(40),
   PHONE                VARCHAR2(40),
   FAX                  VARCHAR2(40),
   STATUS               VARCHAR2(2),
   CREATE_DATE          VARCHAR2(8),
   UPDATE_DATE          VARCHAR2(8),
   UPDATE_TIME          VARCHAR2(6),
   CERT_NO              VARCHAR2(40),
   CERT_START_DATE      VARCHAR2(8),
   CERT_END_DATE        VARCHAR2(8),
   REMARK1              VARCHAR2(60),
   REMARK2              VARCHAR2(60),
   REMARK3              VARCHAR2(60),
   REMARK4              VARCHAR2(60),
   constraint PK_TOP_BANKINFO primary key (BANK_ID)
);

comment on table TOP_BANKINFO is
'机构表';

comment on column TOP_BANKINFO.BANK_ID is
'机构ID';

comment on column TOP_BANKINFO.BANK_CODE is
'机构编号';

comment on column TOP_BANKINFO.BANK_NAME is
'机构名称';

comment on column TOP_BANKINFO.BANK_LEVEL is
'机构级别(0:总行 1:分行 2:支行 3:网点 )';

comment on column TOP_BANKINFO.UP_BANK_CODE is
'上级机构编号';

comment on column TOP_BANKINFO.ADDRESS is
'机构地址';

comment on column TOP_BANKINFO.POSTCODE is
'邮编';

comment on column TOP_BANKINFO.PHONE is
'电话';

comment on column TOP_BANKINFO.FAX is
'传真';

comment on column TOP_BANKINFO.STATUS is
'状态(0:有效 1:无效)';

comment on column TOP_BANKINFO.CREATE_DATE is
'创建日期';

comment on column TOP_BANKINFO.UPDATE_DATE is
'更新日期';

comment on column TOP_BANKINFO.UPDATE_TIME is
'更新时间';

comment on column TOP_BANKINFO.CERT_NO is
'机构代理编号';

comment on column TOP_BANKINFO.CERT_START_DATE is
'代理开始日期';

comment on column TOP_BANKINFO.CERT_END_DATE is
'代理结束日期';

comment on column TOP_BANKINFO.REMARK1 is
'备用字段1';

comment on column TOP_BANKINFO.REMARK2 is
'备用字段2';

comment on column TOP_BANKINFO.REMARK3 is
'备用字段3';

comment on column TOP_BANKINFO.REMARK4 is
'备用字段4';

/*==============================================================*/
/* Table: TOP_MENUINFO                                          */
/*==============================================================*/
create table TOP_MENUINFO  (
   MENU_ID              VARCHAR2(40)                    not null,
   MENU_CODE            VARCHAR2(20)                    not null,
   MENU_NAME            VARCHAR2(50)                    not null,
   UP_MENU_CODE         VARCHAR2(20),
   MENU_URL             VARCHAR2(60),
   STATUS               VARCHAR2(2),
   CREATE_DATE          VARCHAR2(8),
   UPDATE_DATE          VARCHAR2(8),
   UPDATE_TIME          VARCHAR2(6),
   UPDATE_OPERATOR      VARCHAR2(40),
   ICON                 VARCHAR2(40),
   REMARK1              VARCHAR2(60),
   REMARK2              VARCHAR2(60),
   REMARK3              VARCHAR2(60),
   REMARK4              VARCHAR2(60),
   constraint PK_TOP_MENUINFO primary key (MENU_ID)
);

comment on table TOP_MENUINFO is
'菜单';

comment on column TOP_MENUINFO.MENU_ID is
'菜单ID';

comment on column TOP_MENUINFO.MENU_CODE is
'菜单编号';

comment on column TOP_MENUINFO.MENU_NAME is
'菜单名称';

comment on column TOP_MENUINFO.UP_MENU_CODE is
'上级菜单编号';

comment on column TOP_MENUINFO.MENU_URL is
'URL';

comment on column TOP_MENUINFO.STATUS is
'状态(0:有效 1:无效)';

comment on column TOP_MENUINFO.CREATE_DATE is
'创建日期';

comment on column TOP_MENUINFO.UPDATE_DATE is
'更新日期';

comment on column TOP_MENUINFO.UPDATE_TIME is
'更新时间';

comment on column TOP_MENUINFO.UPDATE_OPERATOR is
'更新账号';

comment on column TOP_MENUINFO.ICON is
'图标';

comment on column TOP_MENUINFO.REMARK1 is
'备用字段1';

comment on column TOP_MENUINFO.REMARK2 is
'备用字段2';

comment on column TOP_MENUINFO.REMARK3 is
'备用字段3';

comment on column TOP_MENUINFO.REMARK4 is
'备用字段4';

/*==============================================================*/
/* Table: TOP_MENU_ROLE                                         */
/*==============================================================*/
create table TOP_MENU_ROLE  (
   ID                   VARCHAR2(40)                    not null,
   ROLE_ID              VARCHAR2(60),
   MENU_ID              VARCHAR2(60),
   constraint PK_TOP_MENU_ROLE primary key (ID)
);

comment on table TOP_MENU_ROLE is
'角色菜单表';

comment on column TOP_MENU_ROLE.ID is
'ID';

comment on column TOP_MENU_ROLE.ROLE_ID is
'角色ID';

comment on column TOP_MENU_ROLE.MENU_ID is
'菜单ID';

/*==============================================================*/
/* Table: TOP_ROLEINFO                                          */
/*==============================================================*/
create table TOP_ROLEINFO  (
   ROLE_ID              VARCHAR2(40)                    not null,
   ROLE_CODE            VARCHAR2(20)                    not null,
   ROLE_NAME            VARCHAR2(40)                    not null,
   STATUS               VARCHAR2(2),
   DESCRIPTION          VARCHAR2(100),
   CREATE_DATE          VARCHAR2(8),
   UPDATE_DATE          VARCHAR2(8),
   UPDATE_TIME          VARCHAR2(6),
   UPDATE_OPERATOR      VARCHAR2(40),
   REMARK1              VARCHAR2(60),
   REMARK2              VARCHAR2(60),
   REMARK3              VARCHAR2(60),
   REMARK4              VARCHAR2(60),
   constraint PK_TOP_ROLEINFO primary key (ROLE_ID)
);

comment on table TOP_ROLEINFO is
'角色表';

comment on column TOP_ROLEINFO.ROLE_ID is
'角色ID';

comment on column TOP_ROLEINFO.ROLE_CODE is
'角色编号';

comment on column TOP_ROLEINFO.ROLE_NAME is
'角色名称';

comment on column TOP_ROLEINFO.STATUS is
'状态(0:有效1:无效)';

comment on column TOP_ROLEINFO.DESCRIPTION is
'描述';

comment on column TOP_ROLEINFO.CREATE_DATE is
'创建日期';

comment on column TOP_ROLEINFO.UPDATE_DATE is
'更新日期';

comment on column TOP_ROLEINFO.UPDATE_TIME is
'更新时间';

comment on column TOP_ROLEINFO.UPDATE_OPERATOR is
'更新账号';

comment on column TOP_ROLEINFO.REMARK1 is
'备用字段1';

comment on column TOP_ROLEINFO.REMARK2 is
'备用字段2';

comment on column TOP_ROLEINFO.REMARK3 is
'备用字段3';

comment on column TOP_ROLEINFO.REMARK4 is
'备用字段4';

/*==============================================================*/
/* Table: TOP_USERINFO                                          */
/*==============================================================*/
create table TOP_USERINFO  (
   USER_ID              VARCHAR2(40)                    not null,
   LOGIN_ACCOUNT        VARCHAR2(60)                    not null,
   LOGIN_PWD            VARCHAR2(60)                    not null,
   USER_NAME            VARCHAR2(30)                    not null,
   USER_STATUS          VARCHAR2(2),
   USER_DEPT            VARCHAR2(8),
   CREATE_DATE          VARCHAR2(40),
   OPERATOR_PHONE       VARCHAR2(20),
   UPDATE_DATE          VARCHAR2(8),
   UPDATE_TIME          VARCHAR2(6),
   UPDATE_OPERATOR      VARCHAR2(20),
   FILE_PATH            VARCHAR2(60),
   REMARK1              VARCHAR2(60),
   REMARK2              VARCHAR2(60),
   REMARK3              VARCHAR2(60),
   REMARK4              VARCHAR2(60),
   constraint PK_TOP_USERINFO primary key (USER_ID),
   constraint AK_UQ_ACCOUNT_TOP_USER unique (LOGIN_ACCOUNT)
);

comment on table TOP_USERINFO is
'用户表';

comment on column TOP_USERINFO.USER_ID is
'用户ID';

comment on column TOP_USERINFO.LOGIN_ACCOUNT is
'登录账号';

comment on column TOP_USERINFO.LOGIN_PWD is
'用户名';

comment on column TOP_USERINFO.USER_NAME is
'姓名';

comment on column TOP_USERINFO.USER_STATUS is
'状态（0:有效 1:无效）';

comment on column TOP_USERINFO.USER_DEPT is
'所属机构';

comment on column TOP_USERINFO.CREATE_DATE is
'创建日期';

comment on column TOP_USERINFO.OPERATOR_PHONE is
'用户电话';

comment on column TOP_USERINFO.UPDATE_DATE is
'更新日期';

comment on column TOP_USERINFO.UPDATE_TIME is
'更新时间';

comment on column TOP_USERINFO.UPDATE_OPERATOR is
'更新账号';

comment on column TOP_USERINFO.FILE_PATH is
'文件路径';

comment on column TOP_USERINFO.REMARK1 is
'备注字段1';

comment on column TOP_USERINFO.REMARK2 is
'备注字段2';

comment on column TOP_USERINFO.REMARK3 is
'备注字段3';

comment on column TOP_USERINFO.REMARK4 is
'备注字段4';

/*==============================================================*/
/* Table: TOP_USER_ROLE                                         */
/*==============================================================*/
create table TOP_USER_ROLE  (
   ID                   VARCHAR2(40)                    not null,
   ROLE_ID              VARCHAR2(60)                    not null,
   USER_ID              VARCHAR2(60),
   CREATE_DATE          VARCHAR2(8),
   UPDATE_DATE          VARCHAR2(8),
   constraint PK_TOP_USER_ROLE primary key (ID)
);

comment on table TOP_USER_ROLE is
'用户角色绑定表';

comment on column TOP_USER_ROLE.ID is
'ID';

comment on column TOP_USER_ROLE.ROLE_ID is
'角色ID';

comment on column TOP_USER_ROLE.USER_ID is
'用户ID';

comment on column TOP_USER_ROLE.CREATE_DATE is
'创建日期';

comment on column TOP_USER_ROLE.UPDATE_DATE is
'更新日期';

alter table TOP_MENU_ROLE
   add constraint FK_TOP_MENU_REFERENCE_TOP_ROLE foreign key (ROLE_ID)
      references TOP_ROLEINFO (ROLE_ID);

alter table TOP_MENU_ROLE
   add constraint FK_TOP_MENU_REFERENCE_TOP_MENU foreign key (MENU_ID)
      references TOP_MENUINFO (MENU_ID);

alter table TOP_USER_ROLE
   add constraint FK_TOP_USER_REFERENCE_TOP_ROLE foreign key (ROLE_ID)
      references TOP_ROLEINFO (ROLE_ID);

alter table TOP_USER_ROLE
   add constraint FK_TOP_USER_REFERENCE_TOP_USER foreign key (USER_ID)
      references TOP_USERINFO (USER_ID);
