package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Food_Order;

public class FoodOrderImpl implements  FoodOrderDAO {
	
	private Connection conn;

	public FoodOrderImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	
	@Override
	public boolean saveorder(List<Food_Order> flist) {
		boolean f1=false;
		try {
			String sql="insert into food_orders(order_id,user_name,email,address,phone,food_name,price,payment)values(?,?,?,?,?,?,?,?)";
			
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(sql);
			
			for (Food_Order f :flist) 
			{
				ps.setString(1,f.getOrderId());
				ps.setString(2, f.getUserName());
				ps.setString(3, f.getEmail());
				ps.setString(4, f.getFulladd());
				ps.setString(5, f.getPhone());
				ps.setString(6, f.getFoodname());
				ps.setString(7, f.getPrice());
				ps.setString(8, f.getPaymentType());
				
				
				ps.addBatch();
			}
			int[] count=ps.executeBatch();
			conn.commit();
			f1=true;
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f1;
	}


	@Override
	public List<Food_Order> getfood(String email){
	List<Food_Order> list=new ArrayList<Food_Order>();
	Food_Order o=null;
	
		
		try {
			String sql="select * from food_orders where email=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				o=new Food_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setFoodname(rs.getString(7));
				o.setPrice(rs.getString(8));
				o.setPaymentType(rs.getString(9));
				list.add(o);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<Food_Order> getfoodAllOrder() {
	
		List<Food_Order> list=new ArrayList<Food_Order>();
		Food_Order o=null;
		
			
			try {
				String sql="select * from food_orders";
				PreparedStatement ps=conn.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					o=new Food_Order();
					o.setId(rs.getInt(1));
					o.setOrderId(rs.getString(2));
					o.setUserName(rs.getString(3));
					o.setEmail(rs.getString(4));
					o.setFulladd(rs.getString(5));
					o.setPhone(rs.getString(6));
					o.setFoodname(rs.getString(7));
					o.setPrice(rs.getString(8));
					o.setPaymentType(rs.getString(9));
					list.add(o);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
	

	
	
	
	

}
