package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBconnect;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String name=req.getParameter("fname");
			String email=req.getParameter("email");
			String phonenumber=req.getParameter("phonenumber");
			String password=req.getParameter("password");
			String check=req.getParameter("check");
			
		//	System.out.println(name+" "+email+" "+phonenumber+" "+password+" "+check);
			
			User us=new User();
			
			us.setName(name);
			us.setEmail(email);
			us.setPhonenumber(phonenumber);
			us.setPassword(password);
			
			
			HttpSession session=req.getSession();
			
			if(check!=null)
			{
				UserDAOImpl dao=new UserDAOImpl(DBconnect.getConn());
			    
				boolean f2=dao.CheckUser(email);
				if(f2) {
					 boolean f=dao.userRegister(us);
						
						if (f) 
						{
							//System.out.println("user register sucessfully");
							session.setAttribute("succMsg","Registration sucessfully");
							resp.sendRedirect("register.jsp");
						}else {
							//System.out.println("something wrong");
							session.setAttribute("failed","something wrong");
							resp.sendRedirect("register.jsp");
						}	
				}else {
					session.setAttribute("failed","User Already exist");
					resp.sendRedirect("register.jsp");
				}
			}else {
				//System.out.println("Please Check Agree & Terms Condition");
				session.setAttribute("failed","Please Check Agree & Terms Condition");
				resp.sendRedirect("register.jsp");
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
