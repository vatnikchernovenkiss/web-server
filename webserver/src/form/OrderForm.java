package form;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import Entities.Orders.status;

public class OrderForm {
	private int id;
	public Date date_and_time;
	private int car_id;
	private boolean if_test_drive_required;
	private int client_id;
	private status current_status = status.processing;
	private DateFormat formatter =  new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	public String getCurrent_status() {return current_status.toString();}
	public void setCurrent_status(String current_status) {this.current_status = status.valueOf(current_status);}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getDate_and_time() {return "";}
	public void setDate_and_time(String date_and_time) throws ParseException {this.date_and_time = formatter.parse(date_and_time);}
	public int getCar_id() {return car_id;}
	public void setCar_id(int car_id) {this.car_id = car_id;}
	public boolean getIf_test_drive_required() {return if_test_drive_required;}
	public void setIf_test_drive_required(boolean if_test_drive_required) {this.if_test_drive_required = if_test_drive_required;}
	public int getClient_id() {return client_id;}
	public void setClient_id(int client_id) {this.client_id = client_id;}
}
