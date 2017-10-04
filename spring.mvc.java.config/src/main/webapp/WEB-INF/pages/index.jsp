<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="<c:url value="/resources/styles_for_login.css" />"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>log in</title>
</head>
<body>
	<div id="ENTER">
		<div class="form_window">
			<form action="hello" method="post">
				<p>Log in, please</p>
				<p>
					Name: <input type="text" name="name">
				</p>
				<p>
					Password: <input type="password" name="password">
				</p>
				<p>
					<input type="submit" value="Log In" />
				</p>
			</form>
		</div>
	</div>

	<div id="REGISTER">

		<div class="form_window">
			<form action="register" method="post">
				<p>Sign up:</p>
				<p>Email address:</p>
				<input type="text" name="email" id="Email" onkeyup="CheckRegInfo()">
				<p>Name:</p>
				<input type="text" name="name" id="UserName"
					onkeyup="CheckRegInfo()">
				<p>Password:</p>
				<input type="password" id="pass1" name="password1"
					onkeyup="CheckRegInfo()">
				<p>Confirm your password:</p>
				<input type="password" id="pass2" name="password2"
					onkeyup="CheckRegInfo()">
				<p id="RegErrors">Type all the info and log in:)</p>
				<p>
					<input type="submit" id="RegisterButton" value="Register" disabled />
				</p>
				<script type="text/javascript" src="resources/CheckingRegInfo.js"></script>
			</form>
		</div>
	</div>

	<a class="log_button" href="#ENTER">Log In</a>
	<a class="log_button" href="#REGISTER">I am a new user here!</a>
</body>
</html>