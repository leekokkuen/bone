//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

function getP(paramName) {
    var returnVal = "";
    try {
        var paramUrl = window.location.search;
        //处理长度
        if (paramUrl.length > 0) {
            paramUrl = paramUrl.substring(1, paramUrl.length);
            var paramUrlArray = paramUrl.split("&");
            for (var i = 0; i < paramUrlArray.length; i++) {
                if (paramUrlArray[i].toLowerCase().indexOf(paramName.toLowerCase()) != -1) {
                    var temp = paramUrlArray[i].split("=");
                    if (temp[0].toLowerCase() == paramName.toLowerCase()) {
                        returnVal = temp[1];
                        break;
                    }
                }
            }
        }
    }
    catch (e) { }
    return returnVal;
} 