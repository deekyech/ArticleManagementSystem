$(function () {
	$('#register-form').on('submit', function (e) {
		e.preventDefault();
		if(isFormValid()) {
			//CODE TO CHECK IF USERNAME AND EMAIL ARE UNIQUE
			$.get("userDataExists/" + $('#username').val() + "/" + $('#email').val(), function (data) {
				if (data.toString() === 'true') alert("Username or email already exists. Please try a different one.");
				else {
					$.post("/addUser", $('#register-form').serializeJSON(), function () {
						window.location.href = "/login.html";
					});
				}
			});
		}
	});
});
function isFormValid() {
	//CODE TO PERFORM VALIDATIONS
	var usernameRegex = new RegExp("^[a-zA-Z][_a-zA-Z0-9]{7,29}$");
	var emailRegex = new RegExp("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
	var passwordRegex = new RegExp("^[A-Za-z0-9!@#$%^&*()_]{6,20}$");
	if (usernameRegex.test($('#username').val())) {
		if (emailRegex.test($('#email').val())) {
			if ($('#password').val() === $('#confirmPassword').val()) {
				if (passwordRegex.test($('#password').val())) {
					return true;
				} else alert("Password format is not right. Please select a new password.");
			} else alert("Passwords do not match")
		} else alert("Email is not valid.");
	} else alert("Username is not valid.");
	return false;
}