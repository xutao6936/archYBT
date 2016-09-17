alter table TOP_MENU_ROLE
   drop constraint FK_TOP_MENU_REFERENCE_TOP_ROLE;

alter table TOP_MENU_ROLE
   drop constraint FK_TOP_MENU_REFERENCE_TOP_MENU;

alter table TOP_USER_ROLE
   drop constraint FK_TOP_USER_REFERENCE_TOP_ROLE;

alter table TOP_USER_ROLE
   drop constraint FK_TOP_USER_REFERENCE_TOP_USER;

alter table TOP_BANKINFO
   drop primary key cascade;

drop table TOP_BANKINFO cascade constraints;

alter table TOP_MENUINFO
   drop primary key cascade;

drop table TOP_MENUINFO cascade constraints;

alter table TOP_MENU_ROLE
   drop primary key cascade;

drop table TOP_MENU_ROLE cascade constraints;

alter table TOP_ROLEINFO
   drop primary key cascade;

drop table TOP_ROLEINFO cascade constraints;

alter table TOP_USERINFO
   drop unique (LOGIN_ACCOUNT) cascade;

alter table TOP_USERINFO
   drop primary key cascade;

drop table TOP_USERINFO cascade constraints;

alter table TOP_USER_ROLE
   drop primary key cascade;

drop table TOP_USER_ROLE cascade constraints;

drop sequence SEQ_MENU;

drop sequence SEQ_ROLE;
