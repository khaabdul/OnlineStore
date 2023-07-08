<%@page import="com.Connection.ConnectionUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<head>
<meta charset="UTF-8">
<title>Data Table</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: lightgray;
}

.container {
	display: flex;
	align-items: center;
	justify-content: center;
}

input[type="text"] {
	padding: 10px;
	font-size: 16px;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-right: 10px;
	flex-grow: 1;
}

button {
	padding: 10px 20px;
	font-size: 16px;
	border-radius: 5px;
	border: none;
	color: #fff;
	cursor: pointer;
}

.delete-button {
	background-color: #f44336;
}

.update-button {
	background-color: #4CAF50;
}
</style>
</head>
<body>
	<%!Connection con;%>
	<h1>Coupon Table</h1>
	<table>
		<tr>
			<th>Coupon Id</th>
			<th>Coupon Code</th>
			<th>Coupon Descount</th>
			<th>Expire Date</th>
		</tr>
		<%
		try {
			con = ConnectionUtil.connection();
			PreparedStatement coupon = con.prepareStatement("select * from coupon");
			ResultSet showCoupon = coupon.executeQuery();
			while (showCoupon.next()) {
		%>
		<tr>
			<td><%=showCoupon.getInt(1)%></td>
			<td><%=showCoupon.getString(2)%></td>
			<td><%=showCoupon.getLong(3)%></td>
			<td><%=showCoupon.getString(4)%></td>

		</tr>
		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
	<br>
	<h1>Product Details</h1>
	<table>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Brand</th>
		</tr>

		<%
		try {
			PreparedStatement product = con.prepareStatement("select * from product");

			ResultSet showProduct = product.executeQuery();

			while (showProduct.next()) {
		%>
		<tr>
			<td><%=showProduct.getInt(1)%></td>
			<td><%=showProduct.getString(2)%></td>
			<td><%=showProduct.getString(3)%></td>
			<td><%=showProduct.getString(4)%></td>
		</tr>
		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
</body>
</html>
