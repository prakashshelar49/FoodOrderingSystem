<%@page import="com.entity.User"%>
<%@page import="com.DAO.FoodDAOImpl"%>
<%@page import="com.entity.FoodDtls"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="com.DB.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>food shop</title>
<%@include file="all_component/allCss.jsp" %>
<style type="text/css">
.back-img{
background: url("img/foodhome.jpeg");
height: 90vh;
width:100%;
background-repeat: no-repeat;
background-size: cover;
}

.crd-ho:hover{
background-color:#fcf0f0;
}
</style>
</head>
<body style="background-color: #f5f0f0;">

<%
User u=(User)session.getAttribute("userobj");
%>


<%@include file="all_component/navbar.jsp"%>
<div class="container-fluid back-img">
<h2 class="text-center text-white"> food ordering system</h2>
</div>


<!--  start foods -->

<div class="container" >
<h3 class="text-center">Recent order foods </h3>
<div class="row">
<%
FoodDAOImpl dao2=new FoodDAOImpl(DBconnect.getConn());
List<FoodDtls> list2=dao2.getrecentfoods();
for(FoodDtls f:list2){
%>

	<div class="col-md-3">
<div class="card crd-ho">
<div class="card-body text-center">
<img alt="" src="foods/<%=f.getphotoname() %>" 
style="width:180px; height:180px"  class="img-thumblin">
<p><%=f.getFoodname() %></p>
<p>Food Type:<%=f.getFoodtype() %> </p>
<div class="row">
<% 
if(u==null){
%>
	<a href="login.jsp" class="btn btn-danger btn-sm ml-5">Add Cart</a>
	<%
	}else{
	%>
	<a href="cart?fid=<%=f.getId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-5">Add Cart</a>
	<%
	}
	%>


<a href="" class="btn btn-danger btn-sm ml-1"><%=f.getPrice() %><i class="fas fa-rupee-sign"></i></a>
</div>
</div>
</div>
</div>
	
	<%}
%>

</div>
<div class="text-center mt-1">
<a href="all_recent_order_foods.jsp" class="btn btn-danger btn-sm text-white">View  all</a>
</div>
</div>
<!-- end of foods -->



<hr>
<!-- start veg  foods  -->

<div class="container" >
<h3 class="text-center">Veg foods</h3>
<div class="row">

<%
FoodDAOImpl dao=new FoodDAOImpl(DBconnect.getConn());
List<FoodDtls> list=dao.getvegFoods();
for(FoodDtls f:list)
{
%>
<div class="col-md-3">
<div class="card crd-ho">
<div class="card-body text-center">
<img alt="" src="foods/<%=f.getphotoname() %>" 
style="width:180px; height:180px"  class="img-thumblin">
<p><%=f.getFoodname() %></p>
<p>Food Type:<%=f.getFoodtype() %></p>
<div class="row">
<% 
if(u==null){
%>
	<a href="login.jsp" class="btn btn-danger btn-sm ml-5">Add Cart</a>
	<%
	}else{
	%>
	<a href="cart?fid=<%=f.getId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-5">Add Cart</a>
	<%
	}
	%>


<a href="" class="btn btn-danger btn-sm ml-1 "><%=f.getPrice() %><i class="fas fa-rupee-sign"></i></a>
</div>
</div>
</div>
</div>
<%
} 
%>


</div>
<div class="text-center mt-1">
<a href="all_veg_foods.jsp" class="btn btn-danger btn-sm text-white">View  all</a>
</div>
</div>

<!--  end of veg foods -->

<hr>
<!-- start nonveg foods  -->

<div class="container" >
<h3 class="text-center">Nonveg food</h3>
<div class="row">
<%
FoodDAOImpl dao3=new FoodDAOImpl(DBconnect.getConn());
List<FoodDtls> list3=dao3.getnonvegfoods();
for(FoodDtls b:list3)
{
%>
<div class="col-md-3">
<div class="card crd-ho">
<div class="card-body text-center">
<img alt="" src="foods/<%=b.getphotoname() %>" 
style="width:180px; height:180px"  class="img-thumblin">
<p><%=b.getFoodname() %></p>
<p>Food Type:<%=b.getFoodtype() %> </p>
<div class="row">
<a href="" class="btn btn-danger btn-sm ml-5">Add cart<i class="fas fa-cart-plus"></i></a>

<a href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice() %><i class="fas fa-rupee-sign"></i></a>
</div>
</div>
</div>
</div>
	
	<%
	}
%>




</div>
<div class="text-center mt-1">
<a href="all_nonveg_foods.jsp" class="btn btn-danger btn-sm text-white">View  all</a>
</div>
</div>

<!--  end of old foods -->
</body>
</html>