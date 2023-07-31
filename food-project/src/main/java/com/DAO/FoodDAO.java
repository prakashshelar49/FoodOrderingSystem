package com.DAO;

import java.util.List;

import com.entity.FoodDtls;

public interface FoodDAO {

	public boolean addFoods(FoodDtls f);
	
	public List<FoodDtls> getallfoods();
	
	public FoodDtls getfoodbyId(int id);
	
	public boolean updateEditFoods(FoodDtls b);
	
	public  boolean deleteFoods(int id);
	
	public List <FoodDtls> getvegFoods();
	
	public List<FoodDtls> getrecentfoods();
	
	public List<FoodDtls> getnonvegfoods();
	
	
	
	public List<FoodDtls> getallrecentorderfoods();
	
	public List<FoodDtls> getallvegfoods();
	
	public List<FoodDtls> getallnonvegfoods();
	
	public List<FoodDtls> getFoodBySerch(String ch);
}
