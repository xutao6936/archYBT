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

/*==============================================================*/
/* Table: TOP_BUYINFO                                         */
/*==============================================================*/
create table TOP_BUYINFO
(
  serialno         VARCHAR2(32) not null,
  channelflag      VARCHAR2(2),
  channelno        VARCHAR2(32),
  inscorpcode      VARCHAR2(10) not null,
  templateid       VARCHAR2(20),
  areaid           VARCHAR2(20),
  prepolicyid      VARCHAR2(60),
  policyid         VARCHAR2(60),
  oldpolicyid      VARCHAR2(200),
  contractid       VARCHAR2(60),
  orgnserialno     VARCHAR2(32),
  firstpremium     NUMBER(16,2),
  firstpremiumcn   VARCHAR2(60),
  effdate          VARCHAR2(8),
  revdate          VARCHAR2(8),
  innercommission  NUMBER(16,2),
  outercommission  NUMBER(16,2),
  lcoperatorcode   VARCHAR2(20),
  lcoperatorid     VARCHAR2(20),
  lcoperatorname   VARCHAR2(100),
  tzoperatorcode   VARCHAR2(20),
  tzoperatorid     VARCHAR2(20),
  tzoperatorname   VARCHAR2(100),
  inscorpstatus    VARCHAR2(1),
  corestatus       VARCHAR2(1),
  recordstatus     VARCHAR2(1),
  serialtype       VARCHAR2(1),
  deliver          VARCHAR2(1),
  operatorbankcode VARCHAR2(20), 
  operatorcode     VARCHAR2(20), 
  updatedate       VARCHAR2(20), 
  updatetime       VARCHAR2(20),
  remark1          VARCHAR2(60),
  remark2          VARCHAR2(60),
  remark3          VARCHAR2(60),
  remark4          VARCHAR2(60),
  remark5          VARCHAR2(60),
  remark6          VARCHAR2(60),
  remark7          VARCHAR2(60),
  remark8          VARCHAR2(60),
  remark9          VARCHAR2(60),
  remark10         VARCHAR2(60),
   constraint PK_TOP_BUYINFO primary key (serialno)
);

comment on table TOP_BUYINFO is
'新保承保表';

comment on column TOP_BUYINFO.serialNo is
'交易流水号';
comment on column TOP_BUYINFO.channelFlag is
'渠道标志(01: 柜面   02: 网银   03: 手机  04: 直销  05:自助)';
comment on column TOP_BUYINFO.channelNo is
'渠道流水号';
comment on column TOP_BUYINFO.insCorpCode is
'保险公司代码';
comment on column TOP_BUYINFO.templateID is
'产品库ID';
comment on column TOP_BUYINFO.areaId is
'地区代码';
comment on column TOP_BUYINFO.prePolicyId is
'投保单号';
comment on column TOP_BUYINFO.policyId  is
'保单印刷号';
comment on column TOP_BUYINFO.oldPolicyId is
'旧保单印刷号';
comment on column TOP_BUYINFO.contractId is
'保单合同号码';
comment on column TOP_BUYINFO.orgnSerialNo is
'原交易流水号';
comment on column TOP_BUYINFO.firstPremium is
'首期保费';
comment on column TOP_BUYINFO.firstPremiumCN is
'首期保费大写';
comment on column TOP_BUYINFO.effDate  is
'保单生效日期';
comment on column TOP_BUYINFO.revDate is
'保单到期日期';
comment on column TOP_BUYINFO.innerCommission is
'内扣手续费';
comment on column TOP_BUYINFO.outerCommission is
'外扣手续费';
comment on column TOP_BUYINFO.lcOperatorCode is
'销售人员网点号';
comment on column TOP_BUYINFO.lcOperatorId  is
'销售人员ID';
comment on column TOP_BUYINFO.lcOperatorName is
'销售人员姓名';
comment on column TOP_BUYINFO.tzOperatorCode is
'拓展人员网点号';
comment on column TOP_BUYINFO.tzOperatorId is
'拓展人员ID';
comment on column TOP_BUYINFO.tzOperatorName is
'拓展人员姓名';
comment on column TOP_BUYINFO.insCorpStatus is
'保险公司状态(1: 待核保   2: 核保成功   3: 核保失败   4: 冲正成功   5: 冲正失败)';
comment on column TOP_BUYINFO.coreStatus is
'核心状态(1: 未扣款   2: 扣款成功   3: 扣款失败   4: 冲正成功   5: 冲正失败   6: 撤单未还款)';
comment on column TOP_BUYINFO.recordStatus is
'保单打印状态(1: 已打印   2: 未打印)';
comment on column TOP_BUYINFO.serialType  is
'保单状态(1: 正常   2: 失效   3: 终止)';
comment on column TOP_BUYINFO.deliver is
'保单传递方式(1: 银行柜台   2: 邮件发送   3: 上门递送   4: 邮寄)';
comment on column TOP_BUYINFO.operatorBankCode  is
'操作机构';
comment on column TOP_BUYINFO.operatorCode is
'操作人员';
comment on column TOP_BUYINFO.updateDate is
'操作日期';
comment on column TOP_BUYINFO.updateTime is
'操作时间';
comment on column TOP_BUYINFO.remark1 is
'备注字段一';
comment on column TOP_BUYINFO.remark2 is
'备注字段二';
comment on column TOP_BUYINFO.remark3 is
'备注字段三';
comment on column TOP_BUYINFO.remark4 is
'备注字段四';
comment on column TOP_BUYINFO.remark5 is
'备注字段五';
comment on column TOP_BUYINFO.remark6 is
'备注字段六';
comment on column TOP_BUYINFO.remark7  is
'备注字段七';
comment on column TOP_BUYINFO.remark8  is
'备注字段八';
comment on column TOP_BUYINFO.remark9  is
'备注字段九';
comment on column TOP_BUYINFO.remark10  is
'备注字段十';

/*==============================================================*/
/* Table: TOP_BUYINFOADD                                         */
/*==============================================================*/
create table TOP_BUYINFOADD
(
  addserialno      VARCHAR2(32) not null,
  serialno         VARCHAR2(32) not null,
  insprdcode       VARCHAR2(8) not null,
  mainflag         CHAR(1),
  PAY_TYPE         VARCHAR2(1),
  PAY_PERIOD       VARCHAR2(3),
  PAY_PERIOD_TYPE  VARCHAR2(1),
  INS_PERIOD       VARCHAR2(3),
  INS_PERIOD_TYPE  VARCHAR2(1),
  intialnumber     NUMBER(16),
  basepremiumamt   NUMBER(16,2),
  baseensureamt    NUMBER(16,2),
  innercommission  NUMBER(16,2),
  outercommission  NUMBER(16,2),
  adrawtype        VARCHAR2(1),
  adrawstartage    VARCHAR2(3),
  adrawstopage     VARCHAR2(3),
  adrawpart        VARCHAR2(3),
  bonusdrawtype    VARCHAR2(10),
  operatorbankcode VARCHAR2(20) not null,
  operatorcode     VARCHAR2(20) not null,
  updatedate       VARCHAR2(8) not null,
  updatetime       VARCHAR2(8) not null,
  remark1          VARCHAR2(60),
  remark2          VARCHAR2(60),
  remark3          VARCHAR2(60),
  remark4          VARCHAR2(60),
  remark5          VARCHAR2(60),
  remark6          VARCHAR2(60),
  remark7          VARCHAR2(60),
  remark8          VARCHAR2(60),
  remark9          VARCHAR2(60),
  remark10         VARCHAR2(60),
  constraint PK_TOP_BUYINFOADD primary key (addserialno)
);

comment on table TOP_BUYINFOADD is
'新保承保产品表';

comment on column TOP_BUYINFOADD.addSerialNo is
'序列号';
comment on column TOP_BUYINFOADD.serialNo is
'交易流水号(新保承保交易流水号)';
comment on column TOP_BUYINFOADD.insPrdCode is
'交易产品代码';
comment on column TOP_BUYINFOADD.mainFlag is
'主附险标志(0: 主险   1: 附加险)';
comment on column TOP_BUYINFOADD.PAY_TYPE is
'缴费类型(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';
comment on column TOP_BUYINFOADD.PAY_PERIOD  is
'缴费年期';
comment on column TOP_BUYINFOADD.PAY_PERIOD_TYPE is
'缴费年期单位(0: 年  1: 周岁  2: 终身)';
comment on column TOP_BUYINFOADD.INS_PERIOD is
'保障年期';
comment on column TOP_BUYINFOADD.INS_PERIOD_TYPE is
'保障年期单位(0: 年  1: 周岁  2: 保终身)';
comment on column TOP_BUYINFOADD.intialNumber is
'投保份数/档次';
comment on column TOP_BUYINFOADD.basePremiumAmt  is
'基本保费';
comment on column TOP_BUYINFOADD.baseEnsureAmt  is
'保险保额';
comment on column TOP_BUYINFOADD.innerCommission  is
'内扣手续费';
comment on column TOP_BUYINFOADD.outerCommission is
'外扣手续费';
comment on column TOP_BUYINFOADD.aDrawType is
'年金领取方式';
comment on column TOP_BUYINFOADD.aDrawStartAge  is
'年金领取开始年龄';
comment on column TOP_BUYINFOADD.aDrawStopAge is
'年金领取结束年龄';
comment on column TOP_BUYINFOADD.aDrawPart  is
'年金保证领取区间';
comment on column TOP_BUYINFOADD.bonusDrawType is
'红利领取方式(1：月领  2：年领  3：趸领)';
comment on column TOP_BUYINFOADD.operatorBankCode is
'操作机构';
comment on column TOP_BUYINFOADD.operatorCode  is
'操作人员';
comment on column TOP_BUYINFOADD.updateDate  is
'操作日期';
comment on column TOP_BUYINFOADD.updateTime is
'操作时间';
comment on column TOP_BUYINFOADD.remark1  is
'备注字段一';
comment on column TOP_BUYINFOADD.remark2 is
'备注字段二';
comment on column TOP_BUYINFOADD.remark3  is
'备注字段三';
comment on column TOP_BUYINFOADD.remark4  is
'备注字段四';
comment on column TOP_BUYINFOADD.remark5 is
'备注字段五';
comment on column TOP_BUYINFOADD.remark6  is
'备注字段六';
comment on column TOP_BUYINFOADD.remark7  is
'备注字段七';
comment on column TOP_BUYINFOADD.remark8 is
'备注字段八';
comment on column TOP_BUYINFOADD.remark9  is
'备注字段九';
comment on column TOP_BUYINFOADD.remark10 is
'备注字段十';

/*==============================================================*/
/* Table: TOP_BUYINFOADD                                         */
/*==============================================================*/
create table TOP_PHINFO
(
  phserialno       VARCHAR2(32) not null,
  serialno         VARCHAR2(32) not null,
  phname           VARCHAR2(60) not null,
  phacctype        VARCHAR2(1),
  phaccno          VARCHAR2(60),
  phcustno         VARCHAR2(20),
  phsex            VARCHAR2(1),
  phbirthday       VARCHAR2(8),
  phcfctype        VARCHAR2(2),
  phcfcno          VARCHAR2(60),
  phexpirydate     VARCHAR2(8),
  phaddress        VARCHAR2(60),
  phpostcode       VARCHAR2(10),
  phcontactphone   VARCHAR2(20),
  phfphone         VARCHAR2(20),
  phcphone         VARCHAR2(20),
  phmphone         VARCHAR2(20),
  phemail          VARCHAR2(60),
  phteincome       NUMBER(16,2),
  phnality         VARCHAR2(10),
  phhholder        VARCHAR2(60),
  phcompany        VARCHAR2(60),
  phjobtype        VARCHAR2(30),
  phjob            VARCHAR2(30),
  pheducation      VARCHAR2(1),
  phmarried        VARCHAR2(1),
  phrisklevel      VARCHAR2(1), 
  operatorbankcode VARCHAR2(20),
  operatorcode     VARCHAR2(20),
  updatedate       VARCHAR2(8) ,
  updatetime       VARCHAR2(8) ,
  remark1          VARCHAR2(60),
  remark2          VARCHAR2(60),
  remark3          VARCHAR2(60),
  remark4          VARCHAR2(60),
  remark5          VARCHAR2(60),
  remark6          VARCHAR2(60),
  remark7          VARCHAR2(60),
  remark8          VARCHAR2(60),
  remark9          VARCHAR2(60),
  remark10         VARCHAR2(60),
  constraint PK_TOP_PHINFO primary key (phserialno)
);

comment on table TOP_PHINFO is
'投保人信息表';

comment on column TOP_PHINFO.phserialno is
'序列号';
comment on column TOP_PHINFO.serialNo is
'交易流水号(新保承保交易流水号)';
comment on column TOP_PHINFO.phName is
'投保人姓名';
comment on column TOP_PHINFO.phAccType is
'投保人账户类型(0: 卡  1：折)';
comment on column TOP_PHINFO.phAccNo is
'序列号';
comment on column TOP_PHINFO.phCustNo is
'核心客户号';
comment on column TOP_PHINFO.phSex is
'投保人性别(0: 男性  1: 女性)';
comment on column TOP_PHINFO.phBirthDay is
'投保人出生日期';
comment on column TOP_PHINFO.phcfcType is
'投保人证件类型(1身份证 2户口本 3军官证 4警官证 5护照 6港澳通行证 7法人组织机构代码证
8非法人组织机构代码证 9文职干部证 10士兵证 11台湾通行证 12其他)';
comment on column TOP_PHINFO.phcfcNo is
'投保人证件号码';
comment on column TOP_PHINFO.phExpiryDate is
'证件有效期';
comment on column TOP_PHINFO.phAddress  is
'投保人通讯地址';
comment on column TOP_PHINFO.phPostCode is
'投保人邮编';
comment on column TOP_PHINFO.phContactphone is
'联系电话';
comment on column TOP_PHINFO.phFphone is
'家庭电话';
comment on column TOP_PHINFO.phCphone is
'公司电话';
comment on column TOP_PHINFO.phMphone is
'投保人手机号码';
comment on column TOP_PHINFO.phEmail is
'投保人电子邮件';
comment on column TOP_PHINFO.phteIncome is
'投保人过去三年的平均收入(年收入)';
comment on column TOP_PHINFO.phNality is
'国籍';
comment on column TOP_PHINFO.phHholder is
'户籍';
comment on column TOP_PHINFO.phCompany  is
'工作单位';
comment on column TOP_PHINFO.phJobType  is
'投保险人职业类别';
comment on column TOP_PHINFO.phJob is
'投保险人职业';
comment on column TOP_PHINFO.phEducation  is
'学历(1博士研究生 2硕士研究生 3大学本科 4大学专科 5普通高中 6中职（中专、职专、技校）7初中 8初中以下)';
comment on column TOP_PHINFO.phMarried is
'婚姻状况(1: 已婚  2: 未婚 3: 离异  4: 丧偶)';
comment on column TOP_PHINFO.phRiskLevel is
'风险评估等级(0: 进取型  1: 成长型  2: 平衡型  3: 稳健型  4: 保守型)';
comment on column TOP_PHINFO.operatorBankCode is
'操作机构';
comment on column TOP_PHINFO.operatorCode  is
'操作人员';
comment on column TOP_PHINFO.updateDate is
'操作日期';
comment on column TOP_PHINFO.updateTime is
'操作时间';
comment on column TOP_PHINFO.remark1  is
'备注字段一';
comment on column TOP_PHINFO.remark2 is
'备注字段二';
comment on column TOP_PHINFO.remark3  is
'备注字段三';
comment on column TOP_PHINFO.remark4  is
'备注字段四';
comment on column TOP_PHINFO.remark5 is
'备注字段五';
comment on column TOP_PHINFO.remark6  is
'备注字段六';
comment on column TOP_PHINFO.remark7  is
'备注字段七';
comment on column TOP_PHINFO.remark8 is
'备注字段八';
comment on column TOP_PHINFO.remark9  is
'备注字段九';
comment on column TOP_PHINFO.remark10 is
'备注字段十';

/*==============================================================*/
/* Table: TOP_RNINFO                                         */
/*==============================================================*/
create table TOP_RNINFO
(
  rnserialno       VARCHAR2(32) not null,
  serialno         VARCHAR2(32) not null,
  prrelation       VARCHAR2(1) not null,
  rnname           VARCHAR2(60),
  rnsex            VARCHAR2(1) ,
  rnbirthday       VARCHAR2(8) ,
  rncfctype        VARCHAR2(2) ,
  rncfcno          VARCHAR2(60),
  rnexpirydate     VARCHAR2(8) ,
  rnaddress        VARCHAR2(60),
  rnpostcode       VARCHAR2(10),
  rncontactphone   VARCHAR2(20),
  rnfphone         VARCHAR2(20),
  rncphone         VARCHAR2(20),
  rnmphone         VARCHAR2(20),
  rnemail          VARCHAR2(30),
  rnteincome       NUMBER(16,2),
  rnnality         VARCHAR2(60),
  rnhholder        VARCHAR2(60),
  rncompany        VARCHAR2(60),
  rnjobtype        VARCHAR2(30),
  rnjob            VARCHAR2(30),
  rneducation      VARCHAR2(1) ,
  rnmarried        VARCHAR2(1) ,
  operatorbankcode VARCHAR2(20),
  operatorcode     VARCHAR2(20),
  updatedate       VARCHAR2(8) ,
  updatetime       VARCHAR2(8) ,
  remark1          VARCHAR2(60),
  remark2          VARCHAR2(60),
  remark3          VARCHAR2(60),
  remark4          VARCHAR2(60),
  remark5          VARCHAR2(60),
  remark6          VARCHAR2(60),
  remark7          VARCHAR2(60),
  remark8          VARCHAR2(60),
  remark9          VARCHAR2(60),
  remark10         VARCHAR2(60),
  constraint PK_TOP_RNINFO primary key (rnserialno)
);

comment on table TOP_RNINFO is
'被保人信息表';

comment on column TOP_RNINFO.rnSerialNo is
'序列号';
comment on column TOP_RNINFO.serialNo is
'交易流水号(新保承保交易流水号)';
comment on column TOP_RNINFO.prRelation is
'投保人与被保险人关系(1本人 2配偶 3父子 4父女 5母子 6母女 7兄弟 8姊妹 9兄妹 10姐弟 11雇佣 12法定 13其他)';
comment on column TOP_RNINFO.rnName is
'被保人姓名';
comment on column TOP_RNINFO.rnSex  is
'被保人性别(0: 男性  1: 女性)';
comment on column TOP_RNINFO.rnBirthDay is
'被保人出生日期';
comment on column TOP_RNINFO.rncfcType  is
'被保人证件类型(1身份证 2户口本 3军官证 4警官证 5护照 6港澳通行证 7法人组织机构代码证
8非法人组织机构代码证 9文职干部证 10士兵证 11台湾通行证 12其他)';
comment on column TOP_RNINFO.rncfcNo is
'被保人证件号码';
comment on column TOP_RNINFO.rnExpiryDate is
'证件有效期';
comment on column TOP_RNINFO.rnAddress  is
'被保人通讯地址';
comment on column TOP_RNINFO.rnPostCode is
'被保人邮编';
comment on column TOP_RNINFO.rnContactphone is
'联系电话';
comment on column TOP_RNINFO.rnFphone is
'家庭电话';
comment on column TOP_RNINFO.rnCphone  is
'公司电话';
comment on column TOP_RNINFO.rnmPhone is
'被保人手机号码';
comment on column TOP_RNINFO.rnEmail  is
'被保人电子邮件';
comment on column TOP_RNINFO.rnteIncome  is
'投保人过去三年的平均收入(年收入)';
comment on column TOP_RNINFO.rnNality  is
'国籍';
comment on column TOP_RNINFO.rnHholder is
'户籍';
comment on column TOP_RNINFO.rnCompany   is
'工作单位';
comment on column TOP_RNINFO.rnJobType  is
'被保险人职业类别';
comment on column TOP_RNINFO.rnJob   is
'被保险人职业';
comment on column TOP_RNINFO.rnEducation  is
'学历(1博士研究生 2硕士研究生 3大学本科 4大学专科 5普通高中 6中职（中专、职专、技校）7初中 8初中以下)';
comment on column TOP_RNINFO.rnMarried  is
'婚姻状况(1: 已婚  2: 未婚 3: 离异  4: 丧偶)';
comment on column TOP_RNINFO.operatorBankCode is
'操作机构';
comment on column TOP_RNINFO.operatorCode  is
'操作人员';
comment on column TOP_RNINFO.updateDate is
'操作日期';
comment on column TOP_RNINFO.updateTime is
'操作时间';
comment on column TOP_RNINFO.remark1  is
'备注字段一';
comment on column TOP_RNINFO.remark2 is
'备注字段二';
comment on column TOP_RNINFO.remark3  is
'备注字段三';
comment on column TOP_RNINFO.remark4  is
'备注字段四';
comment on column TOP_RNINFO.remark5 is
'备注字段五';
comment on column TOP_RNINFO.remark6  is
'备注字段六';
comment on column TOP_RNINFO.remark7  is
'备注字段七';
comment on column TOP_RNINFO.remark8 is
'备注字段八';
comment on column TOP_RNINFO.remark9  is
'备注字段九';
comment on column TOP_RNINFO.remark10 is
'备注字段十';

/*==============================================================*/
/* Table: TOP_BFYINFO                                         */
/*==============================================================*/
create table TOP_BFYINFO
(
  bfyserialno      VARCHAR2(32) not null,
  serialno         VARCHAR2(32) not null,
  brrelation       VARCHAR2(2) not null,
  bfyname          VARCHAR2(60),
  bfysex           VARCHAR2(1),
  bfybirthday      VARCHAR2(8),
  bfycfctype       VARCHAR2(2),
  bfycfcno         VARCHAR2(60),
  bfyexpirydate    VARCHAR2(8),
  bfyaddress       VARCHAR2(60),
  bfynumerator     NUMBER(3),
  bfyorder         NUMBER(4),
  bfymethod        VARCHAR2(1),
  bfytype          VARCHAR2(1),
  operatorbankcode VARCHAR2(20),
  operatorcode     VARCHAR2(20),
  updatedate       VARCHAR2(8) ,
  updatetime       VARCHAR2(8) ,
  remark1          VARCHAR2(60),
  remark2          VARCHAR2(60),
  remark3          VARCHAR2(60),
  remark4          VARCHAR2(60),
  remark5          VARCHAR2(60),
  remark6          VARCHAR2(60),
  remark7          VARCHAR2(60),
  remark8          VARCHAR2(60),
  remark9          VARCHAR2(60),
  remark10         VARCHAR2(60),
  constraint PK_TOP_BFYINFO primary key (bfyserialno)
);
comment on table TOP_BFYINFO is
'受益人信息表';

comment on column TOP_BFYINFO.bfyserialno  is
'序列号';
comment on column TOP_BFYINFO.serialNo is
'交易流水号(新保承保交易流水号)';
comment on column TOP_BFYINFO.rnRelation  is
'与被保险人关系(1本人 2配偶 3父子 4父女 5母子 6母女 7兄弟 8姊妹 9兄妹 10姐弟 11雇佣 12法定 13其他)';
comment on column TOP_BFYINFO.bfyName  is
'姓名';
comment on column TOP_BFYINFO.bfySex is
'性别(0: 男性  1: 女性)';
comment on column TOP_BFYINFO.bfyBirth  is
'出生日期';
comment on column TOP_BFYINFO.bfyCfcType  is
'被保人证件类型(1身份证 2户口本 3军官证 4警官证 5护照 6港澳通行证 7法人组织机构代码证
8非法人组织机构代码证 9文职干部证 10士兵证 11台湾通行证 12其他)';
comment on column TOP_BFYINFO.bfyCfcNo is
'证件号码';
comment on column TOP_BFYINFO.expiryDate  is
'证件有效期';
comment on column TOP_BFYINFO.bfyAddress is
'通讯地址';
comment on column TOP_BFYINFO.bfybm is
'受益分子(一份投保单的收益分子之和为100)';
comment on column TOP_BFYINFO.bfyOrder is
'受益顺序';
comment on column TOP_BFYINFO.bfyType is
'受益人类型(1: 身故受益人  2: 生存受益人)';
comment on column TOP_BFYINFO.bfyMethod is
'分配方式(1 顺位 ；2均分；3比例；4法定；5本人 6其他)';
comment on column TOP_BFYINFO.operatorBankCode is
'操作机构';
comment on column TOP_BFYINFO.operatorCode  is
'操作人员';
comment on column TOP_BFYINFO.updateDate is
'操作日期';
comment on column TOP_BFYINFO.updateTime is
'操作时间';
comment on column TOP_BFYINFO.remark1  is
'备注字段一';
comment on column TOP_BFYINFO.remark2 is
'备注字段二';
comment on column TOP_BFYINFO.remark3  is
'备注字段三';
comment on column TOP_BFYINFO.remark4  is
'备注字段四';
comment on column TOP_BFYINFO.remark5 is
'备注字段五';
comment on column TOP_BFYINFO.remark6  is
'备注字段六';
comment on column TOP_BFYINFO.remark7  is
'备注字段七';
comment on column TOP_BFYINFO.remark8 is
'备注字段八';
comment on column TOP_BFYINFO.remark9  is
'备注字段九';
comment on column TOP_BFYINFO.remark10 is
'备注字段十';

/*==============================================================*/
/* Table: TOP_SPECIALINFO                                         */
/*==============================================================*/
create table TOP_SPECIALINFO
(
  spserialno       VARCHAR2(32) not null,
  serialno         VARCHAR2(32) not null,
  ishealth         VARCHAR2(1),
  iswhealth        VARCHAR2(1),
  isphealth        VARCHAR2(1),
  isjob            VARCHAR2(1),
  ispjob           VARCHAR2(1),
  amount           NUMBER(16,2),
  specialinfo      VARCHAR2(100),
  investtype       VARCHAR2(1),
  addinvesttype    VARCHAR2(1),
  yljflag          VARCHAR2(1),
  isexistence      VARCHAR2(1),
  isnextfee        VARCHAR2(1),
  hlflag           VARCHAR2(1),
  isrenewal        VARCHAR2(1),
  njflag           VARCHAR2(1),
  moneyaccountname VARCHAR2(20),
  moneyaccount     VARCHAR2(20),
  moneybank        VARCHAR2(60),
  disputetype      VARCHAR2(1),
  moneyform        VARCHAR2(1),
  operatorbankcode VARCHAR2(20),
  operatorcode     VARCHAR2(20),
  updatedate       VARCHAR2(8),
  updatetime       VARCHAR2(8),
  remark1          VARCHAR2(60),
  remark2          VARCHAR2(60),
  remark3          VARCHAR2(60),
  remark4          VARCHAR2(60),
  remark5          VARCHAR2(60),
  remark6          VARCHAR2(60),
  remark7          VARCHAR2(60),
  remark8          VARCHAR2(60),
  remark9          VARCHAR2(60),
  remark10         VARCHAR2(60),
  constraint PK_TOP_SPECIALINFO primary key (spserialno)
);

comment on table TOP_SPECIALINFO is
'受益人信息表';

comment on column TOP_SPECIALINFO.spserialno  is
'序列号';
comment on column TOP_SPECIALINFO.serialNo is
'交易流水号(新保承保交易流水号)';
comment on column TOP_SPECIALINFO.ishealth is
'健康告知(Y-是 N-否)';
comment on column TOP_SPECIALINFO.iswhealth is
'客户是否填写健康告知(Y-是 N-否)';
comment on column TOP_SPECIALINFO.isphealth is
'客户健康告知是否有问题(Y-是 N-否)';
comment on column TOP_SPECIALINFO.isjob  is
'职业告知(Y-是 N-否)';
comment on column TOP_SPECIALINFO.ispjob is
'客户职业告知是否有问题(Y-是 N-否)';
comment on column TOP_SPECIALINFO.amount is
'未成年人在其它保险公司投保死亡保额';
comment on column TOP_SPECIALINFO.specialinfo is
'特别约定';
comment on column TOP_SPECIALINFO.investtype is
'投资方式(Y-立投 N-非立投)';
comment on column TOP_SPECIALINFO.addinvesttype is
'追加投资方式(Y-立投 N-非立投)';
comment on column TOP_SPECIALINFO.yljflag  is
'养老金领取方式(M-月领 Q-季领 S-半年领 Y-年领 D-趸领 )';
comment on column TOP_SPECIALINFO.isexistence  is
'生存金是否累计生息(Y-累计生息 N-不累计生息)';
comment on column TOP_SPECIALINFO.isnextfee  is
'续期保费是否自动垫交(1 同意垫交2 保险合同中止)';
comment on column TOP_SPECIALINFO.hlflag  is
'红利领取方式(1- 现金给付2- 抵交保费3- 累积生息4- 直接领取)';
comment on column TOP_SPECIALINFO.isrenewal  is
'一年期主险/一年期附加险是否自动申请续保(Y-是  N-否)';
comment on column TOP_SPECIALINFO.njflag  is
'年金领取方式(1- 现金给付2- 抵交保费3- 累积生息4- 直接领取)';
comment on column TOP_SPECIALINFO.moneyaccountname  is
'领款账户户名';
comment on column TOP_SPECIALINFO.moneyaccount   is
'领款账户领款账号';
comment on column TOP_SPECIALINFO.moneybank  is
'领款账户开户银行';
comment on column TOP_SPECIALINFO.disputetype  is
'合同争议处理方式(1-诉讼  2-仲裁)';
comment on column TOP_SPECIALINFO.moneyform  is
'领款形式(1-现金 2-银行转账)';
comment on column TOP_SPECIALINFO.disputetype  is
'合同争议处理方式(1-诉讼  2-仲裁)';
comment on column TOP_SPECIALINFO.disputetype  is
'合同争议处理方式(1-诉讼  2-仲裁)';
comment on column TOP_SPECIALINFO.disputetype  is
'合同争议处理方式(1-诉讼  2-仲裁)';
comment on column TOP_SPECIALINFO.disputetype  is
'合同争议处理方式(1-诉讼  2-仲裁)';
comment on column TOP_SPECIALINFO.operatorBankCode is
'操作机构';
comment on column TOP_SPECIALINFO.operatorCode  is
'操作人员';
comment on column TOP_SPECIALINFO.updateDate is
'操作日期';
comment on column TOP_SPECIALINFO.updateTime is
'操作时间';
comment on column TOP_SPECIALINFO.remark1  is
'备注字段一';
comment on column TOP_SPECIALINFO.remark2 is
'备注字段二';
comment on column TOP_SPECIALINFO.remark3  is
'备注字段三';
comment on column TOP_SPECIALINFO.remark4  is
'备注字段四';
comment on column TOP_SPECIALINFO.remark5 is
'备注字段五';
comment on column TOP_SPECIALINFO.remark6  is
'备注字段六';
comment on column TOP_SPECIALINFO.remark7  is
'备注字段七';
comment on column TOP_SPECIALINFO.remark8 is
'备注字段八';
comment on column TOP_SPECIALINFO.remark9  is
'备注字段九';
comment on column TOP_SPECIALINFO.remark10 is
'备注字段十';
