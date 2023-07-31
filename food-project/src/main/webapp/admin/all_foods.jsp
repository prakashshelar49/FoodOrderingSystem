<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.entity.FoodDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.FoodDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin:All Foods</title>

<%@include file="allCss.jsp" %>
</head>
<body>

<%@include file="navbar.jsp" %>

<c:if test="${empty userobj}">
<c:redirect url="../login.jsp"/>
</c:if>

<h3 class="text-center">Hello Admin</h3>

<c:if test="${not empty succMsg }">
<h5 class="text-center text-success">${succMsg}</h5>
<c:remove var="succMsg" scope="session"/>
</c:if>

<c:if test="${not empty failed}">
<h5 class="text-center text-danger">${failed}</h5>
<c:remove var="failed" scope="session"/>
</c:if>

<table class="table table-striped  ">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">id</th>
      <th scope="col">Image</th>
      <th scope="col">food name</th> 
      <th scope="col">price</th>
       <th scope="col">food type</th>
       <th scope="col">status</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
  <%
  FoodDAOImpl dao=new FoodDAOImpl(DBconnect.getConn());
  List<FoodDtls>  list=dao.getallfoods();
  for(FoodDtls b:list)
  {
	  %>
	   <tr>
      <td ><%=b.getId() %></td>
      <td><img src="../book/<%=b.getphotoname()%>"
	  style="width: 50px; height: 50px;"></td>
					
   <td><%=b.getFoodname()%></td>   
   <td><%=b.getPrice()%></td>
   <td><%=b.getFoodtype() %></td>
   <td><%=b.getStatus() %></td>
     
    <td>
    <a href="edit_foods.jsp?id=<%=b.getId()%>" class="btn btn-sm btn-primary"><i class="fas fa-edit"></i>Edit</a>
        <a href="../delete?id=<%=b.getId() %>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i>Delete</a>
    </td>
    </tr>
	  <% 
  }
  %>
   

  </tbody>
</table>
</body>
</html>