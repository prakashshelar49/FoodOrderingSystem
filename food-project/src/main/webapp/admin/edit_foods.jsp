<%@page import="com.entity.FoodDtls"%>
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
<title>Admin:Add Foods</title>
<%@include file="allCss.jsp" %>
</head>
<body style="background-color:#f0f2f2;">
<%@include file="navbar.jsp" %>
<div class="caontainer">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h4 class="text-center">Edit Foods</h4>



<%
int id=Integer.parseInt(request.getParameter("id"));
FoodDAOImpl dao=new FoodDAOImpl(DBconnect.getConn());
FoodDtls b=dao.getfoodbyId(id);

%>

<form action="../editfoods" method="post">
<input type="hidden" name="id" value="<%=b.getId()%>">


<div class="form-group">
<label for="exampleInputEmail">food name*</label>
<input name="fname" type="text" class="form-control"
id="exampleInputEmail" aria-describedby="emailHelp" value="<%=b.getFoodname() %>">
</div>

<div class="form-group">
<label for="exampleInputPassword1">price*</label>
<input name="price" type="number" class="form-control"
id="exampleInputPassword1" value="<%=b.getPrice()%>">
</div>



<div class="form-group">

<label for="inputState">Food Status</label> 
<select id="inputState" name="status" class="form-control"> 
<%
if("Available".equals(b.getStatus())){
%>
 <option value="Available">Available</option>
 <option value="Not Available">Not Available</option>
	
	<%
	}else{
	%>
	 <option value="Not Available">Not Available</option>
	 <option value="Available">Available</option>
	<%
	}
	%>


 
</select>

</div>


  <button type="submit" class="btn btn-primary">update</button>



</form>



</div>
</div>

</div>
</div>
</div>
</body>
</html>