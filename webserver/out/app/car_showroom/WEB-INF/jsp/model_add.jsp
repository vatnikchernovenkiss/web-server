<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
<meta charset="UTF-8">
	<title>Add model</title>
</head>
<body>
	<h1>Add new model</h1>
	<c:url value="/model_add" var="var"/>
	<form:form modelAttribute = "form" action="${var}" method="POST">
  	    <label for = "title">Model title</label>
		<form:input placeholder = "enter the title.." type = "text" path = "title" id = "title"/>
  	    <br> 
  	    <label for = "developer">Developer</label>
  	    <form:select  path="developer_id" id="developer">
            <c:forEach items="${developers}" var="developer">
                <option value="${developer.id}" id = "${developer.name}">${developer.name}</option>
            </c:forEach>
        </form:select> 
        <br>
		<input type="submit" value="Add model" id = "submit">
	</form:form>
</body>
</html>