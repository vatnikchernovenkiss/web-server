<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>

<body>
<h1>Table with all present orders. Its count is ${orders.size()}</h1>
	<table id = "Ordertable">
		<tr>
			<th>Date and time</th>
			<th>Current status</th>
			<th>Car</th>
			<th>If test-drive required</th>
			<th> Client full name </th>
		</tr>
		<tr>
		    <td><input type="text" id="date" class="search_icon" onkeyup="FilterFunction(0, id)" placeholder=" by status.."></td>
	        <td><input type="text" id="status" class="search_icon" onkeyup="FilterFunction(1, id)" placeholder="Search by date.."></td>
	        <td><input type="text" id="car" class="search_icon" onkeyup="FilterFunction(2, id)" placeholder="Search by car.."></td>
	        <td><input type="text" id="test" class="search_icon" onkeyup="FilterFunction(3, id)" placeholder="if test-drive .."></td>
   	   </tr>
   	   
	   	<c:forEach items="${orders}" var="order">
	    <tr>
	        <td>
	        <a href="order?id=${order.id}">
	         	${order.date_and_time}
	        </a>
	        </td>
	        <td> 
	        	${order.current_status}
	        </td>
	        <td> ${order.car_id.registration_number}</td>
	        <td> ${order.if_test_drive_required}</td>
	        <td> 
	        <a href="client?id=${order.client_id.id}">
         		${order.client_id.full_name}
        	 </a>
	        </td>
	    </tr>
		</c:forEach>
	</table>
	<br>
	<a href="order_add">
         <button>Add new order</button>
    </a>
 	<script>
    function FilterFunction(id, input) {
        // Declare variables
        var real_input, filter, table, tr, td, i, txtValue;
        real_input = document.getElementById(input);
        filter = real_input.value.toUpperCase();
        table = document.getElementById("Ordertable");
        tr = table.getElementsByTagName("tr");
        // Loop through all table rows, and hide those who don't match the search query
        for (i = 2; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[id];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
	</script> 
</body>
</html>