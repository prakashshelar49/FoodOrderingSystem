package com.DAO;

import java.util.List;

import com.entity.Cart;


public interface CartDAO {

	
	public boolean addCart(Cart c);
	
	public List<Cart> getFoodByUser(int userId);
	
	public boolean deleteFood(int fid,int uid,int cid);
	
	
	
}
