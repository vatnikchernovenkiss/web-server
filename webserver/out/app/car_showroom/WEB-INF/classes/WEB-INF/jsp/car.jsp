<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
    <title>Car with registration number ${car.registration_number}
    </title>
</head>
<body>
	<h1>Car with registration number ${car.registration_number}</h1>
	 <br>
	<table>
		<tr>
			<th>Model</th>
			<th>Registration number</th>
			<th>Number of seats</th>
			<th>Upholstery type</th>
			<th>Price</th>
			<th>Last maintance date</th>
			<th>Test-drive clients</th>
			<th>Mileage</th>
			<th>Car colour</th>
			<th>Engine power</th>
			<th>Number of doors</th>
			<th>Developer</th>
			<th>Devices</th>
		</tr>
		<tr>
			<td>${car.model_id.title}</td>
			<td>${car.registration_number}</td>
			<td>${car.number_of_seats}</td>
			<td>${car.getUpholstery()}</td>
			<td>${car.price}</td>
			<td>${car.last_maintance_date}</td>
			<td>
	            <c:forEach items="${clients}" var="client">
	            	<div>${client.full_name}</div>
	            </c:forEach>
      		</td>
	
			<td>${car.milage}</td>
			<td>${car.getCar_colour()}</td>
			<td>${car.engine_power}</td>
			<td>${car.number_of_doors}</td>
			<td>${car.developer_id.name}</td>
			<td>
	            <c:forEach items="${devices}" var="device">
	            	<div>${device.name}</div>
	            </c:forEach>
      		</td>
		</tr>
	</table> 
	<h1>Update car</h1>
	<c:url value="/car" var="var"/>
	<form:form modelAttribute = "form" action="${var}" method="POST">
		 <form:input type="hidden" path="id" value="${form.id}"/>
		 <label for = "number">Registration number</label>
		 <form:input placeholder = "аа000аа" type = "text" path = "registration_number" id = "number"/>
		 <br>
		  <label for = "devices">Devices </label>
		 <form:select multiple="true" path="devices_id" id="devices">
            <c:forEach items="${devices_all}" var="device">
                <option value="${device.id}" id = "${device.name}">${device.name}</option>
            </c:forEach>
            <option value="">None</option>
        </form:select>
        <br> 
		<label for = "clients">Test-drive clients </label>
		 <form:select multiple="true" path="test_drive_clients_id" id="clients">
            <c:forEach items="${clients_all}" var="client">
                <option value="${client.id}" id = "${client.full_name}">${client.full_name}</option>
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
		<input type="submit" value="Update car" id = "submit">
	</form:form>
	<a href = "car_del?id=${car.id}">
		<button>Delete this car</button>
	</a>
	<br>
	<a href = "model_del?id=${car.model_id.id}">
		<button>Delete all cars with the same model</button>
	</a>
	<br>
	
	<a href = "/">
		<button>Home</button>
	</a>
</body>
</html>