drop table if exists HoursWorked;
drop table if exists WorkingSchedule;
drop table if exists Employee;
drop table if exists EmployeeType;

create table EmployeeType(
    etid int auto_increment primary key,
    tName varchar(50) unique
);

create table Employee(
    empID int auto_increment primary key,
    firstName varchar(50),
    lastName varchar(50),
    phoneNumber varchar(20),
    employeeType varchar(50),
    foreign key(employeeType) references EmployeeType(tName)
);

create table WorkingSchedule(
    scheduleID int auto_increment primary key,
    monmorn varchar(50),
    monnoon varchar(50),
    monaft varchar(50),
    tuesmorn varchar(50),
    tuesnoon varchar(50),
    tuesaft varchar(50),
    wedmorn varchar(50),
    wednoon varchar(50),
    wedaft varchar(50),
    thursmorn varchar(50),
    thursnoon varchar(50),
    thursaft varchar(50),
    frimorn varchar(50),
    frinoon varchar(50),
    friaft varchar(50),
    employeeID int,
    foreign key(employeeID) references Employee(empID)
);

create table HoursWorked(	
    employeeID int,
    date varchar(50),
    hours_worked double,
    primary key(employeeID, date),
    foreign key(employeeID) references Employee(empID)
);

select * from EmployeeType;
select * from Employee;
select * from WorkingSchedule;
select * from HoursWorked;
