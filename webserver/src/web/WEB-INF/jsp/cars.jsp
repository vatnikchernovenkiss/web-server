<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
<meta charset="UTF-8">
<title>Cars</title>
</head>

<body>
<h1>All present cars. Its count is ${cars.size()}</h1>
	<table id = "Cartable">
		<tr>
			<th>Registration_number</th>
			<th>Model</th>
			<th>Developer</th>
			<th>Price</th>
		</tr>
		<tr>
		    <td><input type="text" id="registration_number" class="search_icon" onkeyup="FilterFunction(0, id)" placeholder="Search by registration number.."></td>
	        <td><input type="text" id="model" class="search_icon" onkeyup="FilterFunction(1, id)" placeholder="Search by model.."></td>
	        <td><input type="text" id="developer" class="search_icon" onkeyup="FilterFunction(2, id)" placeholder="Search by developer.."></td>
	        <td><input type="text" id="price" class="search_icon" onkeyup="FilterFunction(3, id)" placeholder="Search by price .."></td>
   		 </tr>
   	<c:forEach items="${cars}" var="car">
    <tr>
        <td>
        <a href="car?id=${car.id}">
         ${car.registration_number}
         </a>
        </td>
        <td> ${car.model_id.title}</td>
        <td> ${car.developer_id.name}</td>
         <td> ${car.price}</td> 
    </tr>
	</c:forEach>
	</table>
	<br>
	<a href="car_add">
         <button>Add new car</button>
    </a>
    <br>
    <a href="model_add">
         <button>Add new model</button>
    </a>
 	<script>
    function FilterFunction(id, input) {
        // Declare variables
        var real_input, filter, table, tr, td, i, txtValue;
        real_input = document.getElementById(input);
        filter = real_input.value.toUpperCase();
        table = document.getElementById("Cartable");
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