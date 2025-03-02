create table GAKSE(
GAKSE_NUM varchar2(15) not null primary key,
GAKSE_PW varchar2(20) not null,
GAKSE_NAMAE varchar2(10) not null,
GAKSE_MYNUM varchar2(14) not null,
GAKSE_DENWA varchar2(15) not null,
GAKSE_MAIL varchar2(50) not null,
GAKSE_NYUGAKU varchar2(20),
GAKSE_GAKUNEN varchar2(1) not null,
GAKSE_SENKO varchar2(50) not null,
GAKSE_STATE int,
GAKSE_GUNTAI int);

create table STAFF(
STAFF_ID varchar2(12) not null primary key,
STAFF_PW varchar2(20) not null,
STAFF_NAMAE varchar(10) not null,
STAFF_DENWA varchar(15) not null,
STAFF_KUBETU int not null);

create table BOARD(
BD_NUM int not null primary key,
WRITER_ID varchar2(15) not null,
WRITER_NAMAE varchar2(10) not null,
BD_TITLE varchar2(255) not null,
BD_KUBETU int not null,
BD_ADDDATE date not null,
BD_COUNT int not null);

create table BOARD_CONTENT(
BD_NUM int not null primary key,
CONTENT long);

CREATE SEQUENCE board_seq
INCREMENT BY 1;

CREATE table SEISEKI(
JYUNBAN number(5,0) not null primary key,
GAKSE_NUM varchar2(15) not null,
NENDO Number(2,0) not null,
GAKKI number(1,0) not null,
SINSEI number(2,0) not null,
SHUDOKU number(2,0) not null,
HEIKIN number(2 ,2) not null
);

CREATE SEQUENCE SEISEKI_seq
INCREMENT BY 1;

CREATE table SHOUGAKU(
JYUNBAN number(5,0) not null primary key,
GAKSE_NUM varchar2(15) not null,
NENDO Number(2,0) not null,
GAKKI number(1,0) not null,
SHOU_NAMAE varchar2(50) not null
);

CREATE SEQUENCE SHOUGAKU_seq
INCREMENT BY 1;

CREATE table SIDOU(
JYUNBAN number(5,0) not null primary key,
GAKSE_NUM varchar2(15) not null,
NENDO Number(2,0) not null,
GAKKI number(1,0) not null,
KYOUJYU varchar2(50) not null
);

CREATE SEQUENCE SIDOU_seq
INCREMENT BY 1;

CREATE table LECTURE(
CODE VARCHAR2(6) not null primary key,
NAMAE VARCHAR2(50) not null,
GAKUNEN NUMBER(1,0) not null,
TANI NUMBER(1,0) not null,
KUBETU NUMBER(1,0) not null,
KYOUJYU VARCHAR2(50) not null
);

CREATE table LECTURE_IN(
CODE VARCHAR2(6) not null,
GAKSE_NUM varchar2(15) not null
);