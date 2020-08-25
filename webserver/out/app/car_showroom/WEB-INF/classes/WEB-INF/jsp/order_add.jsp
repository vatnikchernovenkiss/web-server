<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
<meta charset="UTF-8">
	<title>Add order</title>
</head>
<body>
	<h1>Add new order</h1>
	<c:url value="/order_add" var="var"/>
	<form:form modelAttribute = "form" action="${var}" method="POST">
		 <label for = "date">Date and time</label>
		 <form:input placeholder = "yyyy-mm-dd hh:mm:ss" type = "text" path = "date_and_time" id = "date"/>
		 <br>
		 <label for = "car">Car </label>
		 <form:select  path="car_id" id="car">
            <c:forEach items="${cars}" var="car">
                <option value="${car.id}" id = "${car.registration_number}">${car.registration_number}</option>
            </c:forEach>
        </form:select> 
        <br>
	     <label for = "if_test_drive_required">If test-drive required</label>
		 <form:select path="if_test_drive_required" id="if_test_drive_required">
	        <option value="true">True</option>
	        <option value="false">False</option>
  	     </form:select>
  	     <br> 
  	     <label for = "client"> Client </label>
		 <form:select  path="client_id" id="client">
            <c:forEach items="${clients}" var="client">
                <option value="${client.id}" id = "${client.full_name}">${client.full_name}</option>
            </c:forEach>
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
		<input type="submit" value="Add order" id = "submit">
	</form:form>
</body>
</html>