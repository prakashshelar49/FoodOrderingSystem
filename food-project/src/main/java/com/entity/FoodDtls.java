package com.entity;

public class FoodDtls {

	private int Id;
	private String foodname;
	private String price;
	private String foodtype;
	private String status;
	private String photoname;
	private String email;
	
	
	public FoodDtls() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FoodDtls(String foodname, String price,String foodtype, String status, String photoname, String email) {
		super();
		this.foodname = foodname;
		this.price = price;
		this.photoname=photoname;
		this.email = email;
		this.foodtype = foodtype;
		this.status = status;
	}





	public int getId() {
		return Id;
	}


	public void setId(int num) {
		this.Id = num;
	}


	public String getFoodname() {
		return foodname;
	}


	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

    public String getFoodtype() {
		return foodtype;
	}


	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getphotoname() {
    	return photoname;
    }
	
   public void setphotname(String photoname) {
	   this.photoname=photoname;
   }

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "FoodDtls [Id=" + Id + ", foodname=" + foodname + ", price=" + price + ", foodtype=" + foodtype
				+ ", status=" + status + ", photoname=" + photoname + ", email=" + email + "]";
	}


	


	
 
}
