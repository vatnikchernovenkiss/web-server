package form;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import Entities.Cars.colour;
import Entities.Cars.upholstery;
public class CarForm {
	private int id;
	private int model_id;
	private String registration_number;
	private int number_of_seats;
	private upholstery upholstery_type = upholstery.Cotton;
	private double price;
	public Date last_maintance_date;
	private List<Integer> test_drive_clients_id;
	private double milage;
	private colour car_colour = colour.Black;
	private double engine_power;
	private int number_of_doors;
	private int developer_id;
	private  List<Integer> devices_id;
	private DateFormat formatter =  new SimpleDateFormat("yyyy-mm-dd");
	public CarForm() {}
	 
	public void setDevices_id(List<Integer> devices) {this.devices_id = devices;}
	public List<Integer>  getDevices_id(){return devices_id;}

	public int getId() {return id;}
	public String getRegistration_number() {return registration_number;}
	public int getNumber_of_seats() {return number_of_seats;}
	public String getUpholstery_type() {return upholstery_type.toString();}
	public double getPrice() {return price;}
	public String getLast_maintance_date() {
		return "";
	}
	public void setRegistration_number(String registration_number) {this.registration_number = registration_number;}
	public void setId(int id) {this.id = id;}

	public List<Integer> getTest_drive_clients_id() {return test_drive_clients_id;}
	public double getMilage() {return milage;}
	public String getCar_colour() {return car_colour.toString();}
	public double getEngine_power() {return engine_power;}
	public int getNumber_of_doors() {return number_of_doors;}
	public int getDeveloper_id() {return developer_id;}
	public int getModel_id() {return model_id;}
	public void setModel_id(int model_id) {this.model_id = model_id;}
	public void setNumber_of_seats(int number_of_seats) {this.number_of_seats = number_of_seats;}
	public void setUpholstery_type(String upholsteryy) {this.upholstery_type = upholstery.valueOf(upholsteryy);}
	public void setPrice(double price) {this.price = price;}
	public void setLast_maintance_date(String last_maintenance_date) throws ParseException {this.last_maintance_date = formatter.parse(last_maintenance_date);}
	public void setTest_drive_clients_id(List<Integer> test_drive_clients) {this.test_drive_clients_id =test_drive_clients;}
	public void setMilage(double milage) {this.milage = milage;}
	public void setCar_colour(String car_colour) {this.car_colour = colour.valueOf(car_colour);}
	public void setEngine_power(double engine_power) {this.engine_power = engine_power;}
	public void setNumber_of_doors(int number_of_doors) {this.number_of_doors = number_of_doors;}
	public void setDeveloper_id(int developer_id) {this.developer_id = developer_id;}
}
