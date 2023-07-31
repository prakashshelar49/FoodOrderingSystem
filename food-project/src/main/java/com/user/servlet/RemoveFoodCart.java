package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DB.DBconnect;


@WebServlet("/remove_food")
public class RemoveFoodCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int fid = Integer.parseInt(req.getParameter("fid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		CartDAOImpl dao=new CartDAOImpl(DBconnect.getConn());
		
	boolean f=dao.deleteFood(fid,uid,cid);
	HttpSession session=req.getSession();
	
	if(f) {
		session.setAttribute("succMsg", "Food Remove From Cart");
		resp.sendRedirect("checkout.jsp");
	}else {
		session.setAttribute("failed","Somethimg Wrong on Server");
		resp.sendRedirect("checkout.jsp");
	}
	}

	
	
}
