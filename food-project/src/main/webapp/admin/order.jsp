<%@page import="com.entity.Food_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.FoodOrderImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin:All Orders</title>

<%@include file="allCss.jsp" %>
</head>
<body>

<%@include file="navbar.jsp" %>
<c:if test="${empty userobj}">
<c:redirect url="../login.jsp"/>
</c:if>
<h3 class="text-center">Hello Admin</h3>
<table class="table table-striped  ">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">order id</th>
      <th scope="col">food name</th>
       <th scope="col">email</th>
      <th scope="col">address</th>
      <th scope="col">phone number</th>
      <th scope="col">price</th>
      <th scope="col">payment type</th>
      
    </tr>
  </thead>
  <tbody>
  
  <% 
  FoodOrderImpl dao=new FoodOrderImpl(DBconnect.getConn());
  List<Food_Order> flist=dao.getfoodAllOrder();
  for(Food_Order f:flist)
  {%>
	    <tr>
      <th scope="row"><%=f.getOrderId() %></th>
      <td><%=f.getFoodname() %></td>
      <td><%=f.getEmail() %></td>
      <td><%=f.getFulladd() %></td>
      <td><%=f.getPhone() %></td>
      <td><%=f.getPrice() %></td>
      <td><%=f.getPaymentType() %></td>
   
    </tr>
  <%}
  %>
  

  </tbody>
</table>
</body>
</html>