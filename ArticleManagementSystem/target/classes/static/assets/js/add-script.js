$(function () {
    console.log("Session user id: " + $.session.get("user_id"));
    $('form').on('submit', function (e) {
        e.preventDefault();
        var title = $('#title').val();
        if (validate()) {
            $.get("/titleExists/" + title, function (data) {
                if (data.toString() === "true")
                    alert("Title already exists. Please change the title.");
                else {
                    $.post("/addArticles", $('form').serializeJSON(), function () {
                        window.location.href = "/index.html";
                    });
                }
            });
        }
    });
});
function validTitle(title) {
    var chkTitle = new RegExp("^[A-Za-z0-9 ]{4,40}$");
    return chkTitle.test(title);
}
function validate() {
    //return validTitle($('#title').val()) && validDescription($('#text').val());
    if (validTitle($('#title').val())) {
        if (validDescription($('#text').val())) {
                return true;
        } else alert("Text must be between 5 to 200 characters.")
    } else {
        alert("Title is invalid. It cannot be blank or contain special chars.");
        document.getElementById("title").value = "";
    }
}
function validDescription(text) {
    return !(text.length > 200 || text.length < 5);
}