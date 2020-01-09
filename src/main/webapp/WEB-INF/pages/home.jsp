<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<div class = "homecontent">
<div class="loginheading">
            Home Page
        </div>
<div>
<h2>Id is  <c:out value="${Customer.id}"/></h2>
</div>
<div>
<h2>Name is <c:out value="${Customer.name}"/></h2>
</div>
<div class="homeremember" >
<span>
<input type="button" value="Recharge" class = "homebtn" onClick="JavaScript:window.location='recharge';">
</span>
<span>
<input type="button" value="Transfer" class = "homebtn" onClick="JavaScript:window.location='transfer';">
</span>
<span>
<input type="button" value="Check Balance" class = "homebtn" onClick="JavaScript:window.location='checkbalance';">
</span>
</div>
<div>
<a href="/signout" class = "homebtn">Sign out</a>
</div>



</div>

</body>
</html>