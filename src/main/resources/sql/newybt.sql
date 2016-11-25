prompt PL/SQL Developer import file
prompt Created on 2016年11月25日 by liuc5
set feedback off
set define off
prompt Creating TOP_AGENTRATE...
create table TOP_AGENTRATE
(
  ID              VARCHAR2(40) not null,
  INSPRD_CODE     VARCHAR2(40) not null,
  ADMIN_BANK      VARCHAR2(30),
  TRANS_TYPE      VARCHAR2(10),
  PAY_TYPE        VARCHAR2(10),
  PAY_PERIOD      VARCHAR2(10),
  PAY_PERIOD_TYPE VARCHAR2(10),
  RATE_TYPE       VARCHAR2(2),
  ONCE_AMT        VARCHAR2(30),
  PERCENT_AMT     VARCHAR2(10),
  INS_PERIOD      VARCHAR2(10),
  INS_PERIOD_TYPE VARCHAR2(10),
  OPERATOR        VARCHAR2(30),
  OPERATOR_BANK   VARCHAR2(30),
  UPDATE_DATE     VARCHAR2(10),
  UPDATE_TIME     VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_AGENTRATE
  is '代理费率表';
comment on column TOP_AGENTRATE.ID
  is 'ID';
comment on column TOP_AGENTRATE.INSPRD_CODE
  is '产品编码';
comment on column TOP_AGENTRATE.ADMIN_BANK
  is '机构';
comment on column TOP_AGENTRATE.TRANS_TYPE
  is '交易类型(1:实时 2:非实时)';
comment on column TOP_AGENTRATE.PAY_TYPE
  is '缴费类型(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';
comment on column TOP_AGENTRATE.PAY_PERIOD
  is '缴费年期';
comment on column TOP_AGENTRATE.PAY_PERIOD_TYPE
  is '缴费年期单位(0:年1:周岁 2:终身)';
comment on column TOP_AGENTRATE.RATE_TYPE
  is '收费方式(1:一次性2:百分比)';
comment on column TOP_AGENTRATE.ONCE_AMT
  is '一次性金额';
comment on column TOP_AGENTRATE.PERCENT_AMT
  is '百分比';
comment on column TOP_AGENTRATE.INS_PERIOD
  is '保障年期';
comment on column TOP_AGENTRATE.INS_PERIOD_TYPE
  is '保障年期单位(0:年1:周岁2:保终身)';
comment on column TOP_AGENTRATE.OPERATOR
  is '柜员号';
comment on column TOP_AGENTRATE.OPERATOR_BANK
  is '机构';
comment on column TOP_AGENTRATE.UPDATE_DATE
  is '更新日期';
comment on column TOP_AGENTRATE.UPDATE_TIME
  is '更新时间';
alter table TOP_AGENTRATE
  add constraint PK_TOP_AGENTRATE primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_BANKANDCORP...
create table TOP_BANKANDCORP
(
  BANKCODE         VARCHAR2(20) not null,
  BANKCHNAME       VARCHAR2(60) not null,
  CORPCODE         VARCHAR2(20),
  CORPCODE2        VARCHAR2(20),
  CORPCODE3        VARCHAR2(20),
  FILENAME         VARCHAR2(60),
  OPERATORBANKCODE VARCHAR2(20),
  OPERATORCODE     VARCHAR2(20),
  OPERDATE         VARCHAR2(8),
  OPERTIME         VARCHAR2(6),
  REVIEWBANKCODE   VARCHAR2(20),
  REVIEWCODE       VARCHAR2(20),
  UPDATEDATE       VARCHAR2(8),
  UPDATETIME       VARCHAR2(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_BANKANDCORP
  is '机构绑定保险公司表';
comment on column TOP_BANKANDCORP.BANKCODE
  is '机构号';
comment on column TOP_BANKANDCORP.BANKCHNAME
  is '机构名称';
comment on column TOP_BANKANDCORP.CORPCODE
  is '保险公司1';
comment on column TOP_BANKANDCORP.CORPCODE2
  is '保险公司2';
comment on column TOP_BANKANDCORP.CORPCODE3
  is '保险公司3';
comment on column TOP_BANKANDCORP.FILENAME
  is '导入文件名';
comment on column TOP_BANKANDCORP.OPERATORBANKCODE
  is '操作机构号';
comment on column TOP_BANKANDCORP.OPERATORCODE
  is '操作员工号';
comment on column TOP_BANKANDCORP.OPERDATE
  is '操作日期';
comment on column TOP_BANKANDCORP.OPERTIME
  is '操作时间';
comment on column TOP_BANKANDCORP.REVIEWBANKCODE
  is '复核机构号';
comment on column TOP_BANKANDCORP.REVIEWCODE
  is '复核员工号';
comment on column TOP_BANKANDCORP.UPDATEDATE
  is '更新日期';
comment on column TOP_BANKANDCORP.UPDATETIME
  is '更新时间';
alter table TOP_BANKANDCORP
  add constraint PK_TOP_BANKANDCORP primary key (BANKCODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_BANKINFO...
create table TOP_BANKINFO
(
  BANK_ID         VARCHAR2(40) not null,
  BANK_CODE       VARCHAR2(40) not null,
  BANK_NAME       VARCHAR2(60) not null,
  BANK_LEVEL      VARCHAR2(2) not null,
  UP_BANK_CODE    VARCHAR2(40),
  ADDRESS         VARCHAR2(60),
  POSTCODE        VARCHAR2(40),
  PHONE           VARCHAR2(40),
  FAX             VARCHAR2(40),
  STATUS          VARCHAR2(2),
  CREATE_DATE     VARCHAR2(8),
  UPDATE_DATE     VARCHAR2(8),
  UPDATE_TIME     VARCHAR2(6),
  CERT_NO         VARCHAR2(40),
  CERT_START_DATE VARCHAR2(8),
  CERT_END_DATE   VARCHAR2(8),
  REMARK1         VARCHAR2(60),
  REMARK2         VARCHAR2(60),
  REMARK3         VARCHAR2(60),
  REMARK4         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_BANKINFO
  is '机构表';
comment on column TOP_BANKINFO.BANK_ID
  is '机构ID';
comment on column TOP_BANKINFO.BANK_CODE
  is '机构编号';
comment on column TOP_BANKINFO.BANK_NAME
  is '机构名称';
comment on column TOP_BANKINFO.BANK_LEVEL
  is '机构级别(0:总行 1:分行 2:支行 3:网点 )';
comment on column TOP_BANKINFO.UP_BANK_CODE
  is '上级机构编号';
comment on column TOP_BANKINFO.ADDRESS
  is '机构地址';
comment on column TOP_BANKINFO.POSTCODE
  is '邮编';
comment on column TOP_BANKINFO.PHONE
  is '电话';
comment on column TOP_BANKINFO.FAX
  is '传真';
comment on column TOP_BANKINFO.STATUS
  is '状态(0:有效 1:无效)';
comment on column TOP_BANKINFO.CREATE_DATE
  is '创建日期';
comment on column TOP_BANKINFO.UPDATE_DATE
  is '更新日期';
comment on column TOP_BANKINFO.UPDATE_TIME
  is '更新时间';
comment on column TOP_BANKINFO.CERT_NO
  is '机构代理编号';
comment on column TOP_BANKINFO.CERT_START_DATE
  is '代理开始日期';
comment on column TOP_BANKINFO.CERT_END_DATE
  is '代理结束日期';
comment on column TOP_BANKINFO.REMARK1
  is '备用字段1';
comment on column TOP_BANKINFO.REMARK2
  is '备用字段2';
comment on column TOP_BANKINFO.REMARK3
  is '备用字段3';
comment on column TOP_BANKINFO.REMARK4
  is '备用字段4';
alter table TOP_BANKINFO
  add constraint PK_TOP_BANKINFO primary key (BANK_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_BANKINS...
create table TOP_BANKINS
(
  ID           VARCHAR2(40) not null,
  INSCORP_CODE VARCHAR2(30) not null,
  INSPRD_CODE  VARCHAR2(30) not null,
  BANK_CODE    VARCHAR2(20) not null,
  ORG_CODE     VARCHAR2(20) not null,
  CHANNEL      VARCHAR2(4) not null,
  OPERATOR     VARCHAR2(30) not null,
  UPDATE_DATE  VARCHAR2(10) not null,
  UPDATE_TIME  VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table TOP_BANKINS
  is '产品与机构签约表';
comment on column TOP_BANKINS.ID
  is 'ID';
comment on column TOP_BANKINS.INSCORP_CODE
  is '公司编码';
comment on column TOP_BANKINS.INSPRD_CODE
  is '产品编码';
comment on column TOP_BANKINS.BANK_CODE
  is '机构号';
comment on column TOP_BANKINS.ORG_CODE
  is '上级机构号';
comment on column TOP_BANKINS.CHANNEL
  is '渠道(01:柜面02:网银03:手机04:直销05:自助)';
comment on column TOP_BANKINS.OPERATOR
  is '操作柜员';
comment on column TOP_BANKINS.UPDATE_DATE
  is '更新日期';
comment on column TOP_BANKINS.UPDATE_TIME
  is '更新时间';
alter table TOP_BANKINS
  add constraint PK_TOP_BANKINS primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating TOP_BASICKIND...
create table TOP_BASICKIND
(
  ID          VARCHAR2(40) not null,
  CODE        VARCHAR2(40) not null,
  VALUE       VARCHAR2(40) not null,
  KIND_CODE   VARCHAR2(40) not null,
  KIND_VALUE  VARCHAR2(40) not null,
  UPDATE_DATE VARCHAR2(10) not null,
  OPERATOR    VARCHAR2(40) not null,
  UPDATE_TIME VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_BASICKIND
  is '数据字典表';
alter table TOP_BASICKIND
  add constraint PK_TOP_BASICKIND primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_BFYINFO...
create table TOP_BFYINFO
(
  BFYSERIALNO      VARCHAR2(32) not null,
  SERIALNO         VARCHAR2(32) not null,
  BRRELATION       VARCHAR2(2) not null,
  BFYNAME          VARCHAR2(60),
  BFYSEX           VARCHAR2(1),
  BFYBIRTHDAY      VARCHAR2(8),
  BFYCFCTYPE       VARCHAR2(2),
  BFYCFCNO         VARCHAR2(60),
  BFYEXPIRYDATE    VARCHAR2(8),
  BFYADDRESS       VARCHAR2(60),
  BFYNUMERATOR     NUMBER(3),
  BFYORDER         NUMBER(4),
  BFYMETHOD        VARCHAR2(1),
  BFYTYPE          VARCHAR2(1),
  OPERATORBANKCODE VARCHAR2(20),
  OPERATORCODE     VARCHAR2(20),
  UPDATEDATE       VARCHAR2(8),
  UPDATETIME       VARCHAR2(8),
  REMARK1          VARCHAR2(60),
  REMARK2          VARCHAR2(60),
  REMARK3          VARCHAR2(60),
  REMARK4          VARCHAR2(60),
  REMARK5          VARCHAR2(60),
  REMARK6          VARCHAR2(60),
  REMARK7          VARCHAR2(60),
  REMARK8          VARCHAR2(60),
  REMARK9          VARCHAR2(60),
  REMARK10         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table TOP_BFYINFO
  is '受益人信息表';
alter table TOP_BFYINFO
  add constraint PK_TOP_BFYINFO primary key (BFYSERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating TOP_BUYINFO...
create table TOP_BUYINFO
(
  SERIALNO         VARCHAR2(32) not null,
  CHANNELFLAG      VARCHAR2(2),
  CHANNELNO        VARCHAR2(32),
  INSCORPCODE      VARCHAR2(10) not null,
  TEMPLATEID       VARCHAR2(20),
  AREAID           VARCHAR2(20),
  PREPOLICYID      VARCHAR2(60),
  POLICYID         VARCHAR2(60),
  OLDPOLICYID      VARCHAR2(200),
  CONTRACTID       VARCHAR2(60),
  ORGNSERIALNO     VARCHAR2(32),
  FIRSTPREMIUM     NUMBER(16,2),
  FIRSTPREMIUMCN   VARCHAR2(60),
  EFFDATE          VARCHAR2(8),
  REVDATE          VARCHAR2(8),
  INNERCOMMISSION  NUMBER(16,2),
  OUTERCOMMISSION  NUMBER(16,2),
  LCOPERATORCODE   VARCHAR2(20),
  LCOPERATORID     VARCHAR2(20),
  LCOPERATORNAME   VARCHAR2(100),
  TZOPERATORCODE   VARCHAR2(20),
  TZOPERATORID     VARCHAR2(20),
  TZOPERATORNAME   VARCHAR2(100),
  INSCORPSTATUS    VARCHAR2(1),
  CORESTATUS       VARCHAR2(1),
  RECORDSTATUS     VARCHAR2(1),
  SERIALTYPE       VARCHAR2(1),
  DELIVER          VARCHAR2(1),
  OPERATORBANKCODE VARCHAR2(20),
  OPERATORCODE     VARCHAR2(20),
  UPDATEDATE       VARCHAR2(20),
  UPDATETIME       VARCHAR2(20),
  REMARK1          VARCHAR2(60),
  REMARK2          VARCHAR2(60),
  REMARK3          VARCHAR2(60),
  REMARK4          VARCHAR2(60),
  REMARK5          VARCHAR2(60),
  REMARK6          VARCHAR2(60),
  REMARK7          VARCHAR2(60),
  REMARK8          VARCHAR2(60),
  REMARK9          VARCHAR2(60),
  REMARK10         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_BUYINFO
  is '新保承保表';
comment on column TOP_BUYINFO.SERIALNO
  is '交易流水号';
comment on column TOP_BUYINFO.CHANNELFLAG
  is '渠道标志(01: 柜面   02: 网银   03: 手机  04: 直销  05:自助)';
comment on column TOP_BUYINFO.CHANNELNO
  is '渠道流水号';
comment on column TOP_BUYINFO.INSCORPCODE
  is '保险公司代码';
comment on column TOP_BUYINFO.TEMPLATEID
  is '产品库ID';
comment on column TOP_BUYINFO.AREAID
  is '地区代码';
comment on column TOP_BUYINFO.PREPOLICYID
  is '投保单号';
comment on column TOP_BUYINFO.POLICYID
  is '保单印刷号';
comment on column TOP_BUYINFO.OLDPOLICYID
  is '旧保单印刷号';
comment on column TOP_BUYINFO.CONTRACTID
  is '保单合同号码';
comment on column TOP_BUYINFO.ORGNSERIALNO
  is '原交易流水号';
comment on column TOP_BUYINFO.FIRSTPREMIUM
  is '首期保费';
comment on column TOP_BUYINFO.FIRSTPREMIUMCN
  is '首期保费大写';
comment on column TOP_BUYINFO.EFFDATE
  is '保单生效日期';
comment on column TOP_BUYINFO.REVDATE
  is '保单到期日期';
comment on column TOP_BUYINFO.INNERCOMMISSION
  is '内扣手续费';
comment on column TOP_BUYINFO.OUTERCOMMISSION
  is '外扣手续费';
comment on column TOP_BUYINFO.LCOPERATORCODE
  is '销售人员网点号';
comment on column TOP_BUYINFO.LCOPERATORID
  is '销售人员ID';
comment on column TOP_BUYINFO.LCOPERATORNAME
  is '销售人员姓名';
comment on column TOP_BUYINFO.TZOPERATORCODE
  is '拓展人员网点号';
comment on column TOP_BUYINFO.TZOPERATORID
  is '拓展人员ID';
comment on column TOP_BUYINFO.TZOPERATORNAME
  is '拓展人员姓名';
comment on column TOP_BUYINFO.INSCORPSTATUS
  is '保险公司状态(1: 待核保   2: 核保成功   3: 核保失败   4: 冲正成功   5: 冲正失败)';
comment on column TOP_BUYINFO.CORESTATUS
  is '核心状态(1: 未扣款   2: 扣款成功   3: 扣款失败   4: 冲正成功   5: 冲正失败   6: 撤单未还款)';
comment on column TOP_BUYINFO.RECORDSTATUS
  is '保单打印状态(1: 已打印   2: 未打印)';
comment on column TOP_BUYINFO.SERIALTYPE
  is '保单状态(1: 正常   2: 失效   3: 终止)';
comment on column TOP_BUYINFO.DELIVER
  is '保单传递方式(1: 银行柜台   2: 邮件发送   3: 上门递送   4: 邮寄)';
comment on column TOP_BUYINFO.OPERATORBANKCODE
  is '操作机构';
comment on column TOP_BUYINFO.OPERATORCODE
  is '操作人员';
comment on column TOP_BUYINFO.UPDATEDATE
  is '操作日期';
comment on column TOP_BUYINFO.UPDATETIME
  is '操作时间';
comment on column TOP_BUYINFO.REMARK1
  is '备注字段一';
comment on column TOP_BUYINFO.REMARK2
  is '备注字段二';
comment on column TOP_BUYINFO.REMARK3
  is '备注字段三';
comment on column TOP_BUYINFO.REMARK4
  is '备注字段四';
comment on column TOP_BUYINFO.REMARK5
  is '备注字段五';
comment on column TOP_BUYINFO.REMARK6
  is '备注字段六';
comment on column TOP_BUYINFO.REMARK7
  is '备注字段七';
comment on column TOP_BUYINFO.REMARK8
  is '备注字段八';
comment on column TOP_BUYINFO.REMARK9
  is '备注字段九';
comment on column TOP_BUYINFO.REMARK10
  is '备注字段十';
alter table TOP_BUYINFO
  add constraint PK_TOP_BUYINFO primary key (SERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_BUYINFOADD...
create table TOP_BUYINFOADD
(
  ADDSERIALNO      VARCHAR2(32) not null,
  SERIALNO         VARCHAR2(32) not null,
  INSPRDCODE       VARCHAR2(8) not null,
  MAINFLAG         CHAR(1),
  PAY_TYPE         VARCHAR2(1),
  PAY_PERIOD       VARCHAR2(3),
  PAY_PERIOD_TYPE  VARCHAR2(1),
  INS_PERIOD       VARCHAR2(3),
  INS_PERIOD_TYPE  VARCHAR2(1),
  INTIALNUMBER     NUMBER(16),
  BASEPREMIUMAMT   NUMBER(16,2),
  BASEENSUREAMT    NUMBER(16,2),
  INNERCOMMISSION  NUMBER(16,2),
  OUTERCOMMISSION  NUMBER(16,2),
  ADRAWTYPE        VARCHAR2(1),
  ADRAWSTARTAGE    VARCHAR2(3),
  ADRAWSTOPAGE     VARCHAR2(3),
  ADRAWPART        VARCHAR2(3),
  BONUSDRAWTYPE    VARCHAR2(10),
  OPERATORBANKCODE VARCHAR2(20) not null,
  OPERATORCODE     VARCHAR2(20) not null,
  UPDATEDATE       VARCHAR2(8) not null,
  UPDATETIME       VARCHAR2(8) not null,
  REMARK1          VARCHAR2(60),
  REMARK2          VARCHAR2(60),
  REMARK3          VARCHAR2(60),
  REMARK4          VARCHAR2(60),
  REMARK5          VARCHAR2(60),
  REMARK6          VARCHAR2(60),
  REMARK7          VARCHAR2(60),
  REMARK8          VARCHAR2(60),
  REMARK9          VARCHAR2(60),
  REMARK10         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table TOP_BUYINFOADD
  is '新保承保产品表';
comment on column TOP_BUYINFOADD.ADDSERIALNO
  is '序列号';
comment on column TOP_BUYINFOADD.SERIALNO
  is '交易流水号(新保承保交易流水号)';
comment on column TOP_BUYINFOADD.INSPRDCODE
  is '交易产品代码';
comment on column TOP_BUYINFOADD.MAINFLAG
  is '主附险标志(0: 主险   1: 附加险)';
comment on column TOP_BUYINFOADD.PAY_TYPE
  is '缴费类型(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';
comment on column TOP_BUYINFOADD.PAY_PERIOD
  is '缴费年期';
comment on column TOP_BUYINFOADD.PAY_PERIOD_TYPE
  is '缴费年期单位(0: 年  1: 周岁  2: 终身)';
comment on column TOP_BUYINFOADD.INS_PERIOD
  is '保障年期';
comment on column TOP_BUYINFOADD.INS_PERIOD_TYPE
  is '保障年期单位(0: 年  1: 周岁  2: 保终身)';
comment on column TOP_BUYINFOADD.INTIALNUMBER
  is '投保份数/档次';
comment on column TOP_BUYINFOADD.BASEPREMIUMAMT
  is '基本保费';
comment on column TOP_BUYINFOADD.BASEENSUREAMT
  is '保险保额';
comment on column TOP_BUYINFOADD.INNERCOMMISSION
  is '内扣手续费';
comment on column TOP_BUYINFOADD.OUTERCOMMISSION
  is '外扣手续费';
comment on column TOP_BUYINFOADD.ADRAWTYPE
  is '年金领取方式';
comment on column TOP_BUYINFOADD.ADRAWSTARTAGE
  is '年金领取开始年龄';
comment on column TOP_BUYINFOADD.ADRAWSTOPAGE
  is '年金领取结束年龄';
comment on column TOP_BUYINFOADD.ADRAWPART
  is '年金保证领取区间';
comment on column TOP_BUYINFOADD.BONUSDRAWTYPE
  is '红利领取方式(1：月领  2：年领  3：趸领)';
comment on column TOP_BUYINFOADD.OPERATORBANKCODE
  is '操作机构';
comment on column TOP_BUYINFOADD.OPERATORCODE
  is '操作人员';
comment on column TOP_BUYINFOADD.UPDATEDATE
  is '操作日期';
comment on column TOP_BUYINFOADD.UPDATETIME
  is '操作时间';
comment on column TOP_BUYINFOADD.REMARK1
  is '备注字段一';
comment on column TOP_BUYINFOADD.REMARK2
  is '备注字段二';
comment on column TOP_BUYINFOADD.REMARK3
  is '备注字段三';
comment on column TOP_BUYINFOADD.REMARK4
  is '备注字段四';
comment on column TOP_BUYINFOADD.REMARK5
  is '备注字段五';
comment on column TOP_BUYINFOADD.REMARK6
  is '备注字段六';
comment on column TOP_BUYINFOADD.REMARK7
  is '备注字段七';
comment on column TOP_BUYINFOADD.REMARK8
  is '备注字段八';
comment on column TOP_BUYINFOADD.REMARK9
  is '备注字段九';
comment on column TOP_BUYINFOADD.REMARK10
  is '备注字段十';
alter table TOP_BUYINFOADD
  add constraint PK_TOP_BUYINFOADD primary key (ADDSERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating TOP_INSCORPINFO...
create table TOP_INSCORPINFO
(
  ID                     VARCHAR2(40) not null,
  INSCORP_CODE           VARCHAR2(10) not null,
  INSCORP_NAME           VARCHAR2(60) not null,
  INS_SIMPLE_NAME        VARCHAR2(40) not null,
  INSCORP_LEVEL          VARCHAR2(8) not null,
  UPCORP_CODE            VARCHAR2(10),
  INSCORP_EN_NAME        VARCHAR2(60),
  ADDRESS                VARCHAR2(80),
  POSTCODE               VARCHAR2(20),
  PHONE                  VARCHAR2(20),
  FAX                    VARCHAR2(20),
  EMAIL                  VARCHAR2(2),
  STATUS                 VARCHAR2(40),
  OPERATOR_CODE          VARCHAR2(40),
  OPERATOR_BANK          VARCHAR2(40),
  CREATE_DATE            VARCHAR2(8),
  UPDATE_DATE            VARCHAR2(8),
  UPDATE_TIME            VARCHAR2(10),
  COMMON_COUNTER_FLAG    VARCHAR2(2) default '0',
  COMMON_NET_FLAG        VARCHAR2(2) default '0',
  COMMON_CHECK_FLAG      VARCHAR2(2) default '0',
  COMMON_NOSSDCHECK_FLAG VARCHAR2(2) default '0',
  COMMON_SYSTB_FLAG      VARCHAR2(2) default '0',
  CHANNEL_FLAG           VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TOP_INSCORPINFO
  add constraint PK_TOP_INSCORPINFO primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TOP_INSCORPINFO
  add constraint AK_KEY_2_TOP_INSC unique (INSCORP_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_INSPRDINFO...
create table TOP_INSPRDINFO
(
  ID               VARCHAR2(40) not null,
  INSPRD_CODE      VARCHAR2(30) not null,
  INSPRD_TRUE_CODE VARCHAR2(30) not null,
  INSCORP_CODE     VARCHAR2(30) not null,
  INSPRD_CNNAME    VARCHAR2(60) not null,
  INSPRD_SIMNAME   VARCHAR2(30),
  ASSURANCE_TYPE   VARCHAR2(2) not null,
  BUY_UNIT         VARCHAR2(2),
  INSPRD_TYPE      VARCHAR2(2),
  INSBENGIN_DATE   VARCHAR2(10),
  INSEND_DATE      VARCHAR2(10),
  START_AMT        VARCHAR2(30),
  END_AMT          VARCHAR2(30),
  INCREASE_AMT     VARCHAR2(30),
  STATUS           VARCHAR2(2),
  IMPAWN_FLAG      VARCHAR2(2),
  TRANS_TYPE       VARCHAR2(2),
  CHANNEL_TYPE     VARCHAR2(20),
  CREATE_DATE      VARCHAR2(10),
  UPDATE_DATE      VARCHAR2(10),
  UPDATE_TIME      VARCHAR2(10),
  OPERATOR         VARCHAR2(40),
  IS_OVER_RISK     VARCHAR2(2),
  HOT_TYPE         VARCHAR2(2),
  YIELD_RATE       VARCHAR2(20),
  MIN_YIELD_RATE   VARCHAR2(20),
  MAX_YIELD_RATE   VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table TOP_INSPRDINFO
  is '保险产品信息表';
comment on column TOP_INSPRDINFO.ID
  is 'ID';
comment on column TOP_INSPRDINFO.INSPRD_CODE
  is '产品代码';
comment on column TOP_INSPRDINFO.INSPRD_TRUE_CODE
  is '产品真实代码';
comment on column TOP_INSPRDINFO.INSCORP_CODE
  is '公司编码';
comment on column TOP_INSPRDINFO.INSPRD_CNNAME
  is '产品名称';
comment on column TOP_INSPRDINFO.INSPRD_SIMNAME
  is '产品简称';
comment on column TOP_INSPRDINFO.ASSURANCE_TYPE
  is '主附险标志(0:主险 1:附加险)';
comment on column TOP_INSPRDINFO.BUY_UNIT
  is '购买单位(0:份数 1:保费 2:保额)';
comment on column TOP_INSPRDINFO.INSPRD_TYPE
  is '产品类型';
comment on column TOP_INSPRDINFO.INSBENGIN_DATE
  is '代理开始日期';
comment on column TOP_INSPRDINFO.INSEND_DATE
  is '代理结束日期';
comment on column TOP_INSPRDINFO.START_AMT
  is '起购金额/数量';
comment on column TOP_INSPRDINFO.END_AMT
  is '最高金额/数量';
comment on column TOP_INSPRDINFO.INCREASE_AMT
  is '递增金额/数量';
comment on column TOP_INSPRDINFO.STATUS
  is '状态(0:有效 1:无效)';
comment on column TOP_INSPRDINFO.IMPAWN_FLAG
  is '是否可质押(0:是 1:否)';
comment on column TOP_INSPRDINFO.TRANS_TYPE
  is '交易类型(0:全部1:实时2:非实时)';
comment on column TOP_INSPRDINFO.CHANNEL_TYPE
  is '交易渠道(01:柜面02:网银03:手机04:直销05:自助)';
comment on column TOP_INSPRDINFO.CREATE_DATE
  is '创建日期';
comment on column TOP_INSPRDINFO.UPDATE_DATE
  is '更新日期';
comment on column TOP_INSPRDINFO.UPDATE_TIME
  is '更新时间';
comment on column TOP_INSPRDINFO.OPERATOR
  is '操作员';
comment on column TOP_INSPRDINFO.IS_OVER_RISK
  is '是否允许超风险购买';
comment on column TOP_INSPRDINFO.HOT_TYPE
  is '1:新 2:抢3:热';
comment on column TOP_INSPRDINFO.YIELD_RATE
  is '预期收益率';
comment on column TOP_INSPRDINFO.MIN_YIELD_RATE
  is '最低收益率';
comment on column TOP_INSPRDINFO.MAX_YIELD_RATE
  is '最高受益率';
alter table TOP_INSPRDINFO
  add constraint PK_TOP_INSPRDINFO primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_INSPRDPERIOD...
create table TOP_INSPRDPERIOD
(
  ID          VARCHAR2(40) not null,
  INSPRD_CODE VARCHAR2(20) not null,
  KEY         VARCHAR2(4),
  UNIT        VARCHAR2(4)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_INSPRDPERIOD
  is '保障年期表';
comment on column TOP_INSPRDPERIOD.ID
  is 'ID';
comment on column TOP_INSPRDPERIOD.INSPRD_CODE
  is '产品编码';
comment on column TOP_INSPRDPERIOD.KEY
  is '值(如单位为终身, 则值为2)';
comment on column TOP_INSPRDPERIOD.UNIT
  is '单位(0-年   1-周岁   2-保终身 )';

prompt Creating TOP_LOG...
create table TOP_LOG
(
  ID            VARCHAR2(60) not null,
  DESCRIPTION   VARCHAR2(200),
  METHOD        VARCHAR2(200),
  TYPE          VARCHAR2(20),
  REQUESTIP     VARCHAR2(60),
  EXCEPTIONCODE VARCHAR2(200),
  EXECUTETIME   VARCHAR2(20),
  PARAMS        VARCHAR2(300),
  CREATEBY      VARCHAR2(60),
  CREATEDATE    VARCHAR2(10),
  CREATETIME    VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TOP_LOG
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_MENUINFO...
create table TOP_MENUINFO
(
  MENU_ID         VARCHAR2(40) not null,
  MENU_CODE       VARCHAR2(20) not null,
  MENU_NAME       VARCHAR2(50) not null,
  UP_MENU_CODE    VARCHAR2(20),
  MENU_URL        VARCHAR2(60),
  STATUS          VARCHAR2(2),
  CREATE_DATE     VARCHAR2(8),
  UPDATE_DATE     VARCHAR2(8),
  UPDATE_TIME     VARCHAR2(6),
  UPDATE_OPERATOR VARCHAR2(40),
  ICON            VARCHAR2(40),
  REMARK1         VARCHAR2(60),
  REMARK2         VARCHAR2(60),
  REMARK3         VARCHAR2(60),
  REMARK4         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_MENUINFO
  is '菜单';
comment on column TOP_MENUINFO.MENU_ID
  is '菜单ID';
comment on column TOP_MENUINFO.MENU_CODE
  is '菜单编号';
comment on column TOP_MENUINFO.MENU_NAME
  is '菜单名称';
comment on column TOP_MENUINFO.UP_MENU_CODE
  is '上级菜单编号';
comment on column TOP_MENUINFO.MENU_URL
  is 'URL';
comment on column TOP_MENUINFO.STATUS
  is '状态(0:有效 1:无效)';
comment on column TOP_MENUINFO.CREATE_DATE
  is '创建日期';
comment on column TOP_MENUINFO.UPDATE_DATE
  is '更新日期';
comment on column TOP_MENUINFO.UPDATE_TIME
  is '更新时间';
comment on column TOP_MENUINFO.UPDATE_OPERATOR
  is '更新账号';
comment on column TOP_MENUINFO.ICON
  is '图标';
comment on column TOP_MENUINFO.REMARK1
  is '备用字段1';
comment on column TOP_MENUINFO.REMARK2
  is '备用字段2';
comment on column TOP_MENUINFO.REMARK3
  is '备用字段3';
comment on column TOP_MENUINFO.REMARK4
  is '备用字段4';
alter table TOP_MENUINFO
  add constraint PK_TOP_MENUINFO primary key (MENU_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_ROLEINFO...
create table TOP_ROLEINFO
(
  ROLE_ID         VARCHAR2(40) not null,
  ROLE_CODE       VARCHAR2(20) not null,
  ROLE_NAME       VARCHAR2(40) not null,
  STATUS          VARCHAR2(2),
  DESCRIPTION     VARCHAR2(100),
  CREATE_DATE     VARCHAR2(8),
  UPDATE_DATE     VARCHAR2(8),
  UPDATE_TIME     VARCHAR2(6),
  UPDATE_OPERATOR VARCHAR2(40),
  REMARK1         VARCHAR2(60),
  REMARK2         VARCHAR2(60),
  REMARK3         VARCHAR2(60),
  REMARK4         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_ROLEINFO
  is '角色表';
comment on column TOP_ROLEINFO.ROLE_ID
  is '角色ID';
comment on column TOP_ROLEINFO.ROLE_CODE
  is '角色编号';
comment on column TOP_ROLEINFO.ROLE_NAME
  is '角色名称';
comment on column TOP_ROLEINFO.STATUS
  is '状态(0:有效1:无效)';
comment on column TOP_ROLEINFO.DESCRIPTION
  is '描述';
comment on column TOP_ROLEINFO.CREATE_DATE
  is '创建日期';
comment on column TOP_ROLEINFO.UPDATE_DATE
  is '更新日期';
comment on column TOP_ROLEINFO.UPDATE_TIME
  is '更新时间';
comment on column TOP_ROLEINFO.UPDATE_OPERATOR
  is '更新账号';
comment on column TOP_ROLEINFO.REMARK1
  is '备用字段1';
comment on column TOP_ROLEINFO.REMARK2
  is '备用字段2';
comment on column TOP_ROLEINFO.REMARK3
  is '备用字段3';
comment on column TOP_ROLEINFO.REMARK4
  is '备用字段4';
alter table TOP_ROLEINFO
  add constraint PK_TOP_ROLEINFO primary key (ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_MENU_ROLE...
create table TOP_MENU_ROLE
(
  ID      VARCHAR2(40) not null,
  ROLE_ID VARCHAR2(60),
  MENU_ID VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_MENU_ROLE
  is '角色菜单表';
comment on column TOP_MENU_ROLE.ID
  is 'ID';
comment on column TOP_MENU_ROLE.ROLE_ID
  is '角色ID';
comment on column TOP_MENU_ROLE.MENU_ID
  is '菜单ID';
alter table TOP_MENU_ROLE
  add constraint PK_TOP_MENU_ROLE primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TOP_MENU_ROLE
  add constraint FK_TOP_MENU_REFERENCE_TOP_MENU foreign key (MENU_ID)
  references TOP_MENUINFO (MENU_ID);
alter table TOP_MENU_ROLE
  add constraint FK_TOP_MENU_REFERENCE_TOP_ROLE foreign key (ROLE_ID)
  references TOP_ROLEINFO (ROLE_ID);

prompt Creating TOP_PAYPERIOD...
create table TOP_PAYPERIOD
(
  ID          VARCHAR2(40) not null,
  INSPRD_CODE VARCHAR2(20) not null,
  KEY         VARCHAR2(4),
  UNIT        VARCHAR2(4)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_PAYPERIOD
  is '缴费年期表';
comment on column TOP_PAYPERIOD.ID
  is 'ID';
comment on column TOP_PAYPERIOD.INSPRD_CODE
  is '产品编码';
comment on column TOP_PAYPERIOD.KEY
  is '值(如单位为终身, 则值为2)';
comment on column TOP_PAYPERIOD.UNIT
  is '单位(0-年   1-周岁   2-终身 )';

prompt Creating TOP_PAYTYPE...
create table TOP_PAYTYPE
(
  ID          VARCHAR2(40) not null,
  INSPRD_CODE VARCHAR2(20) not null,
  KEY         VARCHAR2(4),
  VALUE       VARCHAR2(4)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_PAYTYPE
  is '缴费类型表';
comment on column TOP_PAYTYPE.ID
  is 'ID';
comment on column TOP_PAYTYPE.INSPRD_CODE
  is '产品编码';
comment on column TOP_PAYTYPE.KEY
  is '键(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';
comment on column TOP_PAYTYPE.VALUE
  is '值(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)';
alter table TOP_PAYTYPE
  add constraint PK_TOP_PAYTYPE primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_PHINFO...
create table TOP_PHINFO
(
  PHSERIALNO       VARCHAR2(32) not null,
  SERIALNO         VARCHAR2(32) not null,
  PHNAME           VARCHAR2(60) not null,
  PHACCTYPE        VARCHAR2(1),
  PHACCNO          VARCHAR2(60),
  PHCUSTNO         VARCHAR2(20),
  PHSEX            VARCHAR2(1),
  PHBIRTHDAY       VARCHAR2(8),
  PHCFCTYPE        VARCHAR2(2),
  PHCFCNO          VARCHAR2(60),
  PHEXPIRYDATE     VARCHAR2(8),
  PHADDRESS        VARCHAR2(60),
  PHPOSTCODE       VARCHAR2(10),
  PHCONTACTPHONE   VARCHAR2(20),
  PHFPHONE         VARCHAR2(20),
  PHCPHONE         VARCHAR2(20),
  PHMPHONE         VARCHAR2(20),
  PHEMAIL          VARCHAR2(60),
  PHTEINCOME       NUMBER(16,2),
  PHNALITY         VARCHAR2(10),
  PHHHOLDER        VARCHAR2(60),
  PHCOMPANY        VARCHAR2(60),
  PHJOBTYPE        VARCHAR2(30),
  PHJOB            VARCHAR2(30),
  PHEDUCATION      VARCHAR2(1),
  PHMARRIED        VARCHAR2(1),
  PHRISKLEVEL      VARCHAR2(1),
  OPERATORBANKCODE VARCHAR2(20),
  OPERATORCODE     VARCHAR2(20),
  UPDATEDATE       VARCHAR2(8),
  UPDATETIME       VARCHAR2(8),
  REMARK1          VARCHAR2(60),
  REMARK2          VARCHAR2(60),
  REMARK3          VARCHAR2(60),
  REMARK4          VARCHAR2(60),
  REMARK5          VARCHAR2(60),
  REMARK6          VARCHAR2(60),
  REMARK7          VARCHAR2(60),
  REMARK8          VARCHAR2(60),
  REMARK9          VARCHAR2(60),
  REMARK10         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table TOP_PHINFO
  is '投保人信息表';
comment on column TOP_PHINFO.PHSERIALNO
  is '序列号';
comment on column TOP_PHINFO.SERIALNO
  is '交易流水号(新保承保交易流水号)';
comment on column TOP_PHINFO.PHNAME
  is '投保人姓名';
comment on column TOP_PHINFO.PHACCTYPE
  is '投保人账户类型(0: 卡  1：折)';
comment on column TOP_PHINFO.PHACCNO
  is '序列号';
comment on column TOP_PHINFO.PHCUSTNO
  is '核心客户号';
comment on column TOP_PHINFO.PHSEX
  is '投保人性别(0: 男性  1: 女性)';
comment on column TOP_PHINFO.PHBIRTHDAY
  is '投保人出生日期';
comment on column TOP_PHINFO.PHCFCTYPE
  is '投保人证件类型(1身份证 2户口本 3军官证 4警官证 5护照 6港澳通行证 7法人组织机构代码证
8非法人组织机构代码证 9文职干部证 10士兵证 11台湾通行证 12其他)';
comment on column TOP_PHINFO.PHCFCNO
  is '投保人证件号码';
comment on column TOP_PHINFO.PHEXPIRYDATE
  is '证件有效期';
comment on column TOP_PHINFO.PHADDRESS
  is '投保人通讯地址';
comment on column TOP_PHINFO.PHPOSTCODE
  is '投保人邮编';
comment on column TOP_PHINFO.PHCONTACTPHONE
  is '联系电话';
comment on column TOP_PHINFO.PHFPHONE
  is '家庭电话';
comment on column TOP_PHINFO.PHCPHONE
  is '公司电话';
comment on column TOP_PHINFO.PHMPHONE
  is '投保人手机号码';
comment on column TOP_PHINFO.PHEMAIL
  is '投保人电子邮件';
comment on column TOP_PHINFO.PHTEINCOME
  is '投保人过去三年的平均收入(年收入)';
comment on column TOP_PHINFO.PHNALITY
  is '国籍';
comment on column TOP_PHINFO.PHHHOLDER
  is '户籍';
comment on column TOP_PHINFO.PHCOMPANY
  is '工作单位';
comment on column TOP_PHINFO.PHJOBTYPE
  is '投保险人职业类别';
comment on column TOP_PHINFO.PHJOB
  is '投保险人职业';
comment on column TOP_PHINFO.PHEDUCATION
  is '学历(1博士研究生 2硕士研究生 3大学本科 4大学专科 5普通高中 6中职（中专、职专、技校）7初中 8初中以下)';
comment on column TOP_PHINFO.PHMARRIED
  is '婚姻状况(1: 已婚  2: 未婚 3: 离异  4: 丧偶)';
comment on column TOP_PHINFO.PHRISKLEVEL
  is '风险评估等级(0: 进取型  1: 成长型  2: 平衡型  3: 稳健型  4: 保守型)';
comment on column TOP_PHINFO.OPERATORBANKCODE
  is '操作机构';
comment on column TOP_PHINFO.OPERATORCODE
  is '操作人员';
comment on column TOP_PHINFO.UPDATEDATE
  is '操作日期';
comment on column TOP_PHINFO.UPDATETIME
  is '操作时间';
comment on column TOP_PHINFO.REMARK1
  is '备注字段一';
comment on column TOP_PHINFO.REMARK2
  is '备注字段二';
comment on column TOP_PHINFO.REMARK3
  is '备注字段三';
comment on column TOP_PHINFO.REMARK4
  is '备注字段四';
comment on column TOP_PHINFO.REMARK5
  is '备注字段五';
comment on column TOP_PHINFO.REMARK6
  is '备注字段六';
comment on column TOP_PHINFO.REMARK7
  is '备注字段七';
comment on column TOP_PHINFO.REMARK8
  is '备注字段八';
comment on column TOP_PHINFO.REMARK9
  is '备注字段九';
comment on column TOP_PHINFO.REMARK10
  is '备注字段十';
alter table TOP_PHINFO
  add constraint PK_TOP_PHINFO primary key (PHSERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating TOP_RNINFO...
create table TOP_RNINFO
(
  RNSERIALNO       VARCHAR2(32) not null,
  SERIALNO         VARCHAR2(32) not null,
  PRRELATION       VARCHAR2(1) not null,
  RNNAME           VARCHAR2(60),
  RNSEX            VARCHAR2(1),
  RNBIRTHDAY       VARCHAR2(8),
  RNCFCTYPE        VARCHAR2(2),
  RNCFCNO          VARCHAR2(60),
  RNEXPIRYDATE     VARCHAR2(8),
  RNADDRESS        VARCHAR2(60),
  RNPOSTCODE       VARCHAR2(10),
  RNCONTACTPHONE   VARCHAR2(20),
  RNFPHONE         VARCHAR2(20),
  RNCPHONE         VARCHAR2(20),
  RNMPHONE         VARCHAR2(20),
  RNEMAIL          VARCHAR2(30),
  RNTEINCOME       NUMBER(16,2),
  RNNALITY         VARCHAR2(60),
  RNHHOLDER        VARCHAR2(60),
  RNCOMPANY        VARCHAR2(60),
  RNJOBTYPE        VARCHAR2(30),
  RNJOB            VARCHAR2(30),
  RNEDUCATION      VARCHAR2(1),
  RNMARRIED        VARCHAR2(1),
  OPERATORBANKCODE VARCHAR2(20),
  OPERATORCODE     VARCHAR2(20),
  UPDATEDATE       VARCHAR2(8),
  UPDATETIME       VARCHAR2(8),
  REMARK1          VARCHAR2(60),
  REMARK2          VARCHAR2(60),
  REMARK3          VARCHAR2(60),
  REMARK4          VARCHAR2(60),
  REMARK5          VARCHAR2(60),
  REMARK6          VARCHAR2(60),
  REMARK7          VARCHAR2(60),
  REMARK8          VARCHAR2(60),
  REMARK9          VARCHAR2(60),
  REMARK10         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table TOP_RNINFO
  is '被保人信息表';
comment on column TOP_RNINFO.RNSERIALNO
  is '序列号';
comment on column TOP_RNINFO.SERIALNO
  is '交易流水号(新保承保交易流水号)';
comment on column TOP_RNINFO.PRRELATION
  is '投保人与被保险人关系(1本人 2配偶 3父子 4父女 5母子 6母女 7兄弟 8姊妹 9兄妹 10姐弟 11雇佣 12法定 13其他)';
comment on column TOP_RNINFO.RNNAME
  is '被保人姓名';
comment on column TOP_RNINFO.RNSEX
  is '被保人性别(0: 男性  1: 女性)';
comment on column TOP_RNINFO.RNBIRTHDAY
  is '被保人出生日期';
comment on column TOP_RNINFO.RNCFCTYPE
  is '被保人证件类型(1身份证 2户口本 3军官证 4警官证 5护照 6港澳通行证 7法人组织机构代码证
8非法人组织机构代码证 9文职干部证 10士兵证 11台湾通行证 12其他)';
comment on column TOP_RNINFO.RNCFCNO
  is '被保人证件号码';
comment on column TOP_RNINFO.RNEXPIRYDATE
  is '证件有效期';
comment on column TOP_RNINFO.RNADDRESS
  is '被保人通讯地址';
comment on column TOP_RNINFO.RNPOSTCODE
  is '被保人邮编';
comment on column TOP_RNINFO.RNCONTACTPHONE
  is '联系电话';
comment on column TOP_RNINFO.RNFPHONE
  is '家庭电话';
comment on column TOP_RNINFO.RNCPHONE
  is '公司电话';
comment on column TOP_RNINFO.RNMPHONE
  is '被保人手机号码';
comment on column TOP_RNINFO.RNEMAIL
  is '被保人电子邮件';
comment on column TOP_RNINFO.RNTEINCOME
  is '投保人过去三年的平均收入(年收入)';
comment on column TOP_RNINFO.RNNALITY
  is '国籍';
comment on column TOP_RNINFO.RNHHOLDER
  is '户籍';
comment on column TOP_RNINFO.RNCOMPANY
  is '工作单位';
comment on column TOP_RNINFO.RNJOBTYPE
  is '被保险人职业类别';
comment on column TOP_RNINFO.RNJOB
  is '被保险人职业';
comment on column TOP_RNINFO.RNEDUCATION
  is '学历(1博士研究生 2硕士研究生 3大学本科 4大学专科 5普通高中 6中职（中专、职专、技校）7初中 8初中以下)';
comment on column TOP_RNINFO.RNMARRIED
  is '婚姻状况(1: 已婚  2: 未婚 3: 离异  4: 丧偶)';
comment on column TOP_RNINFO.OPERATORBANKCODE
  is '操作机构';
comment on column TOP_RNINFO.OPERATORCODE
  is '操作人员';
comment on column TOP_RNINFO.UPDATEDATE
  is '操作日期';
comment on column TOP_RNINFO.UPDATETIME
  is '操作时间';
comment on column TOP_RNINFO.REMARK1
  is '备注字段一';
comment on column TOP_RNINFO.REMARK2
  is '备注字段二';
comment on column TOP_RNINFO.REMARK3
  is '备注字段三';
comment on column TOP_RNINFO.REMARK4
  is '备注字段四';
comment on column TOP_RNINFO.REMARK5
  is '备注字段五';
comment on column TOP_RNINFO.REMARK6
  is '备注字段六';
comment on column TOP_RNINFO.REMARK7
  is '备注字段七';
comment on column TOP_RNINFO.REMARK8
  is '备注字段八';
comment on column TOP_RNINFO.REMARK9
  is '备注字段九';
comment on column TOP_RNINFO.REMARK10
  is '备注字段十';
alter table TOP_RNINFO
  add constraint PK_TOP_RNINFO primary key (RNSERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating TOP_USERINFO...
create table TOP_USERINFO
(
  USER_ID         VARCHAR2(40) not null,
  LOGIN_ACCOUNT   VARCHAR2(60) not null,
  LOGIN_PWD       VARCHAR2(60) not null,
  USER_NAME       VARCHAR2(30) not null,
  USER_STATUS     VARCHAR2(2),
  USER_DEPT       VARCHAR2(8),
  CREATE_DATE     VARCHAR2(40),
  OPERATOR_PHONE  VARCHAR2(20),
  UPDATE_DATE     VARCHAR2(8),
  UPDATE_TIME     VARCHAR2(6),
  UPDATE_OPERATOR VARCHAR2(20),
  FILE_PATH       VARCHAR2(60),
  REMARK1         VARCHAR2(60),
  REMARK2         VARCHAR2(60),
  REMARK3         VARCHAR2(60),
  REMARK4         VARCHAR2(60)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_USERINFO
  is '用户表';
comment on column TOP_USERINFO.USER_ID
  is '用户ID';
comment on column TOP_USERINFO.LOGIN_ACCOUNT
  is '登录账号';
comment on column TOP_USERINFO.LOGIN_PWD
  is '用户名';
comment on column TOP_USERINFO.USER_NAME
  is '姓名';
comment on column TOP_USERINFO.USER_STATUS
  is '状态（0:有效 1:无效）';
comment on column TOP_USERINFO.USER_DEPT
  is '所属机构';
comment on column TOP_USERINFO.CREATE_DATE
  is '创建日期';
comment on column TOP_USERINFO.OPERATOR_PHONE
  is '用户电话';
comment on column TOP_USERINFO.UPDATE_DATE
  is '更新日期';
comment on column TOP_USERINFO.UPDATE_TIME
  is '更新时间';
comment on column TOP_USERINFO.UPDATE_OPERATOR
  is '更新账号';
comment on column TOP_USERINFO.FILE_PATH
  is '文件路径';
comment on column TOP_USERINFO.REMARK1
  is '备注字段1';
comment on column TOP_USERINFO.REMARK2
  is '备注字段2';
comment on column TOP_USERINFO.REMARK3
  is '备注字段3';
comment on column TOP_USERINFO.REMARK4
  is '备注字段4';
alter table TOP_USERINFO
  add constraint PK_TOP_USERINFO primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TOP_USERINFO
  add constraint AK_UQ_ACCOUNT_TOP_USER unique (LOGIN_ACCOUNT)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TOP_USER_ROLE...
create table TOP_USER_ROLE
(
  ID          VARCHAR2(40) not null,
  ROLE_ID     VARCHAR2(60) not null,
  USER_ID     VARCHAR2(60),
  CREATE_DATE VARCHAR2(8),
  UPDATE_DATE VARCHAR2(8)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TOP_USER_ROLE
  is '用户角色绑定表';
comment on column TOP_USER_ROLE.ID
  is 'ID';
comment on column TOP_USER_ROLE.ROLE_ID
  is '角色ID';
comment on column TOP_USER_ROLE.USER_ID
  is '用户ID';
comment on column TOP_USER_ROLE.CREATE_DATE
  is '创建日期';
comment on column TOP_USER_ROLE.UPDATE_DATE
  is '更新日期';
alter table TOP_USER_ROLE
  add constraint PK_TOP_USER_ROLE primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TOP_USER_ROLE
  add constraint FK_TOP_USER_REFERENCE_TOP_ROLE foreign key (ROLE_ID)
  references TOP_ROLEINFO (ROLE_ID);
alter table TOP_USER_ROLE
  add constraint FK_TOP_USER_REFERENCE_TOP_USER foreign key (USER_ID)
  references TOP_USERINFO (USER_ID);

prompt Disabling triggers for TOP_AGENTRATE...
alter table TOP_AGENTRATE disable all triggers;
prompt Disabling triggers for TOP_BANKANDCORP...
alter table TOP_BANKANDCORP disable all triggers;
prompt Disabling triggers for TOP_BANKINFO...
alter table TOP_BANKINFO disable all triggers;
prompt Disabling triggers for TOP_BANKINS...
alter table TOP_BANKINS disable all triggers;
prompt Disabling triggers for TOP_BASICKIND...
alter table TOP_BASICKIND disable all triggers;
prompt Disabling triggers for TOP_BFYINFO...
alter table TOP_BFYINFO disable all triggers;
prompt Disabling triggers for TOP_BUYINFO...
alter table TOP_BUYINFO disable all triggers;
prompt Disabling triggers for TOP_BUYINFOADD...
alter table TOP_BUYINFOADD disable all triggers;
prompt Disabling triggers for TOP_INSCORPINFO...
alter table TOP_INSCORPINFO disable all triggers;
prompt Disabling triggers for TOP_INSPRDINFO...
alter table TOP_INSPRDINFO disable all triggers;
prompt Disabling triggers for TOP_INSPRDPERIOD...
alter table TOP_INSPRDPERIOD disable all triggers;
prompt Disabling triggers for TOP_LOG...
alter table TOP_LOG disable all triggers;
prompt Disabling triggers for TOP_MENUINFO...
alter table TOP_MENUINFO disable all triggers;
prompt Disabling triggers for TOP_ROLEINFO...
alter table TOP_ROLEINFO disable all triggers;
prompt Disabling triggers for TOP_MENU_ROLE...
alter table TOP_MENU_ROLE disable all triggers;
prompt Disabling triggers for TOP_PAYPERIOD...
alter table TOP_PAYPERIOD disable all triggers;
prompt Disabling triggers for TOP_PAYTYPE...
alter table TOP_PAYTYPE disable all triggers;
prompt Disabling triggers for TOP_PHINFO...
alter table TOP_PHINFO disable all triggers;
prompt Disabling triggers for TOP_RNINFO...
alter table TOP_RNINFO disable all triggers;
prompt Disabling triggers for TOP_USERINFO...
alter table TOP_USERINFO disable all triggers;
prompt Disabling triggers for TOP_USER_ROLE...
alter table TOP_USER_ROLE disable all triggers;
prompt Disabling foreign key constraints for TOP_MENU_ROLE...
alter table TOP_MENU_ROLE disable constraint FK_TOP_MENU_REFERENCE_TOP_MENU;
alter table TOP_MENU_ROLE disable constraint FK_TOP_MENU_REFERENCE_TOP_ROLE;
prompt Disabling foreign key constraints for TOP_USER_ROLE...
alter table TOP_USER_ROLE disable constraint FK_TOP_USER_REFERENCE_TOP_ROLE;
alter table TOP_USER_ROLE disable constraint FK_TOP_USER_REFERENCE_TOP_USER;
prompt Deleting TOP_USER_ROLE...
delete from TOP_USER_ROLE;
commit;
prompt Deleting TOP_USERINFO...
delete from TOP_USERINFO;
commit;
prompt Deleting TOP_RNINFO...
delete from TOP_RNINFO;
commit;
prompt Deleting TOP_PHINFO...
delete from TOP_PHINFO;
commit;
prompt Deleting TOP_PAYTYPE...
delete from TOP_PAYTYPE;
commit;
prompt Deleting TOP_PAYPERIOD...
delete from TOP_PAYPERIOD;
commit;
prompt Deleting TOP_MENU_ROLE...
delete from TOP_MENU_ROLE;
commit;
prompt Deleting TOP_ROLEINFO...
delete from TOP_ROLEINFO;
commit;
prompt Deleting TOP_MENUINFO...
delete from TOP_MENUINFO;
commit;
prompt Deleting TOP_LOG...
delete from TOP_LOG;
commit;
prompt Deleting TOP_INSPRDPERIOD...
delete from TOP_INSPRDPERIOD;
commit;
prompt Deleting TOP_INSPRDINFO...
delete from TOP_INSPRDINFO;
commit;
prompt Deleting TOP_INSCORPINFO...
delete from TOP_INSCORPINFO;
commit;
prompt Deleting TOP_BUYINFOADD...
delete from TOP_BUYINFOADD;
commit;
prompt Deleting TOP_BUYINFO...
delete from TOP_BUYINFO;
commit;
prompt Deleting TOP_BFYINFO...
delete from TOP_BFYINFO;
commit;
prompt Deleting TOP_BASICKIND...
delete from TOP_BASICKIND;
commit;
prompt Deleting TOP_BANKINS...
delete from TOP_BANKINS;
commit;
prompt Deleting TOP_BANKINFO...
delete from TOP_BANKINFO;
commit;
prompt Deleting TOP_BANKANDCORP...
delete from TOP_BANKANDCORP;
commit;
prompt Deleting TOP_AGENTRATE...
delete from TOP_AGENTRATE;
commit;
prompt Loading TOP_AGENTRATE...
insert into TOP_AGENTRATE (ID, INSPRD_CODE, ADMIN_BANK, TRANS_TYPE, PAY_TYPE, PAY_PERIOD, PAY_PERIOD_TYPE, RATE_TYPE, ONCE_AMT, PERCENT_AMT, INS_PERIOD, INS_PERIOD_TYPE, OPERATOR, OPERATOR_BANK, UPDATE_DATE, UPDATE_TIME)
values ('896c4bdfde8c4b7eabf8d6b95fe5c504', '28000001', '9901', '1', '1', null, null, '2', null, '0.3', '2', '2', null, null, '20161111', '143401');
insert into TOP_AGENTRATE (ID, INSPRD_CODE, ADMIN_BANK, TRANS_TYPE, PAY_TYPE, PAY_PERIOD, PAY_PERIOD_TYPE, RATE_TYPE, ONCE_AMT, PERCENT_AMT, INS_PERIOD, INS_PERIOD_TYPE, OPERATOR, OPERATOR_BANK, UPDATE_DATE, UPDATE_TIME)
values ('cd6fc72121ef4789b86337ee2139c19d', '28000001', '9901', '1', '5', '5', '0', '2', null, '0.4', '10', '0', null, null, '20161111', '143401');
insert into TOP_AGENTRATE (ID, INSPRD_CODE, ADMIN_BANK, TRANS_TYPE, PAY_TYPE, PAY_PERIOD, PAY_PERIOD_TYPE, RATE_TYPE, ONCE_AMT, PERCENT_AMT, INS_PERIOD, INS_PERIOD_TYPE, OPERATOR, OPERATOR_BANK, UPDATE_DATE, UPDATE_TIME)
values ('1ff17c1850a642e29f25d6413d9886d9', '28000001', '9901', '1', '5', '5', '0', '2', null, '0.6', '20', '0', null, null, '20161111', '143401');
insert into TOP_AGENTRATE (ID, INSPRD_CODE, ADMIN_BANK, TRANS_TYPE, PAY_TYPE, PAY_PERIOD, PAY_PERIOD_TYPE, RATE_TYPE, ONCE_AMT, PERCENT_AMT, INS_PERIOD, INS_PERIOD_TYPE, OPERATOR, OPERATOR_BANK, UPDATE_DATE, UPDATE_TIME)
values ('1776fbaa717a4023bfe872ede2116b94', '28000001', '9901', '1', '5', '5', '0', '2', null, '0.3', '2', '2', null, null, '20161111', '143401');
insert into TOP_AGENTRATE (ID, INSPRD_CODE, ADMIN_BANK, TRANS_TYPE, PAY_TYPE, PAY_PERIOD, PAY_PERIOD_TYPE, RATE_TYPE, ONCE_AMT, PERCENT_AMT, INS_PERIOD, INS_PERIOD_TYPE, OPERATOR, OPERATOR_BANK, UPDATE_DATE, UPDATE_TIME)
values ('4406875bd9d946e3b17ad5d1b3083f95', '28000001', '9901', '1', '1', null, null, '2', null, '0.1', '20', '0', null, null, '20161111', '143401');
insert into TOP_AGENTRATE (ID, INSPRD_CODE, ADMIN_BANK, TRANS_TYPE, PAY_TYPE, PAY_PERIOD, PAY_PERIOD_TYPE, RATE_TYPE, ONCE_AMT, PERCENT_AMT, INS_PERIOD, INS_PERIOD_TYPE, OPERATOR, OPERATOR_BANK, UPDATE_DATE, UPDATE_TIME)
values ('2ea8935cccff492288fdf78921e2cb71', '28000001', '9901', '1', '1', null, null, '2', null, '0.5', '10', '0', null, null, '20161111', '143401');
insert into TOP_AGENTRATE (ID, INSPRD_CODE, ADMIN_BANK, TRANS_TYPE, PAY_TYPE, PAY_PERIOD, PAY_PERIOD_TYPE, RATE_TYPE, ONCE_AMT, PERCENT_AMT, INS_PERIOD, INS_PERIOD_TYPE, OPERATOR, OPERATOR_BANK, UPDATE_DATE, UPDATE_TIME)
values ('3', '53000001', 'CN0010151', '1', '1', null, null, '2', null, '0.15', '5', '0', null, null, null, null);
commit;
prompt 7 records loaded
prompt Loading TOP_BANKANDCORP...
insert into TOP_BANKANDCORP (BANKCODE, BANKCHNAME, CORPCODE, CORPCODE2, CORPCODE3, FILENAME, OPERATORBANKCODE, OPERATORCODE, OPERDATE, OPERTIME, REVIEWBANKCODE, REVIEWCODE, UPDATEDATE, UPDATETIME)
values ('9802', '雨花台支行', '2800', '4200', '5300', null, null, null, '20161111', '135906', null, null, '20161111', '135906');
commit;
prompt 1 records loaded
prompt Loading TOP_BANKINFO...
insert into TOP_BANKINFO (BANK_ID, BANK_CODE, BANK_NAME, BANK_LEVEL, UP_BANK_CODE, ADDRESS, POSTCODE, PHONE, FAX, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, CERT_NO, CERT_START_DATE, CERT_END_DATE, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234662a07ab71a3eb51665', '9901', '总行', '0', null, null, null, null, null, '0', null, '20161115', '112409', null, null, null, null, null, null, null);
insert into TOP_BANKINFO (BANK_ID, BANK_CODE, BANK_NAME, BANK_LEVEL, UP_BANK_CODE, ADDRESS, POSTCODE, PHONE, FAX, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, CERT_NO, CERT_START_DATE, CERT_END_DATE, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853b234662a07ab71a3eb51666', '9801', '南京分行', '1', '9901', null, null, null, null, '0', null, '20161115', '112415', null, null, null, null, null, null, null);
insert into TOP_BANKINFO (BANK_ID, BANK_CODE, BANK_NAME, BANK_LEVEL, UP_BANK_CODE, ADDRESS, POSTCODE, PHONE, FAX, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, CERT_NO, CERT_START_DATE, CERT_END_DATE, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234662a07ab71a3eb51667', '9802', '雨花台支行', '2', '9801', null, null, null, null, '0', null, '20161115', '112420', null, null, null, null, null, null, null);
insert into TOP_BANKINFO (BANK_ID, BANK_CODE, BANK_NAME, BANK_LEVEL, UP_BANK_CODE, ADDRESS, POSTCODE, PHONE, FAX, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, CERT_NO, CERT_START_DATE, CERT_END_DATE, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853b234662a07ab71a3eb51668', '9803', '雨花南路支行', '3', '9802', null, null, null, null, '0', null, '20161115', '112423', null, null, null, null, null, null, null);
commit;
prompt 4 records loaded
prompt Loading TOP_BANKINS...
prompt Table is empty
prompt Loading TOP_BASICKIND...
insert into TOP_BASICKIND (ID, CODE, VALUE, KIND_CODE, KIND_VALUE, UPDATE_DATE, OPERATOR, UPDATE_TIME)
values ('0eca4730614d439882b98f49ac5b27a0', '33', '饿25243', '4524', '6234为', '20161103', '000000', '145903');
insert into TOP_BASICKIND (ID, CODE, VALUE, KIND_CODE, KIND_VALUE, UPDATE_DATE, OPERATOR, UPDATE_TIME)
values ('c5aab4c9ef504e4ba36503833ee6034f', '452', '惹她问', '324123', '人忒特', '20161103', '000000', '150023');
insert into TOP_BASICKIND (ID, CODE, VALUE, KIND_CODE, KIND_VALUE, UPDATE_DATE, OPERATOR, UPDATE_TIME)
values ('4ad5447604894ccfbd38a8e9a9865f26', '55', '额他认为', '3452', '如果微软', '20161103', '000000', '150125');
insert into TOP_BASICKIND (ID, CODE, VALUE, KIND_CODE, KIND_VALUE, UPDATE_DATE, OPERATOR, UPDATE_TIME)
values ('b2f2c6a0e3984a81bc63500fdbe1f0a8', '341', '而认为让他', '453', '特权而', '20161103', '000000', '150336');
insert into TOP_BASICKIND (ID, CODE, VALUE, KIND_CODE, KIND_VALUE, UPDATE_DATE, OPERATOR, UPDATE_TIME)
values ('bd95d78ff17941379432904ec546a870', '4525', '而且微软', '45245', '尔特委托', '20161103', '000000', '150513');
insert into TOP_BASICKIND (ID, CODE, VALUE, KIND_CODE, KIND_VALUE, UPDATE_DATE, OPERATOR, UPDATE_TIME)
values ('8ae5e789d4be49bfa070fa0ce7caa6da', '22', '认为太热额', '345243', '图文让他', '20161104', '000000', '100829');
insert into TOP_BASICKIND (ID, CODE, VALUE, KIND_CODE, KIND_VALUE, UPDATE_DATE, OPERATOR, UPDATE_TIME)
values ('05684f2909f14f29b6ed3512113e8d34', '3', '二人情味二', '34524', '让他认为他能', '20161104', '000000', '102318');
commit;
prompt 7 records loaded
prompt Loading TOP_BFYINFO...
prompt Table is empty
prompt Loading TOP_BUYINFO...
prompt Table is empty
prompt Loading TOP_BUYINFOADD...
prompt Table is empty
prompt Loading TOP_INSCORPINFO...
insert into TOP_INSCORPINFO (ID, INSCORP_CODE, INSCORP_NAME, INS_SIMPLE_NAME, INSCORP_LEVEL, UPCORP_CODE, INSCORP_EN_NAME, ADDRESS, POSTCODE, PHONE, FAX, EMAIL, STATUS, OPERATOR_CODE, OPERATOR_BANK, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, COMMON_COUNTER_FLAG, COMMON_NET_FLAG, COMMON_CHECK_FLAG, COMMON_NOSSDCHECK_FLAG, COMMON_SYSTB_FLAG, CHANNEL_FLAG)
values ('b1a507c433a343e18c02f59e47db60ae', '2800', '新华人寿保险公司', '新华人寿', '0', null, null, null, null, null, null, null, '0', '000000', '9901', '20160926', '20160926', '104516', null, null, null, null, null, null);
insert into TOP_INSCORPINFO (ID, INSCORP_CODE, INSCORP_NAME, INS_SIMPLE_NAME, INSCORP_LEVEL, UPCORP_CODE, INSCORP_EN_NAME, ADDRESS, POSTCODE, PHONE, FAX, EMAIL, STATUS, OPERATOR_CODE, OPERATOR_BANK, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, COMMON_COUNTER_FLAG, COMMON_NET_FLAG, COMMON_CHECK_FLAG, COMMON_NOSSDCHECK_FLAG, COMMON_SYSTB_FLAG, CHANNEL_FLAG)
values ('a8b4635c178f468cb7ea3ae7a7c0d7f6', '4200', '国华人寿保险公司', '国华人寿', '0', null, null, null, null, null, null, null, '0', '000000', '9901', '20161111', '20161111', '140307', null, null, null, null, null, null);
insert into TOP_INSCORPINFO (ID, INSCORP_CODE, INSCORP_NAME, INS_SIMPLE_NAME, INSCORP_LEVEL, UPCORP_CODE, INSCORP_EN_NAME, ADDRESS, POSTCODE, PHONE, FAX, EMAIL, STATUS, OPERATOR_CODE, OPERATOR_BANK, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, COMMON_COUNTER_FLAG, COMMON_NET_FLAG, COMMON_CHECK_FLAG, COMMON_NOSSDCHECK_FLAG, COMMON_SYSTB_FLAG, CHANNEL_FLAG)
values ('8a9b7708f5b1423eba6cc60a2d602a0b', '5300', '安邦人寿保险公司', '安邦人寿', '0', null, null, null, null, null, null, null, '0', '000000', '9901', '20161111', '20161111', '140212', null, null, null, null, null, null);
insert into TOP_INSCORPINFO (ID, INSCORP_CODE, INSCORP_NAME, INS_SIMPLE_NAME, INSCORP_LEVEL, UPCORP_CODE, INSCORP_EN_NAME, ADDRESS, POSTCODE, PHONE, FAX, EMAIL, STATUS, OPERATOR_CODE, OPERATOR_BANK, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, COMMON_COUNTER_FLAG, COMMON_NET_FLAG, COMMON_CHECK_FLAG, COMMON_NOSSDCHECK_FLAG, COMMON_SYSTB_FLAG, CHANNEL_FLAG)
values ('8e8717c0431541b4926da920eeda409c', '5400', '信泰人寿保险公司', '信泰人寿', '0', null, null, null, null, null, null, null, '0', '000000', '9901', '20161111', '20161111', '112819', null, null, null, null, null, null);
commit;
prompt 4 records loaded
prompt Loading TOP_INSPRDINFO...
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('1', '28000001', '28000001', '2800', '红双喜新A款两全保险（分红型）', '红双喜新A款两全保险', '0', '0', null, null, null, '5000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '1', '7%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('2', '28000002', '28000002', '2800', '红双喜新C款两全险（分红险）', '红双喜新C款两全险', '0', '0', null, null, null, '10000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '3', '9%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('11', '53000001', '53000001' || chr(10) || '', '5300', '安邦一号保险', '安邦一号', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('10', '28000010', '28000010', '2800', '附加红双喜重大疾病保险', '附加红双喜重大疾病险', '1', '0', null, null, null, '10000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '3', '9%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('9', '28000009', '28000009', '2800', '惠福宝两全保险', '惠福宝两全险', '0', '0', null, null, null, '5000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '1', '7.5%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('8', '28000008', '28000008', '2800', '红双喜新C款两全险（分红险）', '红双喜新C款两险', '0', '0', null, null, null, '10000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '3', '9.5%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('7', '28000007', '28000007', '2800', '康爱无忧两全保险', '康爱无忧两全险', '0', '0', null, null, null, '5000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '1', '7%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('6', '28000006', '28000006', '2800', '荣享人生养老年金保险（分红型）', '荣享人生养老年金险', '0', '0', null, null, null, '10000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '3', '8.5%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('5', '28000005', '28000005', '2800', '红双喜盈宝顺两全保险（分红型）', '红双喜盈宝顺两全险', '0', '0', null, null, null, '5000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '1', '8%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('4', '28000004', '28000004', '2800', '红双喜盈宝瑞两全保险（分红型）', '红双喜盈宝瑞两全险', '0', '0', null, null, null, '10000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '3', '9%', null, null);
insert into TOP_INSPRDINFO (ID, INSPRD_CODE, INSPRD_TRUE_CODE, INSCORP_CODE, INSPRD_CNNAME, INSPRD_SIMNAME, ASSURANCE_TYPE, BUY_UNIT, INSPRD_TYPE, INSBENGIN_DATE, INSEND_DATE, START_AMT, END_AMT, INCREASE_AMT, STATUS, IMPAWN_FLAG, TRANS_TYPE, CHANNEL_TYPE, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, OPERATOR, IS_OVER_RISK, HOT_TYPE, YIELD_RATE, MIN_YIELD_RATE, MAX_YIELD_RATE)
values ('3', '28000003', '28000003', '2800', '红双喜金钱柜年金保险（分红型）', '红双喜金钱柜年金险', '0', '0', null, null, null, '5000', null, null, '0', null, null, null, null, '20161118', '103412', '000000', null, '1', '6%', null, null);
commit;
prompt 11 records loaded
prompt Loading TOP_INSPRDPERIOD...
insert into TOP_INSPRDPERIOD (ID, INSPRD_CODE, KEY, UNIT)
values ('1', '28000001', '10', '0');
insert into TOP_INSPRDPERIOD (ID, INSPRD_CODE, KEY, UNIT)
values ('2', '28000001', '20', '0');
insert into TOP_INSPRDPERIOD (ID, INSPRD_CODE, KEY, UNIT)
values ('3', '28000001', '2', '2');
insert into TOP_INSPRDPERIOD (ID, INSPRD_CODE, KEY, UNIT)
values ('6764842cb37b469b8d85271efdd42f12', '28000001', '15', '0');
commit;
prompt 4 records loaded
prompt Loading TOP_LOG...
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('e7b1ed7a-db40-42eb-a6f2-64fb4d39346f', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.1.167', null, '运行消耗28ms', null, null, '20161118', '104603');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('5e7c0fcd-397d-4814-b6d5-a4d13394bf55', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.1.167', null, '运行消耗60ms', null, null, '20161121', '164243');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('242d9b2d-299e-4fc0-8e8d-69b3e6b54f2a', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.1.167', null, '运行消耗7ms', null, null, '20161121', '164350');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('0ad5d142-5a5f-4af0-a9e8-23b05e20ebbc', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗4ms', null, '管理员', '20161122', '141736');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('18f5dc54-7709-4c0b-9219-4a9be4588f9d', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗146ms', null, null, '20161122', '094650');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('dddd05b9-cb8a-424b-93a8-3e8bb6135846', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗16ms', null, null, '20161122', '094817');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('351a4dc1-7c98-434d-9618-b4b0f4c11cf3', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗8ms', null, '管理员', '20161122', '104237');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('679817b1-ecb0-4e32-84a6-167c8cc32728', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗7ms', null, '管理员', '20161122', '112508');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('f9c73107-6a1b-48fd-857f-bc19b0c6b8a1', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗5ms', null, '管理员', '20161122', '141202');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('11e51635-7901-4f39-9fa2-0a3d28b893f3', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗16ms', null, null, '20161115', '113326');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('8093a5d3-2967-48a8-b1b9-dd84dd2bce9c', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗54ms', null, null, '20161117', '111056');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('fd4f2b90-beb7-4748-94f1-8102fdca1dfe', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗12ms', null, null, '20161117', '111635');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('ea4a4f59-89af-4994-a29a-8c049e5e0a53', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗14ms', null, null, '20161117', '111925');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('bc594888-3f86-4c49-bf97-322597f431ca', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗15ms', null, null, '20161117', '112153');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('d1afec93-00bd-4934-be38-95009e748bcc', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '112219');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('1ca70bf5-f028-458b-8b42-fb3f1961ef23', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '112241');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('a468e8d7-7304-4afd-b26e-8e7a4ac17bdb', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '112443');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('963310e2-ed88-4415-a391-0dd1726a776b', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '112524');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('7957a7ae-632f-4b2c-afe4-692d98d185ea', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '112528');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('2cd12b6a-62af-4b01-97f3-f8260964227c', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗163ms', null, null, '20161117', '112534');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('10bd8479-65e0-4807-a81a-c3d7e77f80ba', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗13ms', null, null, '20161117', '112538');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('15512b80-4da7-4e92-84fd-417ac52bb7d8', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '112541');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('e1756fda-a512-4b5f-9ae2-f50497fc3bf4', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗13ms', null, null, '20161117', '112547');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('9d65f64e-adb6-4eac-8060-ea1bc857d402', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '112552');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('c139e867-4979-4cd4-bb9a-04d16efe9e31', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗6ms', null, null, '20161117', '113235');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('1e049fda-b16a-4606-8a42-d517b8abb936', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗89ms', null, null, '20161117', '122050');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('fd937767-e48d-4f0c-9b00-23de7b3d20de', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗10ms', null, null, '20161117', '122055');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('3b992ac5-d097-428d-83cb-086514465b51', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗9ms', null, null, '20161117', '122108');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('b95e516d-bfcd-4970-bab1-7366d1a1a575', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗8ms', null, null, '20161117', '133843');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('53ac895b-11de-40fc-b3fd-4cd732af90e7', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗136ms', null, null, '20161115', '112432');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('650908ef-e5ee-486e-badd-a8f40244ad64', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗35ms', null, null, '20161104', '093942');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('6c8559ee-7473-496b-8c98-a73c29abbf0c', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '169.254.81.209', null, '运行消耗17ms', null, null, '20161107', '095535');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('7a3a88b7-2a3c-4b78-8225-b70cf7a716df', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗31ms', null, null, '20161117', '092352');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('59d11817-69a5-40af-a5b0-b65e16ebba2b', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.1.167', null, '运行消耗10ms', null, null, '20161121', '142752');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('b7d580e1-5223-4489-9a13-c95d61d1e30d', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗105ms', null, null, '20161122', '100923');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('559999bd-39ba-45ed-bb83-29d518518076', '查询用户列表', 'com.topcheer.ybt.system.controller.TopUserController.getUserList()', '1', '192.169.2.172', 'java.lang.NullPointerException', '运行消耗7ms', null, null, '20161122', '103754');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('311a5e9a-24f8-40f8-a66f-b4f33831b6e0', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.168.5.1', null, '运行消耗13ms', null, '管理员', '20161123', '105658');
insert into TOP_LOG (ID, DESCRIPTION, METHOD, TYPE, REQUESTIP, EXCEPTIONCODE, EXECUTETIME, PARAMS, CREATEBY, CREATEDATE, CREATETIME)
values ('dc9e93f5-dd33-40e7-993c-b073357899a8', '查询用户列表信息', 'com.topcheer.ybt.system.service.impl.TopUserinfoServiceImpl.searchTopUserinfo()', '0', '192.169.2.172', null, '运行消耗6ms', null, '管理员', '20161124', '152748');
commit;
prompt 38 records loaded
prompt Loading TOP_MENUINFO...
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('975bcca2aa80449ea95a04638775ec06', '0', '移动端菜单', 'YBT_YD', null, '0', '20160701', '20160701', '103409', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234662a07ab71a3eb51665', '1004', '机构管理', '1', 'topBankinfo/turnToBankInfoList.do', '0', '20160701', '20161008', '170922', '0000', 'icon-user', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('5c71f6747bca498db9ea4efd83eecf05', '1', '系统管理', 'YBT', null, '0', '20160701', '20160701', '103428', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('bda0c017a1d844edb4cfc24c1125fd05', 'YBT', '后端菜单', '0', null, '0', '20160701', '20160701', '103350', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234652a07ab71a3eb51657', '1001', '用户管理', '1', 'user/turnToUserList.do', '0', '20160701', '20160701', '103551', '0000', 'icon-user', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('5c71f6747bca498db9ea4efd83eecf06', '2', '基础数据管理', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51660', '3', '合规管理', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51661', '4', '报表系统', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51662', '5', '运营管理', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51663', '6', '重控管理', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51664', '7', '实时出单', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51665', '8', 'JOB任务', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51666', '9', '服务管理', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51667', '8001', 'JOB查询、管理交易', '8', 'topJobList/turnToJobListInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51668', '8002', 'JOB增加交易', '8', 'topAddJob/turnToAddJobInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51669', '8003', 'JOB结果查询交易', '8', 'topJobResult/turnToJobResultInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51670', '4001', '三号文监管报表', '4', 'topThrTextSupervision/turnToThrTextSupervisionInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51671', '4002', '网点销售台账', '4', 'topSalesledger/turnToSalesledgerInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51672', '4003', '出单费统计报表', '4', 'topSingleFeeReport/turnToSingleFeeReportInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51673', '4004', '手续费统计报表', '4', 'topHandlingFeeReport/turnToHandlingFeeReportInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51674', '5001', '开启日初', '5', 'topDayStart/turnToDayStartInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51675', '5002', '开启日终', '5', 'topDayEnd/turnToDayEndInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51676', '5003', '核心对账', '5', 'topCoreReconciliation/turnToCoreReconciliationInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51677', '5004', '日终清算报表下载', '5', 'topDownloadRefReport/turnToDownloadRefReportInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51678', '5005', '日终与保险公司对账', '5', 'topInsCorpReconciliation/turnToInsCorpReconciliationInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51679', '6001', '特殊凭证入库', '6', 'topCredenceInstock/turnToCredenceInstockInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51680', '6002', '特殊凭证出库', '6', 'topCredenceOutstock/turnToCredenceOutstockInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51681', '6003', '特殊凭证调拨', '6', 'topCredenceScheduling/turnToCredenceSchedulingInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51682', '6004', '特殊凭证作废', '6', 'topCredenceCancel/turnToCredenceCancelInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51683', '6005', '柜员特殊凭证状态查询', '6', 'topCredenceStatus/turnToCredenceStatusInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51684', '6006', '特殊凭证在途查询', '6', 'topCredOnPassage/turnToCredOnPassageInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51685', '7001', '新保承保', '7', 'topAuditSafety/turnToAuditSafetyInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51686', '7002', '处理未完成投保单', '7', 'topUnfinishedPolicy/turnToUnfinishedPolicyInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51687', '7003', '当日保单补打', '7', 'topRePrintPolicy/turnToRePrintPolicyInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51688', '7004', '当日业务受理单补打', '7', 'topServAccepForm/turnToServAccepFormInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51689', '7005', '当日撤单', '7', 'topCancelInsurance/turnToCancelInsuranceInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51690', '7006', '当日撤单凭证补打', '7', 'topRePrintCancellCert/turnToRePrintCancellCertInfo', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51691', '7007', '当日投保确认补打', '7', 'topRePrintConfirmIns/turnToRePrintConfirmInsInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51692', '7008', '绿灯交易', '7', 'topTrafficLights/turnToTrafficLightsInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('5c71f6747bca498db9ea4efd83eecf07', '10', '查询统计', 'YBT', null, '0', '20160926', '20160926', '134905', '0000', 'icon-group', null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51690', '10001', '营销人员资质查询', '10', 'topMarketerAptitude/turnToMarketerAptitudeInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51691', '10002', '交易明细查询', '10', 'topTransactionDetail/turnToTransactionDetailInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51692', '10003', '交易汇总查询', '10', 'topTransactionSummary/turnToTransactionSummaryInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51693', '10004', '营销人员绩效查询', '10', 'topMarketerPerformance/turnToMarketerPerformanceInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51694', '10005', '网点报表查询', '10', 'topDotReport/turnToDotReportInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51695', '10006', '保险公司查询', '10', 'topInsuranceCompany/turnToInsuranceCompanyInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51696', '10007', '保险产品查询', '10', 'topInsuranceProducts/turnToInsuranceProductsInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51697', '10008', '机构信息查询', '10', 'topBank/turnToBankInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51698', '10009', '保险产品电子资料', '10', 'topInsProElectronicInfo/turnToInsProElectronicInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51699', '10010', '代销保险公司及产品查询', '10', 'topDXBXCompAndPro/turnToDXBXCompAndPro.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51700', '10011', '客户持有保险产品查询', '10', 'topCusHandsProd/turnToCusHandsProdInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51701', '10012', '投保报错查询', '10', 'topInsuredExcep/turnToInsuredExcepInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('261da8853a234653a07ab71a3eb51702', '10013', '用户权限查询', '10', 'topUserPermission/turnToUserPermissionInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('12324324132423423423', '1005', '角色管理', '1', 'topRoleinfo/turnToRoleInfoList.do', '0', '20160701', '20160701', '103409', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('3124345234234233423423', '1006', '菜单管理', '1', 'topMenuinfo/turnToMenuInfoList.do', '0', '20160701', '20160701', '103409', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('10', '2001', '保险公司管理', '2', 'topInsCorpinfo/insCorpInfo.do', '0', '20160926', '20160926', '101702', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234652a07ab71a3eb51658', '2002', '手续费设置', '2', 'topAgentrate/turnToInsCommissionInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51658', '2003', '机构绑定保险公司', '2', 'topBankAndCrop/turnToTopBankAndCropInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('260da8853a234653a07ab71a3eb51659', '2004', '数据字典管理', '2', 'topBasicKind/turnToBasicKindInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('11', '2005', '保险产品管理', '2', 'topInsprdInfo/insPrdInfo.do', '0', '20160926', '20160926', '134905', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('4324', '1007', '日志管理', '1', 'log/toSysLog.do', '0', null, '20161111', '164006', '0000', null, null, null, null, null);
insert into TOP_MENUINFO (MENU_ID, MENU_CODE, MENU_NAME, UP_MENU_CODE, MENU_URL, STATUS, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, ICON, REMARK1, REMARK2, REMARK3, REMARK4)
values ('452345', '1008', 'Druid监控', '1', 'druid/index.html', '0', null, '20161111', '164001', '0000', null, null, null, null, null);
commit;
prompt 62 records loaded
prompt Loading TOP_ROLEINFO...
insert into TOP_ROLEINFO (ROLE_ID, ROLE_CODE, ROLE_NAME, STATUS, DESCRIPTION, CREATE_DATE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, REMARK1, REMARK2, REMARK3, REMARK4)
values ('1db8d466a1f1458789fb6b031f4a3f10', '1', '管理员', '0', null, '20160906', '20160906', '103232', null, null, null, null, null);
commit;
prompt 1 records loaded
prompt Loading TOP_MENU_ROLE...
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('56b2127984234e3eac0ead7baf82aedf', '1db8d466a1f1458789fb6b031f4a3f10', 'bda0c017a1d844edb4cfc24c1125fd05');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('730eb2210d1c45efac2ea3fb2286b8ca', '1db8d466a1f1458789fb6b031f4a3f10', '5c71f6747bca498db9ea4efd83eecf05');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('c7d2c61a86044ed9a95539ff56904944', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234662a07ab71a3eb51665');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('86ba4149fe3944b7838408bccad88873', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234652a07ab71a3eb51657');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('d652bcf20f8c4a86bb4c9dd7ca5cfac1', '1db8d466a1f1458789fb6b031f4a3f10', '12324324132423423423');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('506a61e7d7a242b4b7df6a4394f076e1', '1db8d466a1f1458789fb6b031f4a3f10', '3124345234234233423423');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('4881d05df6a844d2923cf34ad522c5fa', '1db8d466a1f1458789fb6b031f4a3f10', '4324');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('3497b42b23cb44f09b9236dbba8a0d6a', '1db8d466a1f1458789fb6b031f4a3f10', '452345');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('323865e469b64f18a8f988ccf3f03462', '1db8d466a1f1458789fb6b031f4a3f10', '5c71f6747bca498db9ea4efd83eecf06');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('a0a7c4bccb5d4ac696a1d0e524a307cc', '1db8d466a1f1458789fb6b031f4a3f10', '10');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('f9ed8b21bbc14615b5bc40add5370839', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234652a07ab71a3eb51658');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('6e754f42e04d4a4dadb9622ddfce643d', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51658');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('3716cf11075b4468b5ef0c857748c9ea', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51659');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('df55ec23897f4fe28975953953d285a1', '1db8d466a1f1458789fb6b031f4a3f10', '11');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('a63a5241d20942549e80d1375b75a9ed', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51660');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('4189b5c049fe49d68c9047f854f84b84', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51661');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('aac5f5d9d0744d52bf73dd79c18a3b15', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51670');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('c1227d7e2bf34a9d82ee4aa077d5fadf', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51671');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('90a36f0831ad4fc480200ed6a0e1034b', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51672');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('9f950127e16d40ed822ef3154f377bcf', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51673');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('cef877aa46074f789bad692527844c95', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51662');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('ae6d85cddc984deaac36d7d55dc3ec65', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51674');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('67f87953481846b9ae8630fa8ed63c41', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51675');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('4e45012f30214c70875eee4b3b390041', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51676');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('a3fe9833a1eb4481b7679c39f144ee77', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51677');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('457baf0d7aca4a64ac34dcd068aa3c21', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51678');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('d5d13cc58ee0449cbcffdd6ee38e4cc2', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51663');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('1adf14ea34df4b859d3974530e37dc95', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51679');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('9d42cc1a0e4d45a2a8bb844d3265e6d2', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51680');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('f2fb2e4d48c3428191e3849f5484a1ed', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51681');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('45c5437fb7b3494bbae422be882fcf72', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51682');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('a0c6d5fcd97c4aabbef27dee9bf7148a', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51683');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('570dcbce346648608f97a966f038c896', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51684');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('fda64380aa87485980a2525e108361ac', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51664');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('31c0980707db4d9e87ee43e0be268076', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51685');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('9d7f91432d374ad08c2e83cac0be4469', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51686');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('2f66b459b209427980814d9036f14a80', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51687');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('e5d61c1a6f31465b8fd534a21fe7becf', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51688');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('035ca2bb142444a38a55a7fd6638a101', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51689');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('5106c8933ba3476ab92fb2f7f700e095', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51690');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('3b6b495ee93e4aacb27d8265991fd26a', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51691');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('c3a67bbf69ba41f79b6ca73fccd5b92c', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51692');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('51522f835e3f4b299241754ebce97cbe', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51665');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('686e8305f2034351be0af6c2a83a21f7', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51667');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('3e517f2c1dbf41438a7ca0e7eac1f61d', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51668');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('f3095b4fe7524b11aa2c7418a5032b81', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51669');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('4fa6a0dc88c24313be942d399c3a5a48', '1db8d466a1f1458789fb6b031f4a3f10', '260da8853a234653a07ab71a3eb51666');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('84cba76fb6134004982af762207ae07f', '1db8d466a1f1458789fb6b031f4a3f10', '5c71f6747bca498db9ea4efd83eecf07');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('68b98baddd344764831f51aebeecd981', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51690');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('dd58feedb33d45d292a24763b2ee0cf0', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51691');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('5392d8cd031d43bda02a060ad2485bb0', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51692');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('fd5ceb1b1b534d43af2706898f132eab', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51693');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('5ccdca679df244c699320f6e5f9bb320', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51694');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('c483de09d6334adba777c21121c11a83', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51695');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('78a466d0f72f46c6848fa6da5621722d', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51696');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('144cdf98b9944336aed320cf65bf6e7f', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51697');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('338a134640154118a355be91b7091597', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51698');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('4633518bfb7147ceb2856e1cd681912d', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51699');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('ba6b00819aa4438190a0caf872c18ba5', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51700');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('b6f7310f2b54434289c5b8e15fc74574', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51701');
insert into TOP_MENU_ROLE (ID, ROLE_ID, MENU_ID)
values ('14be787bafb14475b5ddb2d8e0a6b37c', '1db8d466a1f1458789fb6b031f4a3f10', '261da8853a234653a07ab71a3eb51702');
commit;
prompt 61 records loaded
prompt Loading TOP_PAYPERIOD...
insert into TOP_PAYPERIOD (ID, INSPRD_CODE, KEY, UNIT)
values ('1', '28000001', '5', '0');
insert into TOP_PAYPERIOD (ID, INSPRD_CODE, KEY, UNIT)
values ('2', '28000001', '10', '0');
insert into TOP_PAYPERIOD (ID, INSPRD_CODE, KEY, UNIT)
values ('4', '28000001', '15', '0');
commit;
prompt 3 records loaded
prompt Loading TOP_PAYTYPE...
insert into TOP_PAYTYPE (ID, INSPRD_CODE, KEY, VALUE)
values ('1', '28000001', '4', '4');
insert into TOP_PAYTYPE (ID, INSPRD_CODE, KEY, VALUE)
values ('2', '28000001', '1', '1');
commit;
prompt 2 records loaded
prompt Loading TOP_PHINFO...
prompt Table is empty
prompt Loading TOP_RNINFO...
prompt Table is empty
prompt Loading TOP_USERINFO...
insert into TOP_USERINFO (USER_ID, LOGIN_ACCOUNT, LOGIN_PWD, USER_NAME, USER_STATUS, USER_DEPT, CREATE_DATE, OPERATOR_PHONE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, FILE_PATH, REMARK1, REMARK2, REMARK3, REMARK4)
values ('9ee9cfe8c489490795fa056d3ed7be3a', '000000', '111111', '管理员', '0', '9901', '20160906', null, '20160906', '103232', null, null, null, null, null, null);
insert into TOP_USERINFO (USER_ID, LOGIN_ACCOUNT, LOGIN_PWD, USER_NAME, USER_STATUS, USER_DEPT, CREATE_DATE, OPERATOR_PHONE, UPDATE_DATE, UPDATE_TIME, UPDATE_OPERATOR, FILE_PATH, REMARK1, REMARK2, REMARK3, REMARK4)
values ('d2b171ecab5140d580d75c17d42f97c7', '33', '111111', '43', '0', null, '20161011', null, '20161117', '122107', '000000', null, null, null, null, null);
commit;
prompt 2 records loaded
prompt Loading TOP_USER_ROLE...
insert into TOP_USER_ROLE (ID, ROLE_ID, USER_ID, CREATE_DATE, UPDATE_DATE)
values ('671bd1cb413b4f8fb970fa910f9fdfe0', '1db8d466a1f1458789fb6b031f4a3f10', '9ee9cfe8c489490795fa056d3ed7be3a', '20161117', '20161117');
commit;
prompt 1 records loaded
prompt Enabling foreign key constraints for TOP_MENU_ROLE...
alter table TOP_MENU_ROLE enable constraint FK_TOP_MENU_REFERENCE_TOP_MENU;
alter table TOP_MENU_ROLE enable constraint FK_TOP_MENU_REFERENCE_TOP_ROLE;
prompt Enabling foreign key constraints for TOP_USER_ROLE...
alter table TOP_USER_ROLE enable constraint FK_TOP_USER_REFERENCE_TOP_ROLE;
alter table TOP_USER_ROLE enable constraint FK_TOP_USER_REFERENCE_TOP_USER;
prompt Enabling triggers for TOP_AGENTRATE...
alter table TOP_AGENTRATE enable all triggers;
prompt Enabling triggers for TOP_BANKANDCORP...
alter table TOP_BANKANDCORP enable all triggers;
prompt Enabling triggers for TOP_BANKINFO...
alter table TOP_BANKINFO enable all triggers;
prompt Enabling triggers for TOP_BANKINS...
alter table TOP_BANKINS enable all triggers;
prompt Enabling triggers for TOP_BASICKIND...
alter table TOP_BASICKIND enable all triggers;
prompt Enabling triggers for TOP_BFYINFO...
alter table TOP_BFYINFO enable all triggers;
prompt Enabling triggers for TOP_BUYINFO...
alter table TOP_BUYINFO enable all triggers;
prompt Enabling triggers for TOP_BUYINFOADD...
alter table TOP_BUYINFOADD enable all triggers;
prompt Enabling triggers for TOP_INSCORPINFO...
alter table TOP_INSCORPINFO enable all triggers;
prompt Enabling triggers for TOP_INSPRDINFO...
alter table TOP_INSPRDINFO enable all triggers;
prompt Enabling triggers for TOP_INSPRDPERIOD...
alter table TOP_INSPRDPERIOD enable all triggers;
prompt Enabling triggers for TOP_LOG...
alter table TOP_LOG enable all triggers;
prompt Enabling triggers for TOP_MENUINFO...
alter table TOP_MENUINFO enable all triggers;
prompt Enabling triggers for TOP_ROLEINFO...
alter table TOP_ROLEINFO enable all triggers;
prompt Enabling triggers for TOP_MENU_ROLE...
alter table TOP_MENU_ROLE enable all triggers;
prompt Enabling triggers for TOP_PAYPERIOD...
alter table TOP_PAYPERIOD enable all triggers;
prompt Enabling triggers for TOP_PAYTYPE...
alter table TOP_PAYTYPE enable all triggers;
prompt Enabling triggers for TOP_PHINFO...
alter table TOP_PHINFO enable all triggers;
prompt Enabling triggers for TOP_RNINFO...
alter table TOP_RNINFO enable all triggers;
prompt Enabling triggers for TOP_USERINFO...
alter table TOP_USERINFO enable all triggers;
prompt Enabling triggers for TOP_USER_ROLE...
alter table TOP_USER_ROLE enable all triggers;
set feedback on
set define on
prompt Done.
