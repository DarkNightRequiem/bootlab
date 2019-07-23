/*返回首页按钮点击事件*/
function returnBtnOnClick() {
    window.location.href = "/"
}

/*左侧菜单栏单号响应事件*/
$(document).ready(function () {
    // 左侧菜单点击事件
    $('#sblearn-menu').on(type = 'click', selector = "li", fn = function () {
        // 获取data-id的值
        var sid = "#" + $(this).attr("id");
        // 设置锚点
        window.location.hash = sid;
        loadRight(sid);
    });

    function loadRight(sid) {
        var path, i;
        switch (sid) {
            case "#li-test-for":
                path = "sblearn/testUserLists";
                i = 0;
                break;
            case "#li-file-upload":
                path = "sblearn/testUpload";
                i = 1;
                break;
        }

        // 加载对应的内容 高亮当前的列表项
        $("#changeable_content").load(path);
        $("#sblearn-menu li").eq(i).addClass("active").siblings().removeClass("active");
    }
});


/*点击提交表单*/
function commitSingleFile() {
    var form = new FormData(document.getElementById("test-single-file-upload-form"));
    $.ajax({
        // AJAX请求类型
        type: 'POST',
        // 期望服务器响应的类型
        /*dataType:
        要求为String类型的参数，预期服务器返回的数据类型。如果不指定，JQuery将自动根据http包mime信息返回responseXML或responseText，并作为回调函数参数传递。可用的类型如下：
        xml：返回XML文档，可用JQuery处理。
        html：返回纯文本HTML信息；包含的script标签会在插入DOM时执行。
        script：返回纯文本JavaScript代码。不会自动缓存结果。除非设置了cache参数。注意在远程请求时（不在同一个域下），所有post请求都将转为get请求。
        json：返回JSON数据。
        jsonp：JSONP格式。使用SONP形式调用函数时，例如myurl?callback=?，JQuery将自动替换后一个“?”为正确的函数名，以执行回调函数。
        text：返回纯文本字符串。
        */
        dataType: "text",
        url:"/sblearn/upload",
        data: form,
        // 告诉Jquery不要处理发送的数据
        processData:false,
        // 告诉jQuery不要去设置Content-Type请求头
        contentType : false,
        success: function (result) {
            alert("上传文件成功")
        },
        error: function () {
            alert("异常");
        }
    });
}