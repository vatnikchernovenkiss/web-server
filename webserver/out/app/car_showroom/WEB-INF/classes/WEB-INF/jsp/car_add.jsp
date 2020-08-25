<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
<meta charset="UTF-8">
<title>Add new car</title>
</head>
<body>
	<h1>Add new car</h1>
	<c:url value="/car_add" var="var"/>
	<form:form modelAttribute = "form" action="${var}" method="POST">
		 <label for = "number">Registration number</label>
		 <form:input placeholder = "аа000аа" type = "text" path = "registration_number" id = "number"/>
		 <br>
		  <label for = "devices">Devices </label>
		 <form:select multiple="true" path="devices_id" id="devices">
            <c:forEach items="${devices}" var="device">
                <option value="${device.id}" id = "${device.name}">${device.name}</option>
            </c:forEach>
            <option value="">None</option>
        </form:select>
        <br> 
		<label for = "clients">Test-drive clients </label>
		 <form:select multiple="true" path="test_drive_clients_id" id="clients">
            <c:forEach items="${clients}" var="client">
                <option value="${client.id}" id = "${client.full_name}">${client.full_name}</option>
            </c:forEach>
            <option value="">None</option>
        </form:select> 
        <br>  
        <label for = "developer">Developer </label>
		 <form:select  path="developer_id" id="developer">
            <c:forEach items="${developers}" var="developer">
                <option value="${developer.id}" id = "${developer.name}">${developer.name}</option>
            </c:forEach>
            <option value="">None</option>
        </form:select> 
        <br>  
        <label for = "model">Model</label>
		 <form:select  path="model_id" id="model">
            <c:forEach items="${models}" var="model">
                <option value="${model.id}" id = "${model.title}">${model.title}</option>
            </c:forEach>
            <option value="">None</option>
        </form:select> 
        <br>  
        <label for="upholstery">Upholstery type</label>
    	<form:select path="upholstery_type" id="upholstery">
	        <option value="Leather">Leather</option>
	        <option value="Cotton">Cotton</option>
	        <option value="Polyester">Polyester</option>
	        <option value="Faux_Leather">Faux Leather</option>
	        <option value="Olefin">Olefin</option>
  	    </form:select>
  	    <br>
  	    <label for="colour">Car colour</label>
    	<form:select path="car_colour" id="colour">
	        <option value="Green">Green</option>
	        <option value="Black">Black</option>
	        <option value="Red">Red</option>
	        <option value="White">White</option>
	        <option value="Blue">Blue</option>
  	    </form:select>
  	    <br> 
  	    <label for = "date">Last maintance date</label>
		<form:input placeholder = "yyyy-mm-dd" type = "text" path = "last_maintance_date" id = "date"/>
  	    <br> 
  	    <label for = "price">Car price</label>
		<form:input placeholder = "price" type = "number" path = "price" id = "price"/>
		<br>
		<label for = "engine_power">Engine power</label>
		<form:input placeholder = "power" type = "number" path = "engine_power" id = "engine_power"/>
		<br>
		<label for = "number_of_doors">Number of doors</label>
		<form:input placeholder = "number" type = "number" path = "number_of_doors" id = "number_of_doors"/>
		<br>
		<label for = "number_of_seats">Number of seats</label>
		<form:input placeholder = "number" type = "number" path = "number_of_seats" id = "number_of_seats"/>
		<br>
		<label for = "milage">Mileage</label>
		<form:input placeholder = "milage" type = "number" path = "milage" id = "milage"/>
		<br> 
		<input type="submit" value="Add car" id = "submit">
	</form:form>
</body>
</html>