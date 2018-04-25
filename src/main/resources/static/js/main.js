
window.onload = function() {
    myAllGirls(false);
};

// get 方式请求数据
$('#getAllGirls').click(function() {
    setTimeout(myAllGirls.bind(this, true), 1000);
    // myAllGirls(true);
});
// post 方式请求数据
$('#getGirlsByName').click(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/girls/queryGirlsByName',
        contentType: 'application/json; charset=UTF-8',
        async: true,
        data: JSON.stringify({name: 'Victoria'}),
        dataType: 'json'
    }).fail(function (err) {
        console.log(err);
    }).success(function (data) {
        console.log(data);
        var html = '';
        $.each(data, function(i, item) {
            html += "<tr>"+
                        "<td>"+ item.id +"</td>"+
                        "<td>"+ item.name +"</td>"+
                        "<td>"+ item.cup +"</td>"+
                        "<td>"+ item.age +"</td>"+
                        "<td>"+ item.grade +"</td>"+
                    "</tr>"
        });
        $('.table tbody').html(html);
    })
});

/*~~~~~~~~~~  function  ~~~~~~~~~~*/

var myAllGirls = function (boolean) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/girls/queryAllGirls',
        data: {'pn': 2},
        async: boolean,
        dataType: 'json'
    }).fail(function (err) {
        console.log(err);
    }).success(function (data) {
        //console.log(data);
        var html = '';
        $.each(data, function(i, item) {
            html += "<tr>"+
                "<td>"+ item.id +"</td>"+
                "<td>"+ item.name +"</td>"+
                "<td>"+ item.cup +"</td>"+
                "<td>"+ item.age +"</td>"+
                "<td>"+ item.grade +"</td>"+
                "</tr>"
        });
        $('.table tbody').html(html);
    })
}

