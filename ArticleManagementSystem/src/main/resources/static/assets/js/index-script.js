$(function () {
    //$('#articles-table').DataTable();
    // console.log("Session user id: " + $.session.get("user_id"));
    var tableHead = "";
    if ($.session.get("role") == 1) tableHead = "<tr>\n" +
        "<th>Title</th>\n" +
        "<th>Article Content</th>\n" +
        "<th>Update</th>\n" +
        "<th>Delete</th>\n" +
        "</tr>\n";
    else tableHead = "<tr>\n" +
        "<th>Title</th>\n" +
        "<th>Article Content</th>\n" +
        "</tr>\n";
    document.getElementById('table-head').innerHTML = tableHead;
    
    $(document).on("click", "button.delete-btn", function() {
        var article_id = this.name;
        $.get("/deleteArticle/" + article_id, function() {
            window.location.href = "/index.html";
        });
    });
    
    $.get("/getArticles", function(data){
        var tableData = "";
        for(i = 0; i<data.length; i++) {
            tableData += "<tr>";
            if ($.session.get("role") == 1) tableData += "\n<td>" + data[i].title + "</td>" + "\n<td>" + data[i].text + "</td>" + "\n<td>" + "<a href='/update-article.html?article_id=" + data[i].article_id + "' class='btn btn-info'><span class='fa fa-edit'></span></a>" +  "</td>" + "\n<td>" + "<button type='submit' name='" + data[i].article_id + "' class='btn btn-danger delete-btn'><span class='fa fa-trash'></span></button>" + "</td>\n";
            else tableData += "\n<td>" + data[i].title + "</td>" + "\n<td>" + data[i].text + "</td>";
            tableData += "</tr>\n";
        }
        document.getElementById('table-body').innerHTML = tableData;
    });
    
    $('#logout').on("click", function (e) {
        e.preventDefault();
        console.log("Logout button clicked");
        $.session.clear();
        window.location.href = "login.html";
    });
});