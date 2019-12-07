package com.manthan.flipkart.bean;



public class productinfobeans {
	private int productId;
	private String productname;
	private double cost;
	private String colour;
	
	private String desc;
	private int numofproduct;
	public int getproductId() {
		return productId;
	}
	public String getproductname() {
		return productname;
	}
	public double getcost() {
		return cost;
	}
	public String getcolour() {
		return colour;
	}
	public int getnumofproduct() {
		return numofproduct;
	}
	public String getdesc() {
		return desc;
	}
	public void setproductId(int productId) {
		this.productId = productId;
	}
	public void setproductname(String productname) {
		this.productname = productname;
	}
	public void setcost(double cost) {
		this.cost = cost;
	}
	public void setcolour(String colour) {
		this.colour = colour;
	}
	public void setnumofproduct(int numofproduct) {
		this.numofproduct = numofproduct;
	}
	public void setdesc(String desc) {
		this.desc = desc;
	}
	
}
