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
	<div class="container" align="center">
		<h1>Coupon Operations</h1>
		<div class="d-flex" style="column-gap: 10px;">
			<div class="btn-container">
				<form action="Coupon.jsp" method="post">
					<button type="submit" class="btn btn-primary btn-block" value="add"
						name="add">Add</button>
				</form>
			</div>

			<div class="btn-container">
				<form action="Coupon.jsp" method="post">
					<button type="submit" class="btn btn-primary btn-block"
						value="update" name="update">Update</button>
				</form>
			</div>

			<div class="btn-container">
				<form action="Coupon.jsp" method="post">
					<button type="submit" class="btn btn-primary btn-block"
						value="delete" name="delete">Delete</button>
				</form>
			</div>

			<div class="btn-container">
				<form action="Coupon.jsp" method="post">
					<button type="submit" class="btn btn-primary btn-block"
						value="show" name="show">Show</button>
				</form>
			</div>
			<div class="btn-container">
				<form action="Admin.jsp" method="post">
					<button type="submit" class="btn btn-danger btn-block">Back</button>
				</form>
			</div>
		</div>
	</div>
	<%
	String add = request.getParameter("add");
	if (add != null) {
	%>
	<%@ include file="AddCoupon.jsp"%>
	<%
	}
	%>
	<%
	String update = request.getParameter("update");
	if (update != null) {
	%>
	<%@ include file="UpdateCoupon.jsp"%>
	<%
	}
	%>
	<%
	String delete = request.getParameter("delete");
	if (delete != null) {
	%>
	<%@ include file="DeleteCoupon.jsp"%>
	<%
	}
	%>
	<%
	String show = request.getParameter("show");
	if (show != null) {
	%>
	<%@ include file="ShowCoupon.jsp"%>
	<%
	}
	%>

</body>
</html>
