<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cestitke</title>
</head>
<body>
	<h1>Cestitke store, Welcome!</h1>
	
	<c:if test="${not empty msg }">
		<br />
		<br />
		<p>${ msg }</p>		
	</c:if>
	
	<br />
	<br />
	<h3>Napravi novu cestitku forma:</h3>
	<br />
	<br />
	<form action="CestitkeServlet" method="post">
		<label>Ime primaoca:</label>
		<br />
		<input type="text" name="to" placeholder="Pera..." required />
		<br />
		<br />
		
		<label>Email primaoca:</label>
		<br />
		<input type="email" name="email" placeholder="pera@example.com" required />
		<br />
		<br />
		
		<label>Ime posiljaoca:</label>
		<br />
		<input type="text" name="from" placeholder="Djura..." required />
		<br />
		<br />
		
		<label>Tip cestitke:</label>
		<br />
		<select name="type">
        	<option value="rodjendanska">rodjendanska</option>
        	<option value="diplomska">diplomska</option>
        	<option value="novogodisnja">novogodisnja</option>
        </select>
		<br />
		<br />
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>