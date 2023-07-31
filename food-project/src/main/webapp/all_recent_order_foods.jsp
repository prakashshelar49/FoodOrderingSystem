<%@page import="com.entity.User"%>
<%@page import="com.entity.FoodDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.FoodDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Recent Order Foods</title>
<%@include file="all_component/allCss.jsp" %>
<style type="text/css">
 
.crd-ho:hover{
background-color:#fcf0f0;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
<%
User u=(User)session.getAttribute("userobj");
%>
<%@include file="all_component/navbar.jsp"%>
<div class="container.fluid">
<div class="row p-3">


<%
FoodDAOImpl dao2=new FoodDAOImpl(DBconnect.getConn());
List<FoodDtls> list2=dao2.getallrecentorderfoods();
for(FoodDtls b:list2){
%>

	<div class="col-md-3">
<div class="card crd-ho mt-2">
<div class="card-body text-center">
<img alt="" src="foods/<%=b.getphotoname() %>" 
style="width:100px; height:150px"  class="img-thumblin">
<p><%=b.getFoodname() %></p>
<p>Food Type:<%=b.getFoodtype() %> </p>
<div class="row">
<% 
if(u==null){
%>
	<a href="login.jsp" class="btn btn-danger btn-sm ml-5">Add Cart</a>
	<%
	}else{
	%>
	<a href="cart?fid=<%=b.getId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-5">Add Cart</a>
	<%
	}
	%>

<a href="" class="btn btn-danger btn-sm ml-1 "><%=b.getPrice() %><i class="fas fa-rupee-sign"></i></a>
</div>
</div>
</div>
</div>
	
	<%}
%>
</div>
</div>

</body>
</html>