<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="resources/style.css">

<title>Login</title>
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
	<div class="container">
		<div class="row text-white">
			<div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto  form p-4">
				<h3 style="color: #2DE1FC;">${returnLoginMessage}</h3>
				<h1 class="display-4 py-2" style="color: black; font-weight: bold;">Please
					Login!!!</h1>
				<div class="px-2">
					<form action="login.do" method="post">
						<div class="form-group">
							<label class="sr-only">Email</label> <input type="text"
								name="email" class="form-control" placeholder=" Enter Email">
						</div>
						<div class="form-group">
							<label class="sr-only">Password</label> <input type="password"
								name="password" class="form-control"
								placeholder="Enter Password">
						</div>
						<button type="submit" class="btn btn-primary btn-sm">Login</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>