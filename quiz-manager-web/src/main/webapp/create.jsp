<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Question Edition</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
			<form action="create" method="post">
				<div class="row">
					<div class="col-md-12 mb-3">
						<label for="question"> 
							Create Question 
						</label> 
						<input name="question" class="form-control" type="text" />
					</div>
					<div class="col-md-12 mb-3">
						<label for="type"> Type </label> 
						<input name="type" class="form-control" type=text " />
					</div>
					<button class="btn btn-primary" type="submit">Create
						Question
					</button>
				</div>
			</form>
		</div>
	</body>
</html>