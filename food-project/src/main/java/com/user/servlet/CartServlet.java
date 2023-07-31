package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.FoodDAOImpl;
import com.DB.DBconnect;
import com.entity.Cart;
import com.entity.FoodDtls;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int fid=Integer.parseInt(req.getParameter("fid"));
			int uid=Integer.parseInt(req.getParameter("uid"));
			
			FoodDAOImpl dao=new FoodDAOImpl(DBconnect.getConn());
			FoodDtls f=dao.getfoodbyId(fid);
			
		 Cart c=new Cart();
		 c.setFid(fid);
		 c.setUserId(uid);
		 c.setFoodname(f.getFoodname());
		 c.setPrice(Double.parseDouble(f.getPrice()));
         c.setTotalprice(Double.parseDouble(f.getPrice()));	
         
         
         CartDAOImpl dao2=new CartDAOImpl(DBconnect.getConn());
         boolean f1=dao2.addCart(c);
         
         HttpSession session=req.getSession();
         
         if(f1) {
        	 session.setAttribute("addCart","Food Added to Cart");
        	 resp.sendRedirect("all_veg_foods.jsp");
        	 
         }else {
         	 session.setAttribute("failed"," Somrthing wrong on server");
        	 resp.sendRedirect("all_veg_foods.jsp");
         }
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	

	
	
	
}
