package com.admin.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.FoodDAOImpl;
import com.DB.DBconnect;
import com.entity.FoodDtls;

@WebServlet("/editfoods")
public class Editfoodservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		String foodname = req.getParameter("fname");
		String price = req.getParameter("price");
		String status=req.getParameter("status");
	    
		FoodDtls b=new FoodDtls();
		b.setId(id);
		b.setFoodname(foodname);
		b.setPrice(price);
		b.setStatus(status);
		
		FoodDAOImpl dao=new FoodDAOImpl(DBconnect.getConn());
		boolean f=dao.updateEditFoods(b);
		
	    HttpSession session=req.getSession();
	    if (f) {
			session.setAttribute("succMsg", "Food Update Succesfully");
			resp.sendRedirect("admin/all_foods.jsp");
		} else {
			session.setAttribute("failed", "something wrong");
			resp.sendRedirect("admin/all_foods.jsp");
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}
