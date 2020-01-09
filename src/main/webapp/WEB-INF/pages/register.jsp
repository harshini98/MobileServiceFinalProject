<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
	<form method="get" action="processregister">

		<div class="registercontent">
			<div class="registerheading">Register</div>
			<div>
				<label>Name </label> <input name="name" type="text" placeholder="Enter name" required/>
			</div>

			<div>
				<label>Phone </label> <input name="phone" type="text" placeholder="Enter Mobile No" required />
			</div>

			<div>
				<label>Password </label> <input name="password" type="password" placeholder="Enter password" required/>
			</div>
			<div class="registerremember">
				<input type="submit" class="registerbtn" value="Submit" />
			</div>
		</div>
	</form>
</body>
</html>