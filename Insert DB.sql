INSERT INTO Security_level
VALUES (1, 1, 1, 1, 1, 1)

INSERT INTO Security_level
VALUES (2, 0, 0, 1, 1, 0)

INSERT INTO Department
VALUES(1, 'Housekeeping', 0,0)

INSERT INTO Department
VALUES(2, 'Sales', 0,0)

INSERT INTO Department
VALUES(3, 'Finance', 0,0)

INSERT INTO Department
VALUES(4, 'Marketing', 0,0)

INSERT INTO Department
VALUES(5, 'Food&Bevarages', 0,0)

INSERT INTO Department
VALUES(6, 'Admin', 0,0)

INSERT INTO Customer_type
VALUES('standart' , 1)

INSERT INTO Customer_type
VALUES('business', 2)

INSERT INTO Room_type
VALUES ('single', 1000, 1)

INSERT INTO Room_type
VALUES ('double', 800, 2)

INSERT INTO Room_type
VALUES ('family', 2000, 4)

INSERT INTO Employee
VALUES('Default', '333333', 1, 'Default', 'Default', 'male', 'Default', 'Default', 'Default', '123456', 'Default', 15000.00, '2014-05-02', 'basic', 111111, 6);

INSERT INTO Employee
VALUES('Default2', '333333', 2, 'Default', 'Default', 'male', 'Default', 'Default', 'Default', '123456', 'Default', 15000.00, '2014-05-02', 'basic', 111112, 2);

INSERT INTO Employee
VALUES('JamesFord ', '333333', 1, 'James', 'Ford', 'male', 'Denmark', 'Aalborg', 'Jernbanegade 12A', '9000', '+4552487546', 250, '2014-05-02', 'basic', 111113, 2);

INSERT INTO Employee
VALUES('EdwardKenway', '333333', 1, 'Edwards', 'Kenway', 'male', 'Denmark', 'Aalborg', 'Jernbadegade 12B', '9000', '+4552786512', 240, '2014-05-02', 'basic', 111114, 3);

INSERT INTO Customer
VALUES('Default', '333333', 'Default', 'Default', 'standart', 'male', 'Default', 'Default', 'Default', 11111, 'Default')

INSERT INTO Customer
VALUES('MiroslavPakanec', 'mp01', 'Miroslav', 'Pakanec', 'standart', 'male', 'Denmark', 'Aalborg', 'Jernbanegade12B', 9000, '+4552784532')

INSERT INTO Customer
VALUES('IevaJonikaite', 'DesmodMilesIsAlive', 'Ieva', 'Janikaite', 'standart', 'female', 'Denmark', 'Aalborg', 'Ryesgade46', 9000, '+4552365214')

INSERT INTO Customer
VALUES('AndejIvankov', 'Slovensko', 'Andrej', 'Ivankov', 'standart', 'male', 'Denmark', 'Aalborg', 'Bejsebakkevej26', 9000, '+4552786514')

INSERT INTO Customer
VALUES('TeodorDimitriev', 'LoveIsInTheAir', 'Teodor', 'Dimitriev', 'standart', 'male', 'Denmark', 'Aalborg', 'Ravnkildevej34', 9220, '+4552786518')

INSERT INTO Rooms
VALUES(1, 4);

INSERT INTO Rooms
VALUES(2, 3);

INSERT INTO Rooms
VALUES(3, 2);

INSERT INTO Rooms
VALUES(4, 1);

INSERT INTO Rates
VALUES ('FB', 1,1,1)

INSERT INTO Rates
VALUES ('HB_D', 1,0,1)

INSERT INTO Rates
VALUES ('HB_L', 1,1,0)

INSERT INTO Rates
VALUES ('BB', 1,0,0)

INSERT INTO Booking
VALUES('default', 'default', '2016-01-01', '2016-01-06', 1, 'double', 'BB', 2, null, 10)

INSERT INTO Booking
VALUES('MiroslavPakanec', 'JamesFord', '2015-05-22', '2015-05-27', 1, 'double', 'BB', 2,'2015-05-23', 10)

INSERT INTO Booking
VALUES('IevaJonikaite', 'JamesFord', '2015-07-13', '2015-07-18', 1, 'double', 'FB', 2,null, 20)

INSERT INTO Booking
VALUES('AndejIvankov', 'EdwardKenway', '2015-06-08', '2015-06-12', 1, 'single', 'FB', 1,'2015-06-08', 5)

INSERT INTO Archive
Values('John', 'Lock', 'Denmark', 'Aalborg', 'Porthusgade', '9000', '+4552896574', '2015-06-01', '2015-06-05', '2015-06-02', '2015-06-05', 2)

INSERT INTO Archive
Values('Jack', 'Shephard', 'USA', 'Boston', 'Pappas Way', '02127', '+11159874516', '2015-06-01', '2015-06-06', '2015-06-01', '2015-06-04', 3)

INSERT INTO Archive
Values('Barry', 'Alan', 'Denmark', 'Copenhagen', 'Trangravsvej', '1436', '+4552989896', '2015-06-02', '2015-06-03', '2015-06-02', '2015-06-03', 4)

INSERT INTO Invoice
VALUES('John', 'Lock', 'EdwardKenway', 2700.0, 'Advance' , 'Paid in front', 1, 0)

INSERT INTO Invoice
VALUES('Jack', 'Shephard', 'JamesFord', 3000.0, 'Credit Card' , 'Paid on spot', 1, 0)

INSERT INTO Invoice
VALUES('Barry', 'Alan', 'JamesFord', 1000.0, 'Credit Card' , 'Paid on spot', 1, 0)