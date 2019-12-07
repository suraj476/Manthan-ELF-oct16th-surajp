package com.manthan.flipkart.bean;

public class Userinfobeans {

	private int userId;
	private String username;
	private String email;
	private String password;
	public int getuserid() {
		return userId;
	}
	public String getusername() {
		return username;
	}
	public String getemail() {
		return email;
	}
	public String getpassword() {
		return password;
	}
	
	public void setuserId(int userid) {
		this.userId = userid;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
}
