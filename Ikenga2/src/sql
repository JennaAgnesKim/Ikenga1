--5월 23일 김재나,김정헌

--테이블 삭제
drop table auction;
drop table product;
drop table client;

-- 시퀀스 삭제
drop sequence auction_seq;
drop sequence product_seq;
drop sequence client_seq;

-- 시퀀스 생성
create sequence client_seq start with 1000000;
create sequence auction_seq start with 10000; 
create sequence product_seq;

--테이블 생성
create table client(
   client_no number primary key,
   email varchar(200) not null,
   name varchar(100) not null,
   pw varchar(100) not null,
   category varchar(200) not null,
   bank varchar(200) not null,
   account varchar(200) not null
);

create table product(
   product_no number primary key,
   pname varchar(100) not null,
   category varchar(100) not null,
   min_price number not null,
   client_no number,
   constraint client_client_no_fk
   foreign key(client_no)
   references client(client_no),
   description varchar(4000) not null
);

create table auction(
   auction_no number primary key,
   product_no number not null,
   constraint product_product_no_fk
   foreign key (product_no)
   references product(product_no),
   client_no not null,
   constraint  auction_no_fk
   foreign key (client_no)
   references client(client_no),
   min_price number not null,
   start_date date default sysdate,
   end_date date default sysdate+5,
   max_price number default 0,
   winner number default 0
);

col email format a30;
col name format a20;
col pw format a20;
col bank format a20;
col account format a20;
col category format a30;

col pname foramt a20;
col description format a30;