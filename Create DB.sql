Create Table Security_level
(
level_number int NOT NULL DEFAULT 1 UNIQUE,
employee bit NOT NULL DEFAULT 0,
customer bit NOT NULL DEFAULT 0,
booking bit NOT NULL DEFAULT 0,
room bit NOT NULL DEFAULT 0,
[statistics] bit NOT NULL DEFAULT 0,
archive bit NOT NULL DEFAULT 0,
invoice bit NOT NULL DEFAULT 0,
CONSTRAINT SEC_PK
PRIMARY KEY (level_number),
);

Create Table Department
(
department_number int NOT NULL DEFAULT 1 UNIQUE,
name VARCHAR(15) NOT NULL UNIQUE,
number_of_employees int,
mssn int NULL,
CONSTRAINT DEP_PK
PRIMARY KEY (department_number),
);

Create Table Customer_type
(
[type_name] VARCHAR(15) NOT NULL DEFAULT 'Standard' UNIQUE,
type_number int NOT NULL DEFAULT 1 UNIQUE,
CONSTRAINT CUSTYP_PK
PRIMARY KEY (type_number),
);

Create Table Room_type
(
[type_name] VARCHAR(15) NOT NULL DEFAULT 'single' UNIQUE,
price float NOT NULL,
capacity int NOT NULL DEFAULT 1,
CONSTRAINT ROOTYP_PK
PRIMARY KEY ([type_name]),
);

Create table Employee
(
username VARCHAR(20) NOT NULL UNIQUE,
[password] VARCHAR(20) NOT NULL,
security_level int NOT NULL DEFAULT 2,
name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL,
gender VARCHAR(10) NOT NULL,
country VARCHAR(30) NOT NULL,
city VARCHAR(30) NOT NULL,
street VARCHAR(30) NOT NULL,
zip_code VARCHAR(15) NOT NULL,
contact VARCHAR(30) NOT NULL,
salary float,
employed_since VARCHAR(20) NOT NULL,
contract_type VARCHAR(10) NOT NULL DEFAULT 'basic',
ssn int NOT NULL DEFAULT 000000 UNIQUE,
department_number int NOT NULL DEFAULT 1,
CONSTRAINT EMP_PK
PRIMARY KEY (username),
CONSTRAINT EMP_DEP_FK
FOREIGN KEY (department_number) REFERENCES DEPARTMENT(department_number)
ON DELETE SET DEFAULT ON UPDATE CASCADE,
CONSTRAINT EMP_SEC_FK
FOREIGN KEY (security_level) REFERENCES
SECURITY_LEVEL (level_number)
ON DELETE SET DEFAULT ON UPDATE CASCADE
);

Create Table Customer
(
username VARCHAR(20) NOT NULL UNIQUE,
[password] VARCHAR(20) NOT NULL,
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
customer_type VARCHAR(15) NOT NULL,
gender VARCHAR(10) NOT NULL,
country VARCHAR(30) NOT NULL,
city VARCHAR(30) NOT NULL,
street VARCHAR(30) NOT NULL,
zip_code VARCHAR(10) NOT NULL,
contact VARCHAR(40) NOT NULL,
CONSTRAINT CUS_PK
PRIMARY KEY (username),
CONSTRAINT CUS_CUSTYP_FK
FOREIGN KEY (customer_type) REFERENCES Customer_type ([type_name])
);

Create Table Rooms
(
room_number int NOT NULL UNIQUE,
capacity int NOT NULL DEFAULT 1,
CONSTRAINT ROO_PK
PRIMARY KEY (room_number),
);

Create table Rates
(
name VARCHAR(20) NOT NULL UNIQUE,
breakfast bit NOT NULL DEFAULT 0,
lunch bit NOT NULL DEFAULT 0,
dinner bit NOT NULL DEFAULT 0,
CONSTRAINT RAT_PK
PRIMARY KEY (name),
);

Create Table Booking
(
id int NOT NULL IDENTITY(1,1),
customer_username VARCHAR(20) NOT NULL,
employee_username VARCHAR(20) NOT NULL,
booked_from date NOT NULL,
booked_til date NOT NULL,
room_number int NOT NULL,
room_type VARCHAR(15) NOT NULL,
rates VARCHAR(20) NOT NULL,
number_of_people int NOT NULL,
checked_in date NULL DEFAULT null,
discount int NULL DEFAULT 0,
CONSTRAINT BOO_PK
PRIMARY KEY (id),
CONSTRAINT BOO_CUS_FK
FOREIGN KEY (customer_username) REFERENCES Customer (username),
CONSTRAINT BOO_EMP_FK
FOREIGN KEY (employee_username) REFERENCES Employee (username),
CONSTRAINT BOO_ROO_FK
FOREIGN KEY (room_number) REFERENCES Rooms(room_number)
ON UPDATE CASCADE,
CONSTRAINT BOO_ROOTYP_FK
FOREIGN KEY (room_type) REFERENCES Room_type([type_name]),
CONSTRAINT BOO_RAT_FK
FOREIGN KEY (rates) REFERENCES Rates(name),
);

Create table invoice
(
id int NOT NULL IDENTITY(1,1),
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
employee VARCHAR(30) NOT NULL,
price float NOT NULL,
payment_type VARCHAR(30) NOT NULL,
payment_deadline VARCHAR(30) NOT NULL,
paid bit NOT NULL default 0,
payment_overdue bit NOt NULL default 0,
CONSTRAINT pki
PRIMARY KEY(id),
)

Create table archive
(
id int NOT NULL IDENTITY(1,1),
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
country VARCHAR(30) NOT NULL,
city VARCHAR(30) NOT NULL,
street VARCHAR(30) NOT NULL,
zip_code VARCHAR(10) NOT NULL,
contact VARCHAR(40) NOT NULL,
booked_from date NOT NULL,
booked_til date NOT NULL,
checked_in date NOT NULL,
checked_out date NOT NULL,
room_number int NOT NULL,
CONSTRAINT pk
PRIMARY KEY(id),
)