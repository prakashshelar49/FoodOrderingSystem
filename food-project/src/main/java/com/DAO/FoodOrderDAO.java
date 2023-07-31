package com.DAO;

import java.util.List;

import com.entity.Food_Order;

public interface FoodOrderDAO {


	
    public boolean saveorder(List<Food_Order> flist);
    
    public List<Food_Order> getfood(String email);
    
    public List<Food_Order> getfoodAllOrder();
}
