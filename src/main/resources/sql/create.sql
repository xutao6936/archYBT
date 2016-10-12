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
	  
	  
	  
	  
/*==============================================================*/
/* Table: TOP_AGENTRATE                                         */
/*==============================================================*/
create table TOP_AGENTRATE  (
   ID                   VARCHAR2(40)                    not null,
   INSPRD_CODE          VARCHAR2(40)                    not null,
   ADMIN_BANK           VARCHAR2(30),
   TRANS_TYPE           VARCHAR2(10),
   PAY_TYPE             VARCHAR2(10),
   PAY_PERIOD           VARCHAR2(10),
   PAY_PERIOD_TYPE      VARCHAR2(10),
   RATE_TYPE            VARCHAR2(2),
   ONCE_AMT             VARCHAR2(30),
   PERCENT_AMT          VARCHAR2(10),
   INS_PERIOD           VARCHAR2(10),
   INS_PERIOD_TYPE      VARCHAR2(10),
   OPERATOR             VARCHAR2(30),
   OPERATOR_BANK        VARCHAR2(30),
   UPDATE_DATE          VARCHAR2(10),
   UPDATE_TIME          VARCHAR2(10),
   constraint PK_TOP_AGENTRATE primary key (ID)
);

comment on table TOP_AGENTRATE is
'代理费率表';

comment on column TOP_AGENTRATE.ID is
'ID';

comment on column TOP_AGENTRATE.INSPRD_CODE is
'产品编码';

comment on column TOP_AGENTRATE.ADMIN_BANK is
'机构';

comment on column TOP_AGENTRATE.TRANS_TYPE is
'交易类型(1:实时 2:非实时)';

comment on column TOP_AGENTRATE.PAY_TYPE is
'缴费类型(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';

comment on column TOP_AGENTRATE.PAY_PERIOD is
'缴费年期';

comment on column TOP_AGENTRATE.PAY_PERIOD_TYPE is
'缴费年期单位(0:年1:周岁 2:终身)';

comment on column TOP_AGENTRATE.RATE_TYPE is
'收费方式(1:一次性2:百分比)';

comment on column TOP_AGENTRATE.ONCE_AMT is
'一次性金额';

comment on column TOP_AGENTRATE.PERCENT_AMT is
'百分比';

comment on column TOP_AGENTRATE.INS_PERIOD is
'保障年期';

comment on column TOP_AGENTRATE.INS_PERIOD_TYPE is
'保障年期单位(0:年1:周岁2:保终身)';

comment on column TOP_AGENTRATE.OPERATOR is
'柜员号';

comment on column TOP_AGENTRATE.OPERATOR_BANK is
'机构';

comment on column TOP_AGENTRATE.UPDATE_DATE is
'更新日期';

comment on column TOP_AGENTRATE.UPDATE_TIME is
'更新时间';

/*==============================================================*/
/* Table: TOP_BANKINS                                           */
/*==============================================================*/
create table TOP_BANKINS  (
   ID                   VARCHAR2(40)                    not null,
   INSCORP_CODE         VARCHAR2(30)                    not null,
   INSPRD_CODE          VARCHAR2(30)                    not null,
   BANK_CODE            VARCHAR2(20)                    not null,
   ORG_CODE             VARCHAR2(20)                    not null,
   CHANNEL              VARCHAR2(4)                     not null,
   OPERATOR             VARCHAR2(30)                    not null,
   UPDATE_DATE          VARCHAR2(10)                    not null,
   UPDATE_TIME          VARCHAR2(10)                    not null,
   constraint PK_TOP_BANKINS primary key (ID)
);

comment on table TOP_BANKINS is
'产品与机构签约表';

comment on column TOP_BANKINS.ID is
'ID';

comment on column TOP_BANKINS.INSCORP_CODE is
'公司编码';

comment on column TOP_BANKINS.INSPRD_CODE is
'产品编码';

comment on column TOP_BANKINS.BANK_CODE is
'机构号';

comment on column TOP_BANKINS.ORG_CODE is
'上级机构号';

comment on column TOP_BANKINS.CHANNEL is
'渠道(01:柜面02:网银03:手机04:直销05:自助)';

comment on column TOP_BANKINS.OPERATOR is
'操作柜员';

comment on column TOP_BANKINS.UPDATE_DATE is
'更新日期';

comment on column TOP_BANKINS.UPDATE_TIME is
'更新时间';

/*==============================================================*/
/* Table: TOP_BASICKIND                                         */
/*==============================================================*/
create table TOP_BASICKIND  (
   ID                   VARCHAR2(40)                    not null,
   CODE                 VARCHAR2(40)                    not null,
   VALUE                VARCHAR2(40)                    not null,
   KIND_CODE            VARCHAR2(40)                    not null,
   KIND_VALUE           VARCHAR2(40)                    not null,
   UPDATE_DATE          VARCHAR2(10)                    not null,
   OPERATOR             VARCHAR2(40)                    not null,
   UPDATE_TIME          VARCHAR2(10)                    not null,
   constraint PK_TOP_BASICKIND primary key (ID)
);

comment on table TOP_BASICKIND is
'数据字典表';

/*==============================================================*/
/* Table: TOP_INSCORPINFO                                       */
/*==============================================================*/
create table TOP_INSCORPINFO  (
   ID                   VARCHAR2(40)                    not null,
   INSCORP_CODE         VARCHAR2(10)                    not null,
   INSCORP_NAME         VARCHAR2(60)                    not null,
   INS_SIMPLE_NAME      VARCHAR2(40)                    not null,
   INSCORP_LEVEL        VARCHAR2(2)                     not null,
   UPCORP_CODE          VARCHAR2(10),
   INSCORP_EN_NAME      VARCHAR2(60),
   ADDRESS              VARCHAR2(80),
   POSTCODE             VARCHAR2(20),
   PHONE                VARCHAR2(20),
   FAX                  VARCHAR2(20),
   EMAIL                VARCHAR2(2),
   STATUS               VARCHAR2(40),
   OPERATOR_CODE        VARCHAR2(40),
   OPERATOR_BANK        VARCHAR2(40),
   CREATE_DATE          VARCHAR2(8),
   UPDATE_DATE          VARCHAR2(8),
   UPDATE_TIME          VARCHAR2(10),
   COMMON_COUNTER_FLAG  VARCHAR2(2)                    default '0',
   COMMON_NET_FLAG      VARCHAR2(2)                    default '0',
   COMMON_CHECK_FLAG    VARCHAR2(2)                    default '0',
   COMMON_NOSSDCHECK_FLAG VARCHAR2(2)                    default '0',
   COMMON_SYSTB_FLAG    VARCHAR2(2)                    default '0',
   CHANNEL_FLAG         VARCHAR2(20),
   constraint PK_TOP_INSCORPINFO primary key (ID),
   constraint AK_KEY_2_TOP_INSC unique (INSCORP_CODE)
);

comment on table TOP_INSCORPINFO is
'保险公司信息表';

comment on column TOP_INSCORPINFO.ID is
'ID';

comment on column TOP_INSCORPINFO.INSCORP_CODE is
'保险公司编码';

comment on column TOP_INSCORPINFO.INSCORP_NAME is
'保险公司名称';

comment on column TOP_INSCORPINFO.INS_SIMPLE_NAME is
'保险公司简称(4或5位)';

comment on column TOP_INSCORPINFO.INSCORP_LEVEL is
'保险公司等级(0:总公司 1:分公司)';

comment on column TOP_INSCORPINFO.UPCORP_CODE is
'上级公司代码';

comment on column TOP_INSCORPINFO.INSCORP_EN_NAME is
'保险公司英文名称';

comment on column TOP_INSCORPINFO.ADDRESS is
'地址';

comment on column TOP_INSCORPINFO.POSTCODE is
'邮编';

comment on column TOP_INSCORPINFO.PHONE is
'联系电话';

comment on column TOP_INSCORPINFO.FAX is
'传真';

comment on column TOP_INSCORPINFO.EMAIL is
'EMAIL';

comment on column TOP_INSCORPINFO.STATUS is
'状态(0:有效1:无效)';

comment on column TOP_INSCORPINFO.OPERATOR_CODE is
'操作员';

comment on column TOP_INSCORPINFO.OPERATOR_BANK is
'操作机构';

comment on column TOP_INSCORPINFO.CREATE_DATE is
'创建日期';

comment on column TOP_INSCORPINFO.UPDATE_DATE is
'更新日期';

comment on column TOP_INSCORPINFO.UPDATE_TIME is
'更新时间';

comment on column TOP_INSCORPINFO.COMMON_COUNTER_FLAG is
'统一柜面接口(0:是 1:否)';

comment on column TOP_INSCORPINFO.COMMON_NET_FLAG is
'统一网销接口(0:是 1:否)';

comment on column TOP_INSCORPINFO.COMMON_CHECK_FLAG is
'统一对账接口(0:是 1:否)';

comment on column TOP_INSCORPINFO.COMMON_NOSSDCHECK_FLAG is
'统一非实时对账接口(0:是 1:否)';

comment on column TOP_INSCORPINFO.COMMON_SYSTB_FLAG is
'统一退保接口(0:是 1:否)';

comment on column TOP_INSCORPINFO.CHANNEL_FLAG is
'开通渠道(01:柜面02:网银03:手机04:直销05:自助)';

/*==============================================================*/
/* Table: TOP_INSPRDINFO                                        */
/*==============================================================*/
create table TOP_INSPRDINFO  (
   ID                   VARCHAR2(40)                    not null,
   INSPRD_CODE          VARCHAR2(30)                    not null,
   INSPRD_TRUE_CODE     VARCHAR2(30)                    not null,
   INSCORP_CODE         VARCHAR2(30)                    not null,
   INSPRD_CNNAME        VARCHAR2(60)                    not null,
   INSPRD_SIMNAME       VARCHAR2(30),
   ASSURANCE_TYPE       VARCHAR2(2)                     not null,
   BUY_UNIT             VARCHAR2(2),
   INSPRD_TYPE          VARCHAR2(2),
   INSBENGIN_DATE       VARCHAR2(10),
   INSEND_DATE          VARCHAR2(10),
   START_AMT            VARCHAR2(30),
   END_AMT              VARCHAR2(30),
   INCREASE_AMT         VARCHAR2(30),
   STATUS               VARCHAR2(2),
   IMPAWN_FLAG          VARCHAR2(2),
   TRANS_TYPE           VARCHAR2(2),
   CHANNEL_TYPE         VARCHAR2(20),
   CREATE_DATE          VARCHAR2(10),
   UPDATE_DATE          VARCHAR2(10),
   UPDATE_TIME          VARCHAR2(10),
   OPERATOR             VARCHAR2(40),
   IS_OVER_RISK         VARCHAR2(2),
   HOT_TYPE             VARCHAR2(2),
   YIELD_RATE           VARCHAR2(20),
   MIN_YIELD_RATE       VARCHAR2(20),
   MAX_YIELD_RATE       VARCHAR2(20),
   constraint PK_TOP_INSPRDINFO primary key (ID)
);

comment on table TOP_INSPRDINFO is
'保险产品信息表';

comment on column TOP_INSPRDINFO.ID is
'ID';

comment on column TOP_INSPRDINFO.INSPRD_CODE is
'产品代码';

comment on column TOP_INSPRDINFO.INSPRD_TRUE_CODE is
'产品真实代码';

comment on column TOP_INSPRDINFO.INSCORP_CODE is
'公司编码';

comment on column TOP_INSPRDINFO.INSPRD_CNNAME is
'产品名称';

comment on column TOP_INSPRDINFO.INSPRD_SIMNAME is
'产品简称';

comment on column TOP_INSPRDINFO.ASSURANCE_TYPE is
'主附险标志(0:主险 1:附加险)';

comment on column TOP_INSPRDINFO.BUY_UNIT is
'购买单位(0:份数 1:保费 2:保额)';

comment on column TOP_INSPRDINFO.INSPRD_TYPE is
'产品类型';

comment on column TOP_INSPRDINFO.INSBENGIN_DATE is
'代理开始日期';

comment on column TOP_INSPRDINFO.INSEND_DATE is
'代理结束日期';

comment on column TOP_INSPRDINFO.START_AMT is
'起购金额/数量';

comment on column TOP_INSPRDINFO.END_AMT is
'最高金额/数量';

comment on column TOP_INSPRDINFO.INCREASE_AMT is
'递增金额/数量';

comment on column TOP_INSPRDINFO.STATUS is
'状态(0:有效 1:无效)';

comment on column TOP_INSPRDINFO.IMPAWN_FLAG is
'是否可质押(0:是 1:否)';

comment on column TOP_INSPRDINFO.TRANS_TYPE is
'交易类型(0:全部1:实时2:非实时)';

comment on column TOP_INSPRDINFO.CHANNEL_TYPE is
'交易渠道(01:柜面02:网银03:手机04:直销05:自助)';

comment on column TOP_INSPRDINFO.CREATE_DATE is
'创建日期';

comment on column TOP_INSPRDINFO.UPDATE_DATE is
'更新日期';

comment on column TOP_INSPRDINFO.UPDATE_TIME is
'更新时间';

comment on column TOP_INSPRDINFO.OPERATOR is
'操作员';

comment on column TOP_INSPRDINFO.IS_OVER_RISK is
'是否允许超风险购买';

comment on column TOP_INSPRDINFO.HOT_TYPE is
'1:新 2:抢3:热';

comment on column TOP_INSPRDINFO.YIELD_RATE is
'预期收益率';

comment on column TOP_INSPRDINFO.MIN_YIELD_RATE is
'最低收益率';

comment on column TOP_INSPRDINFO.MAX_YIELD_RATE is
'最高受益率';


/*==============================================================*/
/* Table: TOP_INSPRDPERIOD                                      */
/*==============================================================*/
create table TOP_INSPRDPERIOD  (
   ID                   VARCHAR2(40)                    not null,
   INSPRD_CODE          VARCHAR2(20)                    not null,
   KEY                  VARCHAR2(4),
   UNIT                 VARCHAR2(4)
);

comment on table TOP_INSPRDPERIOD is
'保障年期表';

comment on column TOP_INSPRDPERIOD.ID is
'ID';

comment on column TOP_INSPRDPERIOD.INSPRD_CODE is
'产品编码';

comment on column TOP_INSPRDPERIOD.KEY is
'值(如单位为终身, 则值为2)';

comment on column TOP_INSPRDPERIOD.UNIT is
'单位(0-年   1-周岁   2-保终身 )';

/*==============================================================*/
/* Table: TOP_PAYPERIOD                                         */
/*==============================================================*/
create table TOP_PAYPERIOD  (
   ID                   VARCHAR2(40)                    not null,
   INSPRD_CODE          VARCHAR2(20)                    not null,
   KEY                  VARCHAR2(4),
   UNIT                 VARCHAR2(4)
);

comment on table TOP_PAYPERIOD is
'缴费年期表';

comment on column TOP_PAYPERIOD.ID is
'ID';

comment on column TOP_PAYPERIOD.INSPRD_CODE is
'产品编码';

comment on column TOP_PAYPERIOD.KEY is
'值(如单位为终身, 则值为2)';

comment on column TOP_PAYPERIOD.UNIT is
'单位(0-年   1-周岁   2-终身 )';

/*==============================================================*/
/* Table: TOP_PAYTYPE                                           */
/*==============================================================*/
create table TOP_PAYTYPE  (
   ID                   VARCHAR2(40)                    not null,
   INSPRD_CODE          VARCHAR2(20)                    not null,
   KEY                  VARCHAR2(4),
   VALUE                VARCHAR2(4),
   constraint PK_TOP_PAYTYPE primary key (ID)
);

comment on table TOP_PAYTYPE is
'缴费类型表';

comment on column TOP_PAYTYPE.ID is
'ID';

comment on column TOP_PAYTYPE.INSPRD_CODE is
'产品编码';

comment on column TOP_PAYTYPE.KEY is
'键(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';

comment on column TOP_PAYTYPE.VALUE is
'值(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';