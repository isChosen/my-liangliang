
window.onload = function() {
    getAllGirls(1, 10);
    
    // get 方式请求数据, 分页
    $('#allGirls').click(function () {
        setTimeout(getAllGirls.bind(this, 1, 10), 1000);
    });
    // post 方式请求数据, 没有分页
    $('#someGirls').click(getSomeGirls.bind(this, 1, 10, 'Victoria'));
};
/*~~~~~~~~~~  function  ~~~~~~~~~~*/

// 获取所有 girls
function getAllGirls (pageNum, pageSize) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/girls/queryAllGirls',
        data: JSON.stringify({'pageNum': pageNum, 'pageSize': pageSize}),
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8'
    }).fail(function (err) {
        console.log('getAllGirls-request-failed: ', err);
    }).success(function (data) {
        // console.log('getAllGirls-request-successful: ', data);
        var html = '';
        $.each(data.allGirls, function(i, item) {
            html += "<tr>"+
                "<td>"+ item.id +"</td>"+
                "<td>"+ item.name +"</td>"+
                "<td>"+ item.cup +"</td>"+
                "<td>"+ item.age +"</td>"+
                "<td>"+ item.grade +"</td>"+
            "</tr>";
        });
        $('.layui-table tbody').html(html);
        paging(pageNum, pageSize, data, getAllGirls);
    })
}
// 按名字获取 girls
function getSomeGirls(pageNum, pageSize, girl) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/girls/queryGirlsByName',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify({name: girl}),
        dataType: 'json'
    }).fail(function (err) {
        console.log('getSomeGirls-request-failed: ', err);
    }).success(function (data) {
        // console.log('getSomeGirls-request-successful: ', data);
        var html = '';
        $.each(data, function(i, item) {
            html += "<tr>"+
                "<td>"+ item.id +"</td>"+
                "<td>"+ item.name +"</td>"+
                "<td>"+ item.cup +"</td>"+
                "<td>"+ item.age +"</td>"+
                "<td>"+ item.grade +"</td>"+
            "</tr>";
        });
        $('.layui-table tbody').html(html);
        $('#pagination').html('');
    })
}

// 分页函数
function paging(curr, size, data, callback) {
    layui.use('laypage', function() {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'pagination',
            count: data.totalCount,
            curr: curr,
            limit: size,
            limits: [10, 20, 30],
            groups: 2,
            // first: '首页',
            // last: '尾页',
            prev: '<i class="layui-icon">&#58883;</i>',
            next: '<i class="layui-icon">&#58882;</i>',
            layout: ['prev', 'page', 'next', 'skip', 'limit', 'limits', 'count'],
            jump: function(obj, first) {
                if (!first) {
                    callback(obj.curr, obj.limit);
                }
            }
        });
    })
}

