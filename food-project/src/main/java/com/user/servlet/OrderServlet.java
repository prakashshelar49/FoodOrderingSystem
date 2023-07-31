package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.FoodOrderImpl;
import com.DB.DBconnect;
import com.entity.Cart;
import com.entity.Food_Order;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session=req.getSession();
			
			int id=Integer.parseInt(req.getParameter("id"));
			
			String name=req.getParameter("username");
			String email=req.getParameter("email");
			String phone=req.getParameter("phno");
			String address=req.getParameter("address");
			String landmark=req.getParameter("landmark");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String zip=req.getParameter("zip");
			String paymentType=req.getParameter("payment");
			
			
			String fullAdd=address+","+landmark+","+city+","+state+","+zip;
		//System.out.println(name+","+email+","+phone+","+fullAdd+","+paymentType);
			
			CartDAOImpl dao=new CartDAOImpl(DBconnect.getConn());
			
			List<Cart> flist=dao.getFoodByUser(id);

			if(flist.isEmpty()) {
				session.setAttribute("failed", "ADD FOODS");
				resp.sendRedirect("checkout.jsp");
			}else {
				
				FoodOrderImpl dao2=new FoodOrderImpl(DBconnect.getConn());
				
				
				Food_Order o=null;
				
				
				
				
				ArrayList<Food_Order>  orderlist=new ArrayList<Food_Order>();
				Random r=new Random();
				
				for(Cart c:flist) {
					o=new Food_Order();
					
					//System.out.println(c.getFoodname()+","+c.getPrice());
					o.setOrderId("food-DRD-00"+r.nextInt(1000));
					o.setUserName(name);
					o.setEmail(email);
					o.setPhone(phone);
					o.setFulladd(fullAdd);
					o.setPaymentType(paymentType);
					o.setFoodname(c.getFoodname());
					o.setPrice(c.getPrice()+"");
					
					orderlist.add(o);
					
					
				}
				
				if("noselect".equals(paymentType)) {
					session.setAttribute("failed", "choose payment method");
					resp.sendRedirect("checkout.jsp");
				}
				else {
					boolean f1=dao2.saveorder(orderlist);
					if(f1)
					{
						resp.sendRedirect("order_sucess.jsp");
				
					}else {
						session.setAttribute("failed", "Your Order Failed");
						resp.sendRedirect("checkout.jsp");
					}
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
