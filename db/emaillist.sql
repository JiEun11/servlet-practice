show databases;

-- db 생성
CREATE database webdb;

-- user 생성
CREATE USER 'webdb'@'localhost' identified by 'webdb';

-- 권한 부여 
GRANT all privileges on webdb.* to 'webdb'@'localhost';

show tables;
desc emaillist;

-- CREATE , insert
INSERT into emaillist values(null, '둘','리','dooly@gmail.com');
INSERT into emaillist values(null, '루','피','loofy@gmail.com');

-- select 
select no, first_name, last_name, email FROM emaillist ORDER BY NO desc;

-- DELETE
DELETE from emaillist where no = 4; 