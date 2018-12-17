drop table if exists student;
create table student(
  id int primary key auto_increment,
  name varchar(10),
  age int,
  sex varchar(10)
);

INSERT INTO student values(0,23,'feng','男');
insert into student values(1,23,'hui','男');
insert into student values(2,24,'qiao','男');