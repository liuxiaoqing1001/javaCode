-- Create table
create table TB_USER2
(
  id       NUMBER not null,
  username VARCHAR2(40),
  userpass VARCHAR2(40),
  email    VARCHAR2(40),
  active   NUMBER(1) default 0
) ;
-- Create/Recreate primary, unique and foreign key constraints 
alter table TB_USER2
  add constraint PK_ID primary key (ID);
-- 
create sequence seq_user2 ;
   -- 3£©´´½¨´¥·¢Æ÷
create or replace trigger tri_insert_user2
       before insert
       on tb_user2
       for each row
begin
  select seq_user2.nextval into :new.id from dual;
end ;

