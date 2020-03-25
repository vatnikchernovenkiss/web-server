package Entities;
import java.util.Set;
public class Clients {
	private int id;
	private String full_name;
	private String e_mail;
	private String address;
	private String phone;
	private Set<Orders> orders;
	private int hashed_password;
	private Set<Cars> test_drive_cars;
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getFull_name() {return full_name;}
	public void setFull_name(String full_name) {this.full_name = full_name;}
	public String getE_mail() {return e_mail;}
	public void setE_mail(String e_mail) {this.e_mail = e_mail;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public  Set<Orders> getOrders() {return orders;}
	public void setOrders(Set<Orders> orders) {this.orders = orders;}
	public int getHashed_password() {return hashed_password;}
	public void setHashed_password(int hashed_password) {this.hashed_password = hashed_password;}
	public Set<Cars> getTest_drive_cars(){return test_drive_cars;}
	public void setTest_drive_cars(Set<Cars> test_drive_cars) {this.test_drive_cars = test_drive_cars;}
	
}
