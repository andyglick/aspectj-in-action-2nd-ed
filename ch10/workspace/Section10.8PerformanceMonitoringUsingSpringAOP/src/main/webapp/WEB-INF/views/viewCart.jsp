<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<title>Cart</title>
</head>

<body>
<div>

<h1>Cart</h1>

<table border="2">
	<tr><th>Product</th><th>Quantity</th><th>Total</th></tr>
	<c:forEach items="${order.lineItems}" var="lineItem">
		<tr><td>${lineItem.product.name}</td><td>${lineItem.quantity}</td><td>${lineItem.lineTotal}</td></tr>
	</c:forEach>
	<tr><td></td><td></td><td>${order.totalPrice}</td></tr>
</table>

<form:form action="place.htm" >
	<div>
		<input type="submit" value="Place the order"/>
	</div>
</form:form>

<div>
	<a href="productSummary.htm">Continue Shopping</a>
</div>

</div>
</body>

</html>