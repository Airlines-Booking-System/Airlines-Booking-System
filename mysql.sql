create database airline1;

use airline1;

create table flight_dtls(
    id int primary key auto_increment,
    name varchar(50),
    class varchar(50),
    destination varchar(50),
    source varchar(50),
    departure datetime,
    arrival datetime
);

insert into flight_details (id, name, flight_class, destination, source, departure, arrival) values
(default, 'Air Asia', 'Economy', 'BOM', 'PNQ', '2023-12-12 12:12:00', '2023-12-12 15:12:00'),
(default, 'Akasa', 'Economy', 'PNQ', 'BOM', '2023-12-12 12:12:00', '2023-12-12 15:12:00'),
(default, 'Indigo', 'Economy', 'HYD', 'BOM', '2023-12-12 12:12:00', '2023-12-12 15:12:00'),
(default, 'Air Asia', 'Economy', 'PNQ', 'IDR', '2023-12-12 12:12:00', '2023-12-12 15:12:00'),
(default, 'Indigo', 'Economy', 'IDR', 'PNQ', '2023-12-12 12:12:00', '2023-12-12 15:12:00'),
(default, 'Akasa', 'Economy', 'BOM', 'IND', '2023-12-12 12:12:00', '2023-12-12 15:12:00');

insert into user_details (id,cpass,email,name,role) values (default,'Prachi123','pg@gmail.com','Prachi','USER');

insert into address_details(pincode, city, state) values (482001,'Jabalpur', 'MP'),(483001,'Ujjain', 'MP'), (484001,'Pune', 'Maharastra');

insert into  general_details (customer_id,aadhar, address,dob,gender,mobile_number,pincode_pincode) values(1,'AA1','MP','2000-02-26','female','9999955555', 482001);

insert into payment_details(status, total_amount) values('Successful', 5000.5);

insert into booking_details(duration, fare_price, seatno, customer_id, flight_id, payment_id) values('01:00:00', 1000.2, 1, 1, 1, 1);

//insert into booking_details(id,duration,fare_price,seat_no,customner_id, flight_id, paymentid_id, flight id) valuies(default, 3, 1000.00,10,1,1,1),(default, 4, 2000.00,11,2,2,2);

//insert into payment_Details(id,status,total_amount,booking_id_id) values (default, 'Pending', 1000.00, 1),(default, 'Successful', 2000.00, 2);





insert into passanger_details(id,name,bid_id,customer_id) values(1,)
