package Entities;
import java.util.Set;

import java.util.Date;

public class Cars {
	public enum upholstery {Polyester,Faux_Leather, Leather, Olefin, Cotton}
	public enum colour {Green, Red, Blue, White, Black}
	private int id;
	private Models model_id;
	private String registration_number;
	private int number_of_seats;
	private upholstery upholstery_type;
	private double price;
	private Date last_maintance_date;
	private Set<Clients> test_drive_clients;
	private double milage;
	private colour car_colour;
	private double engine_power;
	private int number_of_doors;
	private Developers developer_id;
	private Set<Orders> orders;
	private Set<Devices> devices;
	public void setDevices(Set<Devices> devices) {this.devices = devices;}
	public Set<Devices> getDevices(){return devices;}
	public Set<Orders> getOrders() {return orders;}
	public void setOrders(Set<Orders> orders) {this.orders = orders;}
	public int getId() {return id;}
	public String getRegistration_number() {return registration_number;}
	public int getNumber_of_seats() {return number_of_seats;}
	public String getUpholstery() {return upholstery_type.toString();}
	public double getPrice() {return price;}
	public Date getLast_maintance_date() {return last_maintance_date;}
	public Set<Clients> getTest_drive_clients() {return test_drive_clients;}
	public double getMilage() {return milage;}
	public String getCar_colour() {return car_colour.toString();}
	public double getEngine_power() {return engine_power;}
	public int getNumber_of_doors() {return number_of_doors;}
	public Developers getDeveloper_id() {return developer_id;}
	public Models getModel_id() {return model_id;}
	public void setId(int id) {this.id = id;}
	public void setModel_id(Models model_id) {this.model_id = model_id;}
	public void setRegistration_number(String registration_number) {this.registration_number = registration_number;}
	public void setNumber_of_seats(int number_of_seats) {this.number_of_seats = number_of_seats;}
	public void setUpholstery(String upholsteryy) {this.upholstery_type = upholstery.valueOf(upholsteryy);}
	public void setPrice(double price) {this.price = price;}
	public void setLast_maintance_date(Date last_maintenance_date) {this.last_maintance_date = last_maintenance_date;}
	public void setTest_drive_clients(Set<Clients> test_drive_clients) {this.test_drive_clients = test_drive_clients;}
	public void setMilage(double milage) {this.milage = milage;}
	public void setCar_colour(String car_colour) {this.car_colour = colour.valueOf(car_colour);}
	public void setEngine_power(double engine_power) {this.engine_power = engine_power;}
	public void setNumber_of_doors(int number_of_doors) {this.number_of_doors = number_of_doors;}
	public void setDeveloper_id(Developers developer_id) {this.developer_id = developer_id;}
	
}
