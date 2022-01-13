show tables;
desc emaillist;

-- CREATE 
INSERT into emaillist values(null, '둘','리','dooly@gmail.com');
INSERT into emaillist values(null, '루','피','loofy@gmail.com');

-- INSERT 
select no, first_name, last_name, email FROM emaillist ORDER BY NO desc;