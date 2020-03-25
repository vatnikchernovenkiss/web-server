package Entities;
import java.util.Set;

public class Devices {
	private int id;
	private String name;
	private Set<Cars> cars;
	public int getId() {return id;}
	public String getName() {return name;}
	public void setId(int id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setCars(Set<Cars> cars) {this.cars = cars;}
	public Set<Cars> getCars(){return cars;}
}
