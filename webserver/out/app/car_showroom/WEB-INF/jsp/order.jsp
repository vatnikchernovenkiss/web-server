<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
    <title>Order with date ${order.date_and_time}
    </title>
</head>
<body>
	<h1>Order with date ${order.date_and_time}</h1>
	 <br>
	<table>
		<tr>
			<th>Date and time</th>
			<th>Car</th>
			<th>If test-drive required</th>
			<th>Client</th>
			<th>Status</th>
		</tr>
		<tr>
			<td>${order.date_and_time}</td>
			<td>${order.car_id.registration_number}</td>
			<td>${order.if_test_drive_required}</td>
			<td>${order.client_id.full_name}</td>
			<td>${order.current_status}</td>
		</tr>
	</table> 
		<h1>Update order</h1>
	<c:url value="/order" var="var"/>
	<form:form modelAttribute = "form" action="${var}" method="POST">
		 <form:input type="hidden" path="id" value="${form.id}"/>
		 <label for = "date">Date and time</label>
		 <form:input  type = "text" path = "date_and_time" id = "date"/>
		 <br>
	     <label for = "if_test_drive_required">If test-drive required</label>
		 <form:select path="if_test_drive_required" id="if_test_drive_required">
	        <option value="true">True</option>
	        <option value="false">False</option>
  	     </form:select>
  	     <br> 
  	    <label for="status">Status</label>
    	<form:select path="current_status" id="status">
	        <option value="processing">processing</option>
	        <option value="test_drive">test_drive</option>
	        <option value="done">done</option>
	        <option value="ready">ready</option>
	        <option value="supply">supply</option>
  	    </form:select>
  	    <br> 
		<input type="submit" value="Update order" id = "submit">
	</form:form>
	<a href = "order_del?id=${order.id}">
		<button>Delete this order</button>
	</a>
	<br>
	<a href = "/">
		<button>Home</button>
	</a>
</body>
</html>