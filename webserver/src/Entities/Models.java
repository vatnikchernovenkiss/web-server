package Entities;
import java.util.Set;

public class Models {
	private int id;
	private String title;
	private Developers developer_id;
	private Set<Cars> cars;
	public int getId() {return id;}
	public String getTitle() {return title;}
	public void setId(int id) {this.id = id;}
	public void setTitle(String title) {this.title = title;}
	public Developers getDeveloper_id() {return developer_id;}
	public void setDeveloper_id(Developers developer_id) {this.developer_id = developer_id;}
	public void setCars(Set<Cars>cars) {this.cars = cars;}
	public Set<Cars> getCars() {return cars;}
}
