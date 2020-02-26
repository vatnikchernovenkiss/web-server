Insert into Clients(id, full_name, e_mail, address, phone, hashed_password)VALUES 
(1, 'Vadim Vakhrushev', 'ayayay@mail.ru','Moscow, Novogireevo', '8-800-555-35-35',56563),
(2,'Rodion Sulzhenko', '6969696@mail.ru', 'Moscow, South Butovo','7-932-444-57-65',65654),
(3, 'Alexey Kondratiev', 'qwerty@yandex.ru', 'Moscow, Perovo','7-900-214-56-31',4532321),
(4,'Arseniy Veselov', 'arsarsars@yandex.ru','Moscow, Ivanovskoye', '8-888-77-66',987654),
(5, 'Timur Solokhov','timurkass@gmail,com', 'Moscow, Perovo','8-314-56-21', 12311),
(6, 'Ashikhmin Pavel', 'ash-pash@gmail.com', 'Jeleznodorozhny','8-654-12-65',676756);

insert into developers values 
(1, 'Shkoda'),
(2, 'Lada'),
(3, 'Ford'),
(4, 'Nissan'),
(5, 'Honda');

insert into models values
(1, 'Octavia', 1),
(2, 'Felicia',1),
(3, 'Kalina',2),
(4, 'Priora',2),
(5, 'Focus',3),
(6,'Fusion',3),
(7, 'Qashqai',4),
(8,'X-trail',4),
(9,'Civic',5),
(10,'Accord',5);

insert into devices values
(1, 'GPS-navigator'),
(2, 'radio'),
(3, 'video'),
(4, 'conditioner'),
(5,'bluetooth'),
(6,'window regulator'),
(7, 'airbag'),
(8, 'massage chair');

insert into cars values
(1,3,'hhsh99',4, 'Cotton',267654,'2017-06-05',Array[2,3],8900,'Green',78,2,2),
(3,2,'rewe31',4,'Faux Leather',1000000,'2013-05-06',Array[1],1254,'Black',35,2,2),
(4,3,'fdwq54',3,'Cotton',421113,'2015-07-08',Array[5],7000,'White',70,4,2),
(5,6,'dsdw23',3,'Polyester',544321,'2016-07-08', Array[1,2,3],786,'White',65,3,2),
(6,9,'qasw23',5,'Olefin',3212123,'2017-09-09',Array[4],5673,'Green',75,4,5),
(8,2,'qezx62',3,'Faux Leather',678921,'2017-09-01',Array[2],1234,'Green',42,3,2),
(9,9,'sqwe13',12,'Leather',900123,'2016-03-04',Array[3,5],653,'Blue',65,4,5),
(10,6,'zafr78',4,'Olefin',651876,'2014-04-21',Array[1,6],0,'Green',87,4,2);
insert into cars("id",model_id,registration_number,number_of_seats,upholstery_type,price,last_maintenance_date,milage,car_colour,engine_power,number_of_doors,developer_id) 
values
(2,7,'trew54',2,'Leather',523323,'2018-06-06',735,'Blue',43,4,4),
(7,10,'zasw12',1,'Leather',554311,'2015-09-07',8753,'Blue',88,2,5);

insert into orders values 
(1,'2019-03-06', 1, false, 'supply', 2),
(2,'2019-04-03',7,true,'ready',4),
(3,'2019-05-06',3,true,'supply',1),
(4,'2019-07-04',7,false,'processing',4),
(5,'2019-01-05',2,true,'done',3),
(6,'2019-03-09',4,true,'test-drive',6),
(7,'2019-11-12',5,false,'supply',5),
(8,'2019-09-09',6,false,'processing',3),
(9,'2019-07-08',8,false,'ready',4),
(10,'2020-01-01',9,true,'supply',1),
(11,'2019-12-11',10,true,'done',6);

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
