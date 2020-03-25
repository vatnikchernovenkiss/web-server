package Entities;
import java.util.Set;

public class Developers {
	private int id;
	private String name;
	private Set<Models> models;
	private Set<Cars> cars;
	public int getId() {return id;}
	public String getName() {return name;}
	public void setId(int id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setModels(Set<Models> models) {this.models = models;}
	public Set<Models> getModels(){return this.models;}
	public Set<Cars> getCars(){return cars;}
	public void setCars(Set<Cars> cars) {this.cars = cars;}
}
