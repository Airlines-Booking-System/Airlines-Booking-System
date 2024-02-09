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
