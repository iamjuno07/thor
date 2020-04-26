<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="resources/style.css">

<title>signUp</title>
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
				<h3 style="color: #2DE1FC;">${returnMessage}</h3>
				<h1 class="display-4 py-2" style="color: black; font-weight: bold;">Welcome
					to SignUp page!!!</h1>
				<div class="px-2">
					<form action="signUp.do" method="post">
						<div class="form-group">
							<label class="sr-only">UserName</label> <input type="text"
								name="username" class="form-control" placeholder="UserName"
								value="${dto.getUsername()}">
						</div>
						<div class="form-group">
							<label class="sr-only">Email</label> <input type="text"
								name="email" class="form-control" placeholder="Email"
								value="${dto.getEmail()}">
						</div>
						<div class="form-group">
							<label class="sr-only">Phone no</label> <input type="text"
								name="phone" class="form-control" placeholder="Phone no"
								value="${dto.getPhone()}">
						</div>
						<div class="form-group">
							<label class="sr-only">Courses</label> <select name="course"
								class="form-control" value="${dto.getCourse()}">
								<option selected>Choose Course...</option>
								<option value="dev">DEVELOPER</option>
								<option value="test">TESTER</option>
							</select>
						</div>
						<div class="form-group" style="color: black;">
							<label class="mr-3"> <input type="radio" name="agree"
								value="yes">Agree
							</label> <label class="mr-3"> <input type="radio" name="agree"
								checked="" value="no">Disagree
							</label>
						</div>
						<button type="submit" class="btn btn-primary btn-sm">Register</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>