Hyuandai Autoever Assignment

Task


Design a Payment system using oops
1. define a common abstraction for payment
2. implement atleast 2 concrete payment types
3. each payment type must provide its own payment behaviour
4. show runtime polymorphism using a common reference type
5. ensure internal data is properly encapsulated
6. prevent invalid payment values(eg negative amounts)
7. design a system so that new payment types can be added without modifying the existing processing logic

hey as i know i am working in hyuandai autoever and i am given a task on sql 
suppose i am an hyuandain owner and i have suppose 10 brances (shops car) under me what i have to do in mysql is to create a reprt on the sales like region wise , color wise , month wise make a total sales report compare other fields as well if u can 
create a lot of tables aas well i want a professional good work 


rather than debugging lets do from the starting 
hey as i am working in hyuandai autoever and i am given a task on sql suppose i am an hyuandain owner and i have suppose 10 or more branches (shops car) under me what i have to do in mysql is to create a reprt on the sales like region wise , color wise , month wise quater wise like all any other field u can add like model and monthly sale and all ,make a total sales report compare other fields as well its not fixed compare more as well create a lot of tables as well i want a professional good work lmake the whole mysql code and make a big table as a report ok thinkn of me as a manager and for different regions and branches i have to compare all the details and which is doing better and all make sure it is proffesional and all


i have already made the tables and insertef the valuues u just give me the query for the final big report ok

CREATE DATABASE hyundai_manager_project;
USE hyundai_manager_project;

CREATE TABLE regions(
region_id INT AUTO_INCREMENT PRIMARY KEY,
region_name VARCHAR(50),
regional_manager VARCHAR(100)
);

INSERT INTO regions(region_name,regional_manager) VALUES
('North','Amit Kapoor'),
('South','Ravi Iyer'),
('East','Sanjay Das'),
('West','Mehul Shah');

CREATE TABLE branches(
branch_id INT AUTO_INCREMENT PRIMARY KEY,
branch_name VARCHAR(100),
city VARCHAR(50),
state VARCHAR(50),
region_id INT,
opening_year INT,
branch_size VARCHAR(30),

FOREIGN KEY(region_id) REFERENCES regions(region_id)
);

INSERT INTO branches(branch_name,city,state,region_id,opening_year,branch_size) VALUES
('Delhi Hyundai','Delhi','Delhi',1,2015,'Large'),
('Noida Hyundai','Noida','UP',1,2017,'Medium'),
('Jaipur Hyundai','Jaipur','Rajasthan',1,2016,'Medium'),

('Chennai Hyundai','Chennai','Tamil Nadu',2,2016,'Large'),
('Bangalore Hyundai','Bangalore','Karnataka',2,2018,'Large'),
('Hyderabad Hyundai','Hyderabad','Telangana',2,2017,'Medium'),

('Kolkata Hyundai','Kolkata','West Bengal',3,2014,'Medium'),
('Patna Hyundai','Patna','Bihar',3,2019,'Small'),

('Mumbai Hyundai','Mumbai','Maharashtra',4,2013,'Large'),
('Pune Hyundai','Pune','Maharashtra',4,2017,'Medium'),
('Ahmedabad Hyundai','Ahmedabad','Gujarat',4,2018,'Medium');

CREATE TABLE car_models(
model_id INT AUTO_INCREMENT PRIMARY KEY,
model_name VARCHAR(50),
category VARCHAR(50),
launch_year INT,
base_price DECIMAL(12,2)
);

INSERT INTO car_models(model_name,category,launch_year,base_price) VALUES
('Creta','SUV',2020,1500000),
('Verna','Sedan',2021,1300000),
('i20','Hatchback',2019,900000),
('Exter','SUV',2023,800000),
('Kona','Electric',2022,2300000);

CREATE TABLE car_variants(
variant_id INT AUTO_INCREMENT PRIMARY KEY,
model_id INT,
variant_name VARCHAR(50),
fuel_type VARCHAR(20),
transmission VARCHAR(20),
price DECIMAL(12,2),

FOREIGN KEY(model_id) REFERENCES car_models(model_id)
);

INSERT INTO car_variants(model_id,variant_name,fuel_type,transmission,price) VALUES
(1,'Creta Base','Petrol','Manual',1500000),
(1,'Creta SX','Petrol','Automatic',1700000),
(2,'Verna Base','Petrol','Manual',1300000),
(2,'Verna SX','Diesel','Automatic',1500000),
(3,'i20 Sportz','Petrol','Manual',900000),
(3,'i20 Asta','Petrol','Automatic',1050000),
(4,'Exter Base','Petrol','Manual',800000),
(4,'Exter SX','Petrol','Automatic',950000),
(5,'Kona Electric','Electric','Automatic',2300000);


CREATE TABLE car_colors(
color_id INT AUTO_INCREMENT PRIMARY KEY,
color_name VARCHAR(50)
);

INSERT INTO car_colors(color_name) VALUES
('White'),
('Black'),
('Red'),
('Blue'),
('Grey'),
('Silver');

CREATE TABLE customers(
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(100),
gender VARCHAR(10),
city VARCHAR(50),
age INT,
phone VARCHAR(20)
);

INSERT INTO customers(customer_name,gender,city,age,phone) VALUES
('Rahul Sharma','Male','Delhi',35,'9991111111'),
('Priya Mehta','Female','Mumbai',30,'9992222222'),
('Amit Verma','Male','Bangalore',42,'9993333333'),
('Anjali Gupta','Female','Chennai',29,'9994444444'),
('Rohit Das','Male','Kolkata',38,'9995555555'),
('Sneha Patel','Female','Ahmedabad',33,'9996666666'),
('Vikas Singh','Male','Patna',41,'9997777777'),
('Neha Kapoor','Female','Delhi',27,'9998888888');

CREATE TABLE employees(
employee_id INT AUTO_INCREMENT PRIMARY KEY,
employee_name VARCHAR(100),
branch_id INT,
designation VARCHAR(50),
experience_years INT,

FOREIGN KEY(branch_id) REFERENCES branches(branch_id)
);

INSERT INTO employees(employee_name,branch_id,designation,experience_years) VALUES
('Arjun',1,'Sales Manager',8),
('Vikas',2,'Sales Executive',5),
('Sneha',3,'Sales Executive',4),
('Raj',4,'Sales Manager',7),
('Karan',5,'Sales Executive',3),
('Pooja',6,'Sales Executive',4),
('Meera',7,'Sales Manager',9),
('Aman',8,'Sales Executive',2),
('Ravi',9,'Sales Manager',10),
('Deepak',10,'Sales Executive',3);

CREATE TABLE inventory(
inventory_id INT AUTO_INCREMENT PRIMARY KEY,
branch_id INT,
variant_id INT,
color_id INT,
stock_quantity INT,

FOREIGN KEY(branch_id) REFERENCES branches(branch_id),
FOREIGN KEY(variant_id) REFERENCES car_variants(variant_id),
FOREIGN KEY(color_id) REFERENCES car_colors(color_id)
);

INSERT INTO inventory(branch_id,variant_id,color_id,stock_quantity) VALUES
(1,1,1,10),
(1,2,2,5),
(2,3,1,8),
(3,4,3,6),
(4,5,4,7),
(5,6,1,9),
(6,7,5,6),
(7,8,2,5),
(8,9,3,4),
(9,1,6,8),
(10,2,1,7);

CREATE TABLE sales(
sale_id INT AUTO_INCREMENT PRIMARY KEY,
branch_id INT,
customer_id INT,
employee_id INT,
sale_date DATE,
total_amount DECIMAL(12,2),
discount DECIMAL(12,2),
tax DECIMAL(12,2),
final_amount DECIMAL(12,2),

FOREIGN KEY(branch_id) REFERENCES branches(branch_id),
FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
FOREIGN KEY(employee_id) REFERENCES employees(employee_id)
);

INSERT INTO sales(branch_id,customer_id,employee_id,sale_date,total_amount,discount,tax,final_amount) VALUES
(1,1,1,'2024-01-10',1500000,50000,90000,1540000),
(2,2,2,'2024-01-15',1300000,30000,78000,1348000),
(3,3,3,'2024-02-05',900000,20000,54000,934000),
(4,4,4,'2024-02-20',1500000,40000,90000,1550000),
(5,5,5,'2024-03-10',800000,10000,48000,838000),
(7,6,7,'2024-03-18',2300000,50000,138000,2388000),
(8,3,8,'2024-04-02',1500000,30000,90000,1560000),
(9,4,9,'2024-04-15',1300000,20000,78000,1358000),
(10,1,10,'2024-05-10',900000,10000,54000,944000);

CREATE TABLE sales_details(
sale_detail_id INT AUTO_INCREMENT PRIMARY KEY,
sale_id INT,
variant_id INT,
color_id INT,
quantity INT,

FOREIGN KEY(sale_id) REFERENCES sales(sale_id),
FOREIGN KEY(variant_id) REFERENCES car_variants(variant_id),
FOREIGN KEY(color_id) REFERENCES car_colors(color_id)
);

INSERT INTO sales_details(sale_id,variant_id,color_id,quantity) VALUES
(1,1,1,1),
(2,3,2,1),
(3,5,3,1),
(4,2,1,1),
(5,7,4,1),
(6,9,5,1),
(7,1,2,1),
(8,4,3,1),
(9,6,4,1);

CREATE TABLE payments(
payment_id INT AUTO_INCREMENT PRIMARY KEY,
sale_id INT,
payment_method VARCHAR(30),
payment_status VARCHAR(30),

FOREIGN KEY(sale_id) REFERENCES sales(sale_id)
);

INSERT INTO payments(sale_id,payment_method,payment_status) VALUES
(1,'Loan','Approved'),
(2,'Cash','Completed'),
(3,'Cash','Completed'),
(4,'Loan','Approved'),
(5,'Cash','Completed'),
(6,'Loan','Approved'),
(7,'Cash','Completed'),
(8,'Loan','Approved'),
(9,'Cash','Completed');

CREATE TABLE loan_details(
loan_id INT AUTO_INCREMENT PRIMARY KEY,
sale_id INT,
bank_name VARCHAR(50),
loan_amount DECIMAL(12,2),
interest_rate DECIMAL(5,2),

FOREIGN KEY(sale_id) REFERENCES sales(sale_id)
);

INSERT INTO loan_details(sale_id,bank_name,loan_amount,interest_rate) VALUES
(1,'HDFC',1200000,8.5),
(4,'ICICI',1200000,8.2),
(6,'SBI',2000000,7.9),
(8,'Axis',1000000,8.1);
