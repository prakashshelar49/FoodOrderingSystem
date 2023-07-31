package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.FoodDAOImpl;
import com.DB.DBconnect;

@WebServlet("/delete")
public class FoodsDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			
			FoodDAOImpl dao=new FoodDAOImpl(DBconnect.getConn());
			boolean f=dao.deleteFoods(id);
			 HttpSession session=req.getSession();
			 
			    if (f) {
					session.setAttribute("succMsg", "Food delete Succesfully");
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
