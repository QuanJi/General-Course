
//查询数据条数
var totalInfo = 0;
function getTotal(condition,parentId) {
    var ajax = new XMLHttpRequest();
    ajax.open('get', '../GetTotalByCondition?value='+condition+"&parentId="+parentId);
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            totalInfo= ajax.responseText;

            document.getElementById("dataNumTip").innerHTML = "共"+ajax.responseText+"条数据，每页显示10条";
        }
    };
    ajax.send();

    return ;
}
//搜索
function searchBy(){
    getData(nowPage,0)
}
var nowPage = 1; //记录当前页面
//上一页
function prePage() {
    console.log(nowPage);
    if(nowPage<=1){
        alert("已经是第一页了！！！");
    } else {
        var temp = nowPage-1;
        nowPage--;
        getQuestionTitle(temp);
    }


}
//下一页
function nextPage() {

    if(nowPage >=totalInfo/10 ){
        alert("已经是最后一页了！！！")
    }else{
        var temp = nowPage+1;
        nowPage++;
        getQuestionTitle(temp);
    }

}
window.onload = function () {
    getTotal("",0);
    getData(1,0);
}

function getData(Num,parentId) {
    var searchKey = document.getElementById("inputSearchKey").value;
    console.log(parentId);
    getTotal(searchKey,parentId);
    //获取数据
    var ajax = new XMLHttpRequest();
    ajax.open('get', '../ColumnServlet?searchKey='+searchKey+"&pageNum="+Num+"&parentId="+parentId);
    ajax.setRequestHeader("Content-type","application/json");
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200){
            var result = JSON.parse(ajax.responseText);
            document.getElementById("allData").innerHTML = insertData(result);
        }
        return;
    };
    ajax.send();
}

//插入数据到表格中
function insertData(result){
    var html = "";
    for(var i = 0; i<result.length;i++){
        html += "<tr>";
        html += "<td><input name='box' type='checkBox' value='"+result[i].id+"'></td>";
        html += "<td>"+(i+1)+"</td>";
        html += "<td>"+result[i].columnName+"</td>";
        html += "<td id='operatorArea'>";
        html += "<span style='cursor:pointer' class=''>编&nbsp;辑&nbsp;&nbsp;</sapn>";
        html += "<span style='cursor: pointer' class='' onclick='getData(1,"+result[i].id+")'>下一级</span>"
        html += "</td>";
        html += "</tr>";
        /*if(result[i].child.length > 0){
            for(var j=0 ; j<result[i].child.length ; j++){
                html += "<tr>";
                html += "<td><input name='box' type='checkbox' value='"+result[i].child[j].id+"'></td>";
                html += "<td>&nbsp;&nbsp;&nbsp;&nbsp;|-"+(j+1)+"</td>";
                html += "<td>&nbsp;&nbsp;&nbsp;&nbsp;|-"+result[i].child[j].columnName+"</td>";
                html += "<td id='operatorArea'>";
                html += "<span style='cursor:pointer' class=''>编&nbsp;辑</sapn></td>";
                html += "</tr>";
            }
        }*/
    }
    return html;
}
