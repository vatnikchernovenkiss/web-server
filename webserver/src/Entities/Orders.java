package Entities;

import java.util.Date;
public class Orders {
	public enum status {processing, test_drive, done, ready, supply}
	private int id;
	private Date date_and_time;
	private Cars car_id;
	private boolean if_test_drive_required;
	private Clients client_id;
	private status current_status;
	public String getCurrent_status() {return current_status.toString();}
	public void setCurrent_status(String current_status) {this.current_status = status.valueOf(current_status);}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Date getDate_and_time() {return date_and_time;}
	public void setDate_and_time(Date date_and_time) {this.date_and_time = date_and_time;}
	public Cars getCar_id() {return car_id;}
	public void setCar_id(Cars car_id) {this.car_id = car_id;}
	public boolean getIf_test_drive_required() {return if_test_drive_required;}
	public void setIf_test_drive_required(boolean if_test_drive_required) {this.if_test_drive_required = if_test_drive_required;}
	public Clients getClient_id() {return client_id;}
	public void setClient_id(Clients client_id) {this.client_id = client_id;}
}
