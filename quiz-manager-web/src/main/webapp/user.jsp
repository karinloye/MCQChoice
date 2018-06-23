<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz manager application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
	<div>Sign Up Page</div>
	<div class="container">

		<form action="user" method="post">
			<div class="row">
				<div class="col-md-12 mb-3">
					<label for="login">User Login</label> <input name="login"
						class="form-control" type="text" />
				</div>
				<div class="col-md-12 mb-3">
					<label> User Password</label> <input class="form-control" name="password"
						type="password" />
				</div>
				<button class="btn btn-primary" type="submit">Sign Up</button>
			</div>
		</form>
	</div>
	


	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</body>
</html>