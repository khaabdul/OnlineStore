<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Button Example</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	padding: 20px;
}

.container {
	max-width: 400px;
}

.btn-container {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 align="center">Welcome</h1>

		<div class="d-flex" style="column-gap: 10px;">
			<div class="btn-container">
				<form action="adm" method="post">
					<button type="submit" class="btn btn-primary btn-block"
						value="prod" name="admin">Product</button>
				</form>
			</div>

			<div class="btn-container">
				<form action="adm" method="post">
					<button type="submit" class="btn btn-primary btn-block"
						value="coup" name="admin">Coupon</button>
				</form>
			</div>

			<div class="btn-container">
				<form action="Admin.jsp" method="post">
					<button type="submit" class="btn btn-primary btn-block"
						value="complain" name="complain">Complaints</button>
				</form>
			</div>
			<div class="btn-container">
				<form action="Admin.jsp" method="post">
					<button type="submit" class="btn btn-primary btn-block"
						value="showall" name="showall">ShowAll</button>
				</form>
			</div>

			<div class="btn-container">
				<form action="Home.jsp" method="post">
					<button type="submit" class="btn btn-danger btn-block">Logout</button>
				</form>
			</div>
		</div>
	</div>
	<%
	String pro = request.getParameter("complain");
	if (pro != null) {
	%>
	<%@ include file="complain.jsp"%>
	<%
	}
	%>
	<%
	String showall = request.getParameter("showall");
	if (showall != null) {
	%>
	<%@ include file="ShowAll.jsp"%>
	<%
	}
	%>
</body>
</html>
