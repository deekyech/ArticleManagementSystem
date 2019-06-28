$(function() {
   var article_id = getParameterByName("article_id");
   $.get("/getArticles/" + article_id, function (data) {
        document.getElementById("article_id").value = data.article_id;
        document.getElementById("title").value = data.title;
        document.getElementById("text").innerText = data.text;
   });
    $('form').on('submit', function (e) {
        e.preventDefault();
        if (validate()) {
            $.get("/getArticleByTitle/" + $('#title').val(), function (data) {
                if (data.article_id == $('#article_id').val()) {
                    $.post("/updateArticle", $('form').serializeJSON(), function () {
                        window.location.href = "/index.html";
                    });
                } else alert("Title already exists. Please change the title.")
            });
        }
    });
});
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}
function validTitle(title) {
    var chkTitle = new RegExp("^[A-Za-z0-9_ ]{4,20}$");
    return chkTitle.test(title);
}
function validate() {
    //return validTitle($('#title').val()) && validDescription($('#text').val());
    if (validTitle($('#title').val())) {
        if (validDescription($('#text').val())) {
            return true;
        } else alert("Text must be between 5 to 200 characters.");
    } else {
        alert("Title is invalid. It cannot be blank or contain special chars.");
        document.getElementById("title").value = "";
    }
}
function validDescription(text) {
    return !(text.length > 200 || text.length < 5);
}