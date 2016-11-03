/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/11/3 10:12:40                           */
/*==============================================================*/


drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  int(40) not null auto_increment,
   name                 varchar(40) not null,
   age                  int(3) not null,
   gender               bit(1) not null,
   head_portrait        varchar(256),
   phone                varchar(40),
   address              varchar(256),
   type                 int(1) not null,
   account              varchar(40) not null,
   password             varchar(256),
   primary key (uid),
   unique key AK_Key_2 (account)
);

