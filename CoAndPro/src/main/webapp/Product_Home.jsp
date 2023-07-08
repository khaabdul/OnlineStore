<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Product_Bean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Connection.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection con;%>

<!DOCTYPE html>
<html>
<head>
<title>Online Product Store</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
/* Custom CSS styles */
body {
	padding-top: 20px;
}

.product-card {
	margin-bottom: 20px;
}
</style>
</head>
<%@ include file="CustomerHedder.jsp"%>
<%
HttpSession obj = request.getSession();
%>
<body>
	<div class="container">
		<h1 align="center">
			Welcome
			<%=obj.getAttribute("name")%>
		</h1>
		<div class="row">
			<%
			List<Product_Bean> list = new ArrayList<Product_Bean>();
			con = ConnectionUtil.connection();
			PreparedStatement show = con.prepareStatement("Select * from product");
			ResultSet rs = show.executeQuery();
			while (rs.next()) {
			Product_Bean pb = new Product_Bean();
				pb.setP_id(rs.getInt(1));
				pb.setP_Name(rs.getString(2));
				pb.setP_Brand(rs.getString(4));
				pb.setP_Price(rs.getString(3));
			%>

			<div class="col-md-4">
				<div class="card product-card">
					<div class="card-body">
						<h5 class="card-title">
							Product_Id:<%=pb.getP_id()%></h5>
						<h5 class="card-title">
							Name:<%=pb.getP_Name()%></h5>
						<p class="card-text">
							Brand:<%=pb.getP_Brand()%>
						</p>
						<p class="card-text">
							Price:<%=pb.getP_Price()%>
						</p>
						<a href="Cart.jsp?id=<%=pb.getP_id()%>" class="btn btn-primary">Add
							to Cart</a>
					</div>
				</div>
			</div>
			<%
			list.add(pb);
			}
			obj.setAttribute("naam", list);
			%>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
