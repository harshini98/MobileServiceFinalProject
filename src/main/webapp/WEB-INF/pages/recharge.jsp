<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form method="get" action="rechargecheck">
<div class="rechargecontent">
        <div class="rechargeheading">
            Recharge
        </div>
<div>
<label > Enter the amount for recharge </label>
<input name="balance" step ="any" type="number" placeholder="Enter recharge amount" required/>
</div>
<div>
<div class = "rechargeremember">
<input class="rechargebtn" type="submit"  value="Submit"/>
</div>
</div>
</form>

</body>
</html>
