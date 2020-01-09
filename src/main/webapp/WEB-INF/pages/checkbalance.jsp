<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

    <link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<div class="checkcontent">
<div class="checkheading">
            Balance Details
</div>
<div class = "label">
<h2>Customer Name:  <c:out value="${Customer.name}"/></h2>
</div>
<div class = "label">
<h2>Mobile No:  <c:out value="${Customer.mobileNo}"/></h2>
</div>
<div class = "label">
<h2>Current Balance:  <c:out value="${Customer.balance}"/></h2>
</div>
</div>
</body>
</html>