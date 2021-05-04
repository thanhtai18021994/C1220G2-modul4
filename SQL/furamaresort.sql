drop database if exists case_study;
create database case_study;
use case_study;

create table position (
position_id int primary key auto_increment,
position_name varchar(45));

create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45));

create table division(
division_id int primary key auto_increment,
division_name varchar(45));

create table `role`(
role_id int primary key,
role_name varchar(255));

create table `user`(
username varchar(255) primary key,
`password` varchar(255));

create table user_role(
role_id int,
username varchar(255),
primary key(role_id,username));

create table employee(
employee_id int primary key auto_increment,
employee_mnv varchar(50) unique,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(50),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_adress varchar(45),
position_id int ,
education_degree_id int,
division_id int,
username varchar(255));

create table customer(
customer_id int primary key auto_increment ,
customer_mkh varchar(50) unique,
customer_type_id int,
customer_name varchar(45),
customer_birthday date,
customer_gender int,
custumer_id_card varchar(45),
customer_phone varchar(45),
custumer_email varchar(45),
customer_address varchar(45));

create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45));

create table service_type(
service_type_id int primary key,
service_type_name varchar(45));

create table contract(
contract_id int primary key,
contract_mhd varchar(50),
contract_start_date datetime,
contract_end_date datetime,
contract_deposit double,
contract_total_money double,
employee_id int ,
custumer_id int,
service_id int);

create table attach_service(
attach_service_id int primary key,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45));

create table contract_detail(
contract_detail_id int primary key,
contract_id int,
attach_service_id int,
quantity int);

create table service(
service_id int primary key,
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
rent_type_id int,
service_type_id int,
standard_room varchar(45),
description_other_convinience varchar(45),
pool_area double,
number_of_floor int);

create table rent_type(
rent_type_id int primary key,
rent_type_name varchar(45),
rent_type_cost double);

alter table employee
add foreign key(position_id) references position (position_id),
add foreign key(education_degree_id) references education_degree (education_degree_id),
add foreign key(division_id) references division (division_id),
add foreign key(username) references `user`(username);

alter table user_role
add foreign key(username) references `user`(username),
add foreign key(role_id) references `role` (role_id);

alter table contract
add foreign key(employee_id) references employee(employee_id),
add foreign key(custumer_id) references customer(customer_id),
add foreign key(service_id) references service(service_id);

alter table contract_detail
add foreign key(contract_id) references contract(contract_id),
add foreign key(attach_service_id) references attach_service(attach_service_id);

alter table customer
add foreign key(customer_type_id) references customer_type(customer_type_id);

alter table service
add foreign key(rent_type_id) references service_type(service_type_id),
add foreign key(rent_type_id) references rent_type(rent_type_id);

insert into customer_type(customer_type_name)
values
("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("member");

insert into customer(customer_mkh,customer_type_id,customer_name,customer_birthday,customer_gender,custumer_id_card,customer_phone,custumer_email,customer_address)
values
("KH-001",1,"Bui Thanh Tai","2012-12-12",1,"191830363","0775562914","taibuo18021994@gmail.com","Da Nang"),
("KH-002",2,"Duong Quang Kha","1994/02/18",0,"191845673","0885567213","duongcaca@gmail.com","Hue"),
("KH-003",1,"Nguyen Huy","1992/12/03",1,"1981223224","077656312","huynguye1992@codegym.com","Quang Nam");

insert into position (position_name)
values
("Lễ tân"),("phục vụ"),("chuyên viên"),("giám sát"),("quản lý"),("giám đốc");

insert into division (division_name)
values
("Sale – Marketing"),("Hành Chính"),("Phục vụ"),("Quản lý");

insert into education_degree(education_degree_name)
values
("Trung cấp"),("Cao đẳng"),("Đại học"),("Sau đại học");
insert into `user`
values
("taibui","hoahuongduong"),("hauhoang","bodien123"),("bachlao","tiende342");
insert into employee (employee_mnv,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_adress,position_id,education_degree_id,division_id,username)
values
("NV-001","Bùi Thành Huy","1992-02-18","191830363",1000,"0911111112","huybui18021994@gmail.com","Đà Nẵng",2,1,3,"taibui"),
("NV-002","Bùi Thành Công","1992-07-10","191830364",700,"0911111113","congbui18021994@gmail.com","Đà Nẵng",1,3,2,"taibui"),
("NV-003","Bùi Thành Hậu","1994-02-18","191830365",400,"0911111111","taibui18021994@gmail.com","Đà Nẵng",3,2,1,"taibui");

insert  into service

delimiter //
create procedure addNewCustumer(
customer_mkh varchar(50),
customer_type_id int,
customer_name varchar(45),
customer_birthday date,
customer_gender int,
custumer_id_card varchar(45),
customer_phone varchar(45),
custumer_email varchar(45),
customer_address varchar(45))
begin
insert into customer (customer_mkh,customer_type_id,customer_name,customer_birthday,customer_gender,custumer_id_card,customer_phone,custumer_email,customer_address)
values(customer_mkh,customer_type_id,customer_name,customer_birthday,customer_gender,custumer_id_card,customer_phone,custumer_email,customer_address);
end;
// delimiter ;
 call addNewCustumer("KH-004",1,"Dương ngọc thái","1995-04-05",1,"191830363","0911111111","taibuo18021994@gmail.com","Đà nẵng");
delimiter //
create procedure displayListCustomer()
begin
select*
from customer;
end;
// delimiter ;


delimiter //
create procedure updateCustomer(
customer_mkh2 varchar(50),
customer_type_id int,
customer_name varchar(45),
customer_birthday date,
customer_gender int,
custumer_id_card varchar(45),
customer_phone varchar(45),
custumer_email varchar(45),
customer_address varchar(45))
begin
update customer
set customer_mkh=customer_mkh,customer_type_id=customer_type_id,customer_name=customer_name,customer_birthday=customer_birthday,customer_gender=customer_gender,custumer_id_card=custumer_id_card,customer_phone=customer_phone,custumer_email=custumer_email,customer_address=customer_address
where customer_mkh=customer_mkh2;
end;
// delimiter ;

call updateCustomer("KH-003",2,"Nguyen Huy","1992/12/03",1,"1981223224","077656312","huynguye1992@codegym.com","Quang Nam");
delimiter //
create procedure deleteCustomer(id varchar(50))
begin
delete from customer
where customer_mkh=id;
end;
// delimiter ;

 delimiter //
 create procedure findCustomerById(mkh varchar(50))
 begin
 select* 
 from customer
 where customer_mkh=mkh;
 end;
 // delimiter ;

 delimiter //
 
 create procedure searchCustomer(stringText varchar(50))
 begin
 select *
 from customer
 where (customer_name like concat("%",stringText,"%"))  or (customer_address like concat("%",stringText,"%"));
 end;
 // delimiter ;
 
call searchCustomer("a");
delimiter //
create procedure displayListEmployee()
begin
select e.employee_mnv,e.employee_name,e.employee_birthday,e.employee_id_card,e.employee_salary,e.employee_phone,e.employee_email,e.employee_adress,p.position_name,d.division_name,ed.education_degree_name,`user`.username
from (((employee e left join division d on e.division_id=d.division_id)
left join position p on e.position_id=p.position_id)
left join education_degree ed on ed.education_degree_id=e.education_degree_id)
left join `user` on `user`.username=e.username ;
end;
// delimiter ;

delimiter //
create procedure insertEmployee(
employee_mnv varchar(50),
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(50),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_adress varchar(45),
position_name2 varchar(50) ,
education_degree_name2 varchar(50),
division_name2 varchar(50))
begin
set @position_id=(
select position_id from position
where position_name=position_name2);

set @division_id=(
select division_id
from division
where division_name=division_name2);
set @education_degree_id=(
select education_degree_id
from education_degree
where education_degree_name=education_degree_name2);
insert into employee (employee_mnv,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_adress,position_id,education_degree_id,division_id)
values
(employee_mnv,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_adress,@position_id,@education_degree_id,@division_id);
end ;
// delimiter ;

call insertEmployee("NV-006","Nguyễn ngọc ngạn","1994-02-14","191830363",400,"0911123123","taibuui1801299@gmail.com","Đà Thành","Lễ tân","Trung cấp","Quản lý");

delimiter //
create procedure updatetEmployee(
employee_mnv2 varchar(50),
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(50),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_adress varchar(45),
position_name2 varchar(50) ,
education_degree_name2 varchar(50),
division_name2 varchar(50))
begin
set @position_id2=(
select position_id from position
where position_name=position_name2 );

set @division_id=(
select division_id
from division
where division_name=division_name2);

set @education_degree_id=(
select education_degree_id
from education_degree
where education_degree_name=education_degree_name2);

update employee 
set employee_name=employee_name,employee_birthday=employee_birthday,employee_id_card=employee_id_card,employee_salary=employee_salary,employee_phone=employee_phone,employee_email=employee_email,employee_adress=employee_adress,position_id=@position_id,education_degree_id=@education_degree_id,division_id=@division_id
where employee_mnv=employee_mnv2;
end ;
// delimiter 

delimiter //

create procedure divisionName()
begin
select division_name from division;
end;
// delimiter ;
call divisionName();

delimiter //
create procedure degreeName()
begin
select education_degree_name  from education_degree;
end;
// delimiter ;

delimiter //
create procedure positionName()
begin
select position_name  from position;
end;
// delimiter ;

-- alter table contract
-- add mhd varchar(50) after contract_id;

delimiter \\
create procedure search(text1 varchar(50),text2 varchar(50),text3 varchar(50))
begin
select * from employee
where employee_name like concat("%",text1,"%") and employee_email like concat("%",text2,"%") and employee_adress like concat("%",text3,"%");
end;
\\ delimiter ;
 call search("H","t","");










