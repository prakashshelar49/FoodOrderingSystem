<%@page import="com.entity.Food_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.FoodOrderImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${empty userobj}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
	
	
	<div class="container p-2">
	<h3 class="text-center text-primary p-1">Your Orders</h3>
		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order ID</th>
					<th scope="col">Name</th>
					<th scope="col">Food Name</th>
					
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			User u=(User)session.getAttribute("userobj");
			FoodOrderImpl dao=new FoodOrderImpl(DBconnect.getConn());
			List<Food_Order> flist=dao.getfood(u.getEmail());
			for(Food_Order f:flist)
			{%>
				
			<tr>
					<th scope="row"><%=f.getOrderId() %></th>
					<td><%=f.getUserName() %></td>
					<td><%=f.getFoodname() %></td>
					
					<td><%=f.getPrice() %></td>
					<td><%=f.getPaymentType() %></td>
					
				</tr>
			<%}
			
			%>
				
		
			</tbody>
		</table>

	</div>

</body>
</html>