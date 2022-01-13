show tables;
desc emaillist;

-- CREATE , insert
INSERT into emaillist values(null, '둘','리','dooly@gmail.com');
INSERT into emaillist values(null, '루','피','loofy@gmail.com');

-- select 
select no, first_name, last_name, email FROM emaillist ORDER BY NO desc;

-- DELETE
DELETE from emaillist where no = 4; 