/*返回首页按钮点击事件*/
function returnBtnOnClick() {
    window.location.href="/"
}

/*左侧菜单栏单号响应事件*/
$(document).ready(function () {
    // 左侧菜单点击事件
    $('#sblearn-menu').on(type='click',selector="li",fn=function () {
        // 获取data-id的值
        var sid="#"+$(this).attr("id");
        // 设置锚点
        window.location.hash=sid;
        loadRight(sid);
    });

    function loadRight(sid) {
        var path,i;
        switch (sid){
            case "#li-test-for":path="sblearn/testUserLists";i=0;break;
            case "#li-file-upload":path="sblearn/option1";i=1;break;
        }

        // 加载对应的内容 高亮当前的列表项
        $("#changeable_content").load(path);
        $("#sblearn-menu li").eq(i).addClass("active").siblings().removeClass("active");
    }
});