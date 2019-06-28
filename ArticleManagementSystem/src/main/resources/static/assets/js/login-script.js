$(function () {
	$('#loginform').on("submit", function (e) {
		e.preventDefault();
		$.get("/getUserByEmail/" + $('#email').val(), function (data) {
			if (data == null) alert("Email does not exist.");
			else {
				if (data.password === $('#password').val()) {
					$.session.set("user_id", data.user_id);
					$.session.set("username", data.username);
					$.session.set("email", data.email);
					$.session.set("role", data.role);
					window.location.href = "/index.html";
				} else alert("Wrong password.");
			}
		});
	});
});