
Insert into Clients(full_name, e_mail, address, phone, hashed_password)VALUES 
( 'Vadim Vakhrushev', 'ayayay@mail.ru','Moscow, Novogireevo', '8-800-555-35-35',56563),
('Rodion Sulzhenko', '6969696@mail.ru', 'Moscow, South Butovo','7-932-444-57-65',65654),
('Alexey Kondratiev', 'qwerty@yandex.ru', 'Moscow, Perovo','7-900-214-56-31',4532321),
('Arseniy Veselov', 'arsarsars@yandex.ru','Moscow, Ivanovskoye', '8-888-77-66',987654),
('Timur Solokhov','timurkass@gmail,com', 'Moscow, Perovo','8-314-56-21', 12311),
('Ashikhmin Pavel', 'ash-pash@gmail.com', 'Jeleznodorozhny','8-654-12-65',676756);

insert into developers(name) values 
('Shkoda'),
('Lada'),
('Ford'),
('Nissan'),
('Honda');

insert into models(title, developer_id) values
('Octavia', 1),
('Felicia',1),
('Kalina',2),
('Priora',2),
('Focus',3),
('Fusion',3),
('Qashqai',4),
('X-trail',4),
('Civic',5),
('Accord',5);

insert into devices(name) values
('GPS-navigator'),
('radio'),
('video'),
('conditioner'),
('bluetooth'),
('window regulator'),
('airbag'),
('massage chair');

insert into cars(model_id,registration_number,number_of_seats,upholstery_type,price,last_maintenance_date,milage,car_colour,engine_power,number_of_doors,developer_id) values
(3,'hhsh99',4, 'Cotton',267654,'2017-06-05',8900,'Green',78,2,2),
(2,'rewe31',4,'Faux_Leather',1000000,'2013-05-06',1254,'Black',35,2,2),
(3,'fdwq54',3,'Cotton',421113,'2015-07-08',7000,'White',70,4,2),
(6,'dsdw23',3,'Polyester',544321,'2016-07-08',786,'White',65,3,2),
(9,'qasw23',5,'Olefin',3212123,'2017-09-09',5673,'Green',75,4,5),
(2,'qezx62',3,'Faux_Leather',678921,'2017-09-01',1234,'Green',42,3,2),
(9,'sqwe13',12,'Leather',900123,'2016-03-04',653,'Blue',65,4,5),
(6,'zafr78',4,'Olefin',651876,'2014-04-21',0,'Green',87,4,2);
insert into cars(model_id,registration_number,number_of_seats,upholstery_type,price,last_maintenance_date,milage,car_colour,engine_power,number_of_doors,developer_id) 
values
(7,'trew54',2,'Leather',523323,'2018-06-06',735,'Blue',43,4,4),
(10,'zasw12',1,'Leather',554311,'2015-09-07',8753,'Blue',88,2,5);

insert into orders(date_an_time, car_id, if_test_drive_required, current_status, client_id) values 
('2019-03-06', 1, false, 'supply', 2),
('2019-04-03',7,true,'ready',4),
('2019-05-06',3,true,'supply',1),

('2019-01-05',2,true,'done',3),
('2019-03-09',4,true,'test_drive',6),
('2019-11-12',5,false,'supply',5),
('2019-09-09',6,false,'processing',3),
('2019-07-08',8,false,'ready',4),
('2020-01-01',9,true,'supply',1),
('2019-12-11',10,true,'done',6);

insert into devices_cars values
(4,1),
(6,1),
(5,2),
(4,2),
(7,2),
(1,3),
(5,3),
(7,4),
(4,5),
(3,5),
(6,5),
(7,6),
(2,6),
(4,7),
(1,7),
(5,7),
(4,8),
(2,8),
(7,8),
(6,9),
(3,9),
(2,10),
(7,10),
(6,10);




insert into cars_clients values
(1,3),
(1,2),
(2,5),
(2,6),
(4,1),
(4,3),
(5,2),
(6,1),
(7,4),
(7,5),
(8,3),
(9,2);

