<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp" %>
<style type="text/css">
a{
text-decoration:none;
color:black;
}
a:hover{
text-decoration:none;
}
</style>

</head>
<body style="background-color: #f5f0f0;">
<c:if test="${empty userobj}">
<c:redirect url="login.jsp"/>
</c:if>

<%@include file="all_component/navbar.jsp"%>


<div class="container">

<h3 class="text-center">Hello,${userobj.name}</h3>


<div class="row p-5">




<div class="col-md-4 mt-3">
<a href="edit_profile.jsp">
<div class="card">
<div class="card-body text-center">
<div class="text-primary">
<i class="fas fa-edit fa-3x"></i>
</div>
<h4>Login and Security</h4>
<p>Edit Profile</p>
</div>
</div>
</a>
</div>




<div class="col-md-6 mt-3">
<a href="order.jsp">
<div class="card" >
<div class="card-body text-center">
<div class="text-danger">
<i class="fas fa-box fa-3x"></i>
</div>
<h4>My order</h4>
<p>Track your order</p>
</div>
</div>
</a>
</div>



<div class="col-md-6 mt-3">
<a href="helpline.jsp ">
<div class="card" >
<div class="card-body text-center">
<div class="text-primary">
<i class="fas fa-user fa-3x"></i>
</div>
<h4>Help Center</h4>
<p>24 hrs service</p>
</div>
</div>
</a>
</div>


</div>

</div>

</body>
</html>