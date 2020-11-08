use employees;
create database sdet4_akshita;
use sdet4_akshita;
CREATE TABLE Salesman(
  Salesman_id int primary key,
  Name varchar(32),
  City varchar(32),
  Commission int
  );
  
DESCRIBE Salesman;

INSERT INTO Salesman VALUES(5001, 'James Hoog' , 'New York', 15);

INSERT INTO Salesman VALUES
    (5002, 'Nail Knite', 'Paris', 13),
    (5005, 'Pit Alex', 'London', 11), 
    (5006, 'McLyon', 'Paris', 14), 
    (5007, 'Paul Adam', 'Rome', 13),
    (5003, 'Lauson Hen', 'San Jose', 12);


SELECT * FROM Salesman;

SELECT Salesman_id, City FROM Salesman;

SELECT * FROM Salesman WHERE city='Paris';

SELECT Salesman_id, Commission FROM Salesman WHERE name='Paul Adam';

ALTER TABLE Salesman ADD grade int;

UPDATE Salesman SET grade=100;

SELECT * FROM Salesman;

UPDATE Salesman SET grade=200 WHERE City='Rome';

UPDATE Salesman SET grade=300 WHERE Name='James Hoog';

UPDATE Salesman SET Name='Pierre' WHERE Name='McLyon';

create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

insert into orders values
(70001, 150.5, '2012-10-05', 3005, 5002), (70009, 270.65, '2012-09-10', 3001, 5005),
(70002, 65.26, '2012-10-05', 3002, 5001), (70004, 110.5, '2012-08-17', 3009, 5003),
(70007, 948.5, '2012-09-10', 3005, 5002), (70005, 2400.6, '2012-07-27', 3007, 5001),
(70008, 5760, '2012-08-15', 3002, 5001), (70010, 1983.43, '2012-10-10', 3004, 5006),
(70003, 2480.4, '2012-10-10', 3009, 5003), (70012, 250.45, '2012-06-27', 3008, 5002),
(70011, 75.29, '2012-08-17', 3003, 5007), (70013, 3045.6, '2012-04-25', 3002, 5001);

select distinct salesman_id from orders;
select order_no, order_date from orders order by order_date;
select order_no, purchase_amount from orders order by purchase_amount DESC;
select * from orders where purchase_amount < 500;
select * from orders where purchase_amount between 1000 and 2000;
select SUM(purchase_amount) AS "Total" from orders;
select AVG(purchase_amount) AS "Average" from orders;
select MAX(purchase_amount) AS "Max value" from orders;
select MIN(purchase_amount) AS "Min value" from orders;
select COUNT(distinct salesman_id) AS "Count" from orders;

SELECT customer_id, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
WHERE order_date='2012-08-17' GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders
GROUP BY customer_id, order_date
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);


create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);


insert into customers values 
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002),
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

SELECT a.customer_name AS "Customer Name", a.City, b.name AS "Salesman", b.Commission FROM customers a 
INNER JOIN Salesman b ON a.Salesman_id=b.Salesman_id;


SELECT a.customer_name, a.City, a.grade, b.Name AS "Salesman", b.City FROM customers a 
LEFT OUTER JOIN Salesman b ON a.Salesman_id=b.Salesman_id WHERE a.grade<300 
ORDER BY a.Customer_id;

SELECT a.customer_name AS "Customer Name", a.City, b.Name AS "Salesman", b.Commission FROM customers a 
INNER JOIN Salesman b ON a.Salesman_id=b.Salesman_id 
WHERE b.Commission>12;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.Name AS "Salesman", c.Commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN Salesman c ON a.Salesman_id=c.Salesman_id;

SELECT * FROM orders
WHERE Salesman_id=(SELECT DISTINCT Salesman_id FROM orders WHERE customer_id=3007);


SELECT * FROM orders
WHERE Salesman_id IN (SELECT Salesman_id FROM Salesman WHERE City='New York');


SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE City='New York');


SELECT order_no, purchase_amount, order_date, Salesman_id FROM orders
WHERE Salesman_id IN( SELECT Salesman_id FROM Salesman
WHERE Commission=( SELECT MAX(Commission) FROM Salesman));


SELECT Customer_id, Customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.Customer_id = b.Customer_id)
UNION
SELECT Salesman_id, name FROM Salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.Salesman_id = b.Salesman_id)
ORDER BY customer_name;


SELECT a.Salesman_id, name, order_no, 'highest on', order_date FROM Salesman a, orders b
WHERE a.Salesman_id=b.Salesman_id
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.Salesman_id, name, order_no, 'lowest on', order_date FROM Salesman a, orders b
WHERE a.Salesman_id=b.Salesman_id
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);





