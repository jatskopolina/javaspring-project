function CheckRegInfo() {
	// checks if two passwords user inputed during the registry are equal and
	// correct
	var password1 = document.getElementById("pass1").value;
	var password2 = document.getElementById("pass2").value;
	if (password1 != "" && password2 != "") {
		console.info("Hello " + password1 + " " + password2);
		if (password1 === password2) {
			document.getElementById("RegErrors").innerHTML = "";
			document.getElementById("RegisterButton").disabled = false;
		} else {
			document.getElementById("RegErrors").innerHTML = "Please check your passwords!";
			document.getElementById("RegErrors").style.color = "coral";
			document.getElementById("RegisterButton").disabled = true;
		}
	} else {
		document.getElementById("RegErrors").innerHTML = "";
		document.getElementById("RegisterButton").disabled = true;

	}
	if (document.getElementById("Email").value === ""
			|| document.getElementById("UserName").value === "") {
		document.getElementById("RegisterButton").disabled = true;
	}

}