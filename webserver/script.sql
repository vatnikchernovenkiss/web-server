
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Clients CASCADE;
DROP TABLE IF EXISTS Cars CASCADE;
DROP TABLE IF EXISTS Devices CASCADE;
DROP TABLE IF EXISTS Developers CASCADE;
DROP TABLE IF EXISTS Models CASCADE;
DROP TABLE IF EXISTS Devices_Cars CASCADE;
DROP TABLE IF EXISTS cars_clients CASCADE;
DROP TRIGGER IF EXISTS check_update on Orders;
DROP TYPE IF EXISTS upholstery CASCADE;
DROP TYPE IF EXISTS colour CASCADE;
DROP TYPE IF EXISTS status CASCADE;

--CREATE TYPE upholstery AS ENUM ('Polyester', 'Faux_Leather', 'Leather', 'Olefin', 'Cotton');

--CREATE TYPE colour AS ENUM ('Green', 'Red', 'Blue', 'White', 'Black');

--CREATE TYPE status AS ENUM ('processing', 'test-drive', 'done', 'ready', 'supply');

CREATE TABLE Devices (
	"id" serial PRIMARY KEY,
	"name" text NOT NULL
);

CREATE TABLE Developers(
	"id" SERIAL PRIMARY KEY,
	"name" TEXT NOT NULL
);

CREATE TABLE Models(
	"id" SERIAL PRIMARY KEY,
	title TEXT NOT NULL,
	developer_id INTEGER REFERENCES Developers("id") ON DELETE CASCADE
);

CREATE TABLE Cars (
	"id" serial PRIMARY KEY,
	model_id INTEGER REFERENCES Models("id") ON DELETE CASCADE,
	registration_number TEXT UNIQUE NOT NULL,
	number_of_seats INTEGER NOT NULL CHECK(number_of_seats > 0),
	upholstery_type TEXT NOT NULL,
	price REAL NOT NULL CHECK(price > 0),
	last_maintenance_date DATE,
	milage real CHECK(milage >= 0),
	car_colour TEXT NOT NULL,
	engine_power real CHECK(engine_power >= 0),
	number_of_doors INTEGER NOT NULL CHECK(number_of_doors > 0),
	developer_id INTEGER REFERENCES Developers("id") ON DELETE CASCADE
);


CREATE TABLE Clients(
	"id"  SERIAL PRIMARY KEY,
	full_name TEXT NOT NULL,
	e_mail TEXT NOT NULL UNIQUE,
	address TEXT,
	phone TEXT,
	hashed_password NUMERIC NOT NULL
);

CREATE TABLE Orders(
	"id" SERIAL PRIMARY KEY,
	date_an_time date NOT NULL,
	car_id INTEGER REFERENCES Cars("id") ON DELETE CASCADE,
	if_test_drive_required  BOOL NOT NULL,
	current_status TEXT NOT NULL,
	client_id INTEGER REFERENCES Clients("id") ON DELETE CASCADE
);
CREATE TABLE Cars_clients (
	car_id integer REFERENCES Cars("id") ON DELETE CASCADE,
	client_id integer REFERENCES Clients("id") ON DELETE CASCADE
);

CREATE TABLE Devices_Cars(
	device_id INTEGER REFERENCES Devices("id") ON DELETE CASCADE,
	car_id INTEGER REFERENCES Cars("id") ON DELETE CASCADE
);


