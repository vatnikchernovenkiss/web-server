<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clients</title>
</head>
<body>
	<h1> Table with all present clients. Their count is:${clients.size()}</h1>
	<table id = "Clienttable">
		<tr>
			<th>Full name</th>
			<th>E-mail</th>
			<th> Address </th>
			<th>Phone</th>
			<th>Password</th>
		</tr>
		<tr>
		    <td><input type="text" id="name" class="search_icon" onkeyup="FilterFunction(0, id)" placeholder="Search by registration name..."></td>
	        <td><input type="text" id="e_mail" class="search_icon" onkeyup="FilterFunction(1, id)" placeholder="Search by e-mail.."></td>
	        <td><input type="text" id="address" class="search_icon" onkeyup="FilterFunction(2, id)" placeholder="Search by address"></td>
	        <td><input type="text" id="phone" class="search_icon" onkeyup="FilterFunction(3, id)" placeholder="Search by phone .."></td>
   		 </tr>
	   	<c:forEach items="${clients}" var="client">
	    <tr>
	        <td>
	        <a href = "client?id=${client.id}">
	         ${client.full_name}
	         </a>
	        </td>
	        <td>${client.e_mail}</td>
	        <td>${client.address}</td>
	        <td>${client.phone}</td>
	        <td>${client.hashed_password}</td>
	    </tr>
		</c:forEach>
	</table>
	<br>
<a href="client_add">
         <button>Add new client</button>
    </a>
</body>
</html>