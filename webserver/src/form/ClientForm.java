package form;

public class ClientForm {
	private int id;
	private String full_name;
	private String e_mail;
	private String address;
	private String phone;
	private int hashed_password;
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
	public int getHashed_password() {return hashed_password;}
	public void setHashed_password(int hashed_password) {this.hashed_password = hashed_password;}
}