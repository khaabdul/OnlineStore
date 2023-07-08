<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
<body>
	<div class="container">
		<%!Product_Bean pb;%>
		<%
		HttpSession user = request.getSession();
		String email = (String) user.getAttribute("email");
		/* Product_Bean pb = (Product_Bean) user.getAttribute("naam"); */
		int id = Integer.valueOf(request.getParameter("id"));
		%>
		<h1 align="center">
			Welcome<%=user.getAttribute("name")%></h1>
		<div class="row">
			<%
			ArrayList<Product_Bean> list = (ArrayList) user.getAttribute("naam");
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				pb = (Product_Bean) itr.next();
				if (id == pb.getP_id()) {
			%>
			<div class="col-md-4">
				<div class="card product-card">
					<div class="card-body">
						<h5 class="card-title">
							Product_Id:<%=pb.getP_id()%></h5>
						<h5 class="card-title">
							Name:
							<%=pb.getP_Name()%>
						</h5>
						<p class="card-text">
							Brand:
							<%=pb.getP_Brand()%>
						</p>
						<p class="card-text">
							Price:
							<%=pb.getP_Price()%>
						</p>
						<a href="acart" class="btn btn-primary">Buy Now</a>
					</div>
				</div>
			</div>
			<%
			user.setAttribute("Bill", pb);
			break;
			}
			}
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
