package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.FoodDtls;

public class FoodDAOImpl implements FoodDAO{
	
	
	private Connection conn;
	

	public FoodDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addFoods(FoodDtls f) {
		boolean f1=false;
	try {
		String sql="insert into fooddtls(foodname,price,photoname,email,foodtype,status) values(?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,f.getFoodname());
		ps.setString(2, f.getPrice());
	    ps.setString(3, f.getphotoname());
		ps.setString(4, f.getEmail());
		ps.setString(5, f.getFoodtype());
		ps.setString(6, f.getStatus());
		
		int i=ps.executeUpdate();
		
		if(i==1) {
			f1= true;
			System.out.println("succe");
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return f1;
	}


	@Override
	public List<FoodDtls> getallfoods() {
		
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls b=null; 
		
	try {
		String sql="select *from fooddtls";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) 
		{
			
			b=new FoodDtls();
			b.setId(rs.getInt(1));
			b.setFoodname(rs.getString(2));
			b.setPrice(rs.getString(3));
			b.setphotname(rs.getString(4));
			b.setEmail(rs.getString(5));
			b.setFoodtype(rs.getString(6));
			b.setStatus(rs.getString(7));
			
			list.add(b);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	
		return list;
	}


	@Override
	public FoodDtls getfoodbyId(int id) {
		FoodDtls b=null;
		try {
			String sql="select * from fooddtls where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				b=new FoodDtls();
				b.setId(rs.getInt(1));
				b.setFoodname(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setphotname(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setFoodtype(rs.getString(6));
				b.setStatus(rs.getString(7));
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}


	@Override
	public boolean updateEditFoods(FoodDtls b) {
		boolean f1=false;
		try {
			
			String sql=" update fooddtls set foodname=?,price=?,status=? where id=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,b.getFoodname());
			ps.setString(2,b.getPrice());
			ps.setString(3,b.getStatus());
			ps.setInt(4,b.getId());
			
			
			int i=ps.executeUpdate();
			if(i==1) 
			{
				f1=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f1;
	}


	@Override
	public boolean deleteFoods(int id) {
		boolean f1=false;
		try {
			String sql="delete from fooddtls where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f1=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f1;
	}


	@Override
	public List<FoodDtls> getvegFoods() {
		
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls b=null;
		try {
			String sql="select * from fooddtls  where foodtype=? and status=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "veg");
			ps.setString(2, "Available");
			
			ResultSet  rs=ps.executeQuery();
			int i=1;
			while (rs.next() && i<=4) 
			{
				b=new FoodDtls();
				b.setId(rs.getInt(1));
				b.setFoodname(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setphotname(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setFoodtype(rs.getString(6));
				b.setStatus(rs.getString(7));
				list.add(b);
				i++;
			}
				
		} catch (Exception e) {
			e.printStackTrace();	
			}
		return list;
	}


	@Override
	public List<FoodDtls> getrecentfoods() {
		
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls b=null;
		try {
			String sql="select * from fooddtls  where status=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Available");
			
			ResultSet  rs=ps.executeQuery();
			int i=1;
			while (rs.next() && i<=4) 
			{
				b=new FoodDtls();
				b.setId(rs.getInt(1));
				b.setFoodname(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setphotname(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setFoodtype(rs.getString(6));
				b.setStatus(rs.getString(7));
				list.add(b);
				i++;
			}
				
		} catch (Exception e) {
			e.printStackTrace();	
			}
		return list;
	}


	@Override
	public List<FoodDtls> getnonvegfoods() {
	
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls b=null;
		try {
			String sql="select * from fooddtls  where foodtype=? and status=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Nonveg");
			ps.setString(2, "Available");
			
			ResultSet  rs=ps.executeQuery();
			int i=1;
			while (rs.next() && i<=4) 
			{
				b=new FoodDtls();
				b.setId(rs.getInt(1));
				b.setFoodname(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setphotname(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setFoodtype(rs.getString(6));
				b.setStatus(rs.getString(7));
				list.add(b);
				i++;
			}
				
		} catch (Exception e) {
			e.printStackTrace();	
			}
		return list;
	}


	@Override
	public List<FoodDtls> getallrecentorderfoods() {
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls b=null;
		try {
			String sql="select * from fooddtls  where status=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Available");
			
			ResultSet  rs=ps.executeQuery();
	
			while (rs.next()) 
			{
				b=new FoodDtls();
				b.setId(rs.getInt(1));
				b.setFoodname(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setphotname(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setFoodtype(rs.getString(6));
				b.setStatus(rs.getString(7));
				list.add(b);
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();	
			}
		return list;
	}


	@Override
	public List<FoodDtls> getallvegfoods() {
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls b=null;
		try {
			String sql="select * from fooddtls  where foodtype=? and status=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "veg");
			ps.setString(2, "Available");
			
			ResultSet  rs=ps.executeQuery();
			
			while (rs.next()) 
			{
				b=new FoodDtls();
				b.setId(rs.getInt(1));
				b.setFoodname(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setphotname(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setFoodtype(rs.getString(6));
				b.setStatus(rs.getString(7));
				list.add(b);
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();	
			}
		return list;
	}


	@Override
	public List<FoodDtls> getallnonvegfoods() {
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls b=null;
		try {
			String sql="select * from fooddtls  where foodtype=? and status=? order by id DESC";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Nonveg");
			ps.setString(2, "Available");
			
			ResultSet  rs=ps.executeQuery();

			while (rs.next()) 
			{
				b=new FoodDtls();
				b.setId(rs.getInt(1));
				b.setFoodname(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setphotname(rs.getString(4));
				b.setEmail(rs.getString(5));
				b.setFoodtype(rs.getString(6));
				b.setStatus(rs.getString(7));
				list.add(b);

			}
				
		} catch (Exception e) {
			e.printStackTrace();	
			}
		return list;
	}


	@Override
	public List<FoodDtls> getFoodBySerch(String ch) {
		
		
		List<FoodDtls> list=new ArrayList<FoodDtls>();
		FoodDtls f=null;
		try {
			String sql="select * from fooddtls where  foodname like ? or foodtype  like ? and  status=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "Available");
		
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				f=new FoodDtls();
				f.setId(rs.getInt(1));
				f.setFoodname(rs.getString(2));
				f.setPrice(rs.getString(3));
				f.setphotname(rs.getString(4));
				f.setEmail(rs.getString(5));
				f.setFoodtype(rs.getString(6));
				f.setStatus(rs.getString(7));
				list.add(f);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
		
		
		
	}
	
	
	
}
