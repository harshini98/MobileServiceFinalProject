<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form method="get" action="transfercheck">
<div class="tranfercontent">
        <div class="tranferheading">
            Transfer
        </div>
<div>
<label > Enter the Mobile Number </label>
<input name="phone" type="text" placeholder="Mobile No" required/>
</div>
<div>
<label > Enter the amount you want to transfer </label>
<input name="balance" type="number"  step = "any" placeholder="Transfer amount" required/>
</div>
<div class = "tranferremember">
<input class="tranferbtn" type="submit" value="Submit"/>
</div>
</div>
</form>

</body>
</html>
