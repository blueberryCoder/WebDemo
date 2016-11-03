/**
 * Created by Administrator on 2016/11/3.
 */


function loadSecurity2Cookie(url) {
    var xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlHttp.open("POST", url, true);
    xmlHttp.onreadystatechange= function () {
        if (xmlHttp.status == 200 && xmlHttp.readyState == 4) {
            // 写入cookie
            var response = xmlHttp.responseText;
            setCookie("security", response)
            console.log("保存cookie完成===============")
        }
    }
    xmlHttp.send()
    return true;
}

