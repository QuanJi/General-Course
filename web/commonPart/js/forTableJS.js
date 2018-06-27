//勾选或取消所有复选框
function checkAllbox() {
    var all = document.getElementsByName('all');
    var temp = new Array();
    if(all[0].checked == true){
        var id = document.getElementsByName('box');

        for(var i=0;i<id.length;i++){
            id[i].checked = true;
        }
    } else if(all[0].checked == false){
        var id = document.getElementsByName('box');

        for(var i=0;i<id.length;i++){
            id[i].checked = false;
        }
    }
}