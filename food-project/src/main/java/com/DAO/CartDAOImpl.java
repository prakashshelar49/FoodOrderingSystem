package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.entity.FoodDtls;

public class CartDAOImpl  implements CartDAO{
	
private Connection conn;
public CartDAOImpl(Connection conn){
	this.conn=conn;
}
	
	public boolean addCart(Cart c) {
		boolean f=false;
		try {
			
			String sql="insert into  cart (fid,uid,food_name,price,Total_price)values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getFid());
			ps.setInt(2, c.getUserId());
			ps.setString(3, c.getFoodname());
            ps.setDouble(4,c.getPrice());
            ps.setDouble(5,c.getTotalprice());
            
            int i=ps.executeUpdate();
            if(i==1) {
            	f=true;
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

	@Override
	public List<Cart> getFoodByUser(int userId) {
		
		List<Cart> list=new ArrayList<Cart>();
		Cart c=null;
		double totalPrice=0;
		try {
			
			String sql="select * from cart where uid=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) 
			{
				c=new Cart();
				c.setCid(rs.getInt(1));
				c.setFid(rs.getInt(2));
				c.setUserId(rs.getInt(3));
				c.setFoodname(rs.getString(4));
                c.setPrice(rs.getDouble(5));
                
                totalPrice=totalPrice+rs.getDouble(6);
                c.setTotalprice(totalPrice);
                
                list.add(c);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteFood(int fid,int uid,int cid) {
	  boolean f=false;
	  
	  try {
		  String sql="delete from cart where cid=? and fid=? and uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, cid);
		ps.setInt(2, fid);
		ps.setInt(3,uid);
		
		
		int i=ps.executeUpdate();
		
		if(i==1) {
			f=true;
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
	  return f;
	}

}
