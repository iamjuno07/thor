<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="resources/style.css">

<title>Home</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark sticky-top"
		style="background: red;">
		<a class="navbar-brand" href="index.jsp"> <img
			src="resources/img/xworkz.jpg" alt="Logo" style="width: 40px;" />
		</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navb" aria-expanded="true">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navb" class="navbar-collapse collapse hide">
			<!-- <ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">Page 1</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Page 2</a></li>
		</ul> -->

			<ul class="nav nav nav-pills navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="login.jsp"><span
						class="fas fa-user"></span>Login</a></li>
				<li class="nav-item"><a class="nav-link" href="signUp.jsp"><span
						class="fas fa-sign-in-alt"></span>SignUp</a></li>
			</ul>
		</div>
	</nav>
	<h3>Welcome to home page!!!</h3>
</body>
</html>