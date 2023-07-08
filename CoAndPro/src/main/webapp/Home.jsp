<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ONLINE SHOPPING</title>
<style>
/* Add your custom styles here to make the page beautiful */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

/* Navigation bar styles */
.navbar {
	background-color: #333;
	color: #fff;
	display: flex;
	justify-content: space-between;
	padding: 10px 20px;
}

.navbar a {
	color: #fff;
	text-decoration: none;
	margin: 0 10px;
}

.navbar a:hover {
	text-decoration: underline;
}

.navbar .logo {
	font-size: 24px;
	font-weight: bold;
}

.navbar .login-btn, .navbar .register-btn {
	background-color: #fff;
	color: #333;
	border: none;
	padding: 8px 16px;
	border-radius: 4px;
	font-weight: bold;
	cursor: pointer;
	text-decoration: none;
	margin-left: 10px;
}

.navbar .login-btn:hover, .navbar .register-btn:hover {
	background-color: #f2f2f2;
}

/* Rest of your styles */
/* ... */
</style>
</head>
<body>
	<%
	HttpSession user = request.getSession();
	String email = (String) user.getAttribute("email");
	if (email != null) {
	%>
	<%@include file="CustomerHedder.jsp"%>
	<%
	} else if (email == null) {
	%>
	<%@ include file="Hedder.jsp"%>
	<%
	}
	%>
	<div align="center">
		<form>
			<!-- The rest of your webpage content goes here -->
			<!-- ... -->
			<img src="Images/Home.jpg" alt="Selling Logo" class="img-fluid">
		</form>
	</div>
</body>
</html>
