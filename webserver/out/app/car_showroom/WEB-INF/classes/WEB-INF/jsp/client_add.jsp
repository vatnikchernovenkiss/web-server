<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
<meta charset="UTF-8">
	<title>Add client</title>
</head>
<body>
	<h1>Add new client</h1>
	<c:url value="/client_add" var="var"/>
	<form:form modelAttribute = "form" action="${var}" method="POST">
  	    <label for = "full_name">Full name</label>
		<form:input placeholder = "Ivanov Ivan" type = "text" path = "full_name" id = "full_name"/>
  	    <br> 
  	    <label for = "e-mail">E-mail</label>
		<form:input placeholder = "a@mail.ru" type = "text" path = "e_mail" id = "e-mail"/>
		<br>
		<label for = "address">Address</label>
		<form:input placeholder = "Moscow-City" type = "text" path = "address" id = "address"/>
		<br>
		<label for = "phone">Phone</label>
		<form:input placeholder = "8-800-555-35-35" type = "text" path = "phone" id = "phone"/>
		<br>
		<label for = "password">Password</label>
		<form:input placeholder = "***" type = "number" path = "hashed_password" id = "password"/>
		<br>
		<input type="submit" value="Add client" id = "submit">
	</form:form>
</body>
</html>