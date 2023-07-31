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


<c:if test="${empty userobj}">
<c:redirect url="../login.jsp"/>
</c:if>

<div class="caontainer">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h4 class="text-center">Add Foods</h4>

<c:if test="${not empty succMsg }">
<p class="text-center text-success">${succMsg}</p>
<c:remove var="succMsg" scope="session"/>
</c:if>

<c:if test="${not empty failed}">
<p class="text-center text-danger">${failed}</p>
<c:remove var="failed" scope="session"/>
</c:if>

<form action="../add_foods" method="post"
enctype="multipart/form-data">

<div class="form-group">
<label for="exampleInputEmail">food name*</label>
<input name="fname" type="text" class="form-control"
id="exampleInputEmail" aria-describedby="emailHelp">
</div>

<div class="form-group">
<label for="exampleInputPassword1">price*</label>
<input name="price" type="number" class="form-control"
id="exampleInputPassword1">
</div>

<div class="form-group">

<label for="inputState">Food Type</label>
 <select id="inputState" name="type" class="form-control">
 <option selected>--select--</option>
  <option value="veg">veg food</option>
   <option value="Nonveg">Nonveg food</option>
</select>
</div>

<div class="form-group">

<label for="inputState">Food Status</label> 
<select id="inputState" name="status" class="form-control"> 
<option selected>--select--</option>
 <option value="Available">Available</option> 
 <option value="Not Available">Not Available</option>

</select>

</div>


<div class="form-group">
<label for="exampleIFormControlFile1">Upload Photo</label><input
name="fimg" type="file" class="form-control-file"
id="exampleFormControlFile1">
</div>
  <button type="submit" class="btn btn-primary">Add</button>



</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>