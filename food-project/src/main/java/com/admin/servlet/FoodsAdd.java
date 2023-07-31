package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.FoodDAOImpl;
import com.DB.DBconnect;
import com.entity.FoodDtls;

@WebServlet("/add_foods")
@MultipartConfig
public class FoodsAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String foodname = req.getParameter("fname");
			String price = req.getParameter("price");
			String foodtype = req.getParameter("type");
			String status = req.getParameter("status");
			Part part = req.getPart("fimg");
			String fileName = part.getSubmittedFileName();
			FoodDtls food = new FoodDtls(foodname, price, foodtype, status, fileName, "admin");
			//System.out.println(food);

			FoodDAOImpl dao = new FoodDAOImpl(DBconnect.getConn());
			
			
			
			  boolean f1=dao.addFoods(food); 
			  HttpSession session=req.getSession();
			  
			
			  if(f1) {
				  String path=getServletContext().getRealPath("")+"foods";
					File file=new File(path);
					part.write(path+File.separator+fileName);
					 
			  session.setAttribute("succMsg","food add sucessfully");
			  resp.sendRedirect("admin/add_foods.jsp"); 
			  } else {
			  session.setAttribute("failed","somethig wrong");
			  resp.sendRedirect("admin/add_foods.jsp"); 
			  }
			  
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
