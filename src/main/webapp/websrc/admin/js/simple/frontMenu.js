/**
 * Created by kimha on 2017-03-09.
 */
$(function () {
    $("#writeButton").click(function () {
        var form = $("#frontMenuForm").serialize();

        doAjax("/frontMenu/addFrontMenu", form, function (result) {
            if(result.code!=null && result.code !="" && result.code!= 0){
                alert("메뉴가 등록되었습니다.");
                location.href="/home";
            }else{
                alert("메뉴 등록에 실패하였습니다.");
            }
        })
    })

    /* 공지사항 수정 */
    $("#updateButton").click(function () {
        var form = $("#listForm").serialize();

        doAjax("/frontMenu/updateFrontMenu",form,function (result) {
            if(result.code != null && result.code != "" && result.code != 0){
                alert("프론트 메뉴가 수정되었습니다.");
                location.href="/frontMenu/FrontMenuList";
            }else{
                alert("프론트 메뉴 수정 실패");
            }
        })
    })
})


function deleteFrontMenu(frontMenuId) {
    var params = {
        "frontMenuId" : frontMenuId
    }
    doAjax("/frontMenu/deleteFrontMenu",params,function (result) {
        if(result.code!=null && result.code !="" && result.code!= 0){
            alert("공지사항이 삭제되었습니다.");
            location.href="/frontMenu/frontMenuList";
        }else{
            alert("공지사항 삭제에 실패하였습니다.");
        }
    })
}

$('#pageSize').val("${frontMenuPVO.pageSize}");

/* 페이지 이동 */
function goPage(pageNo) {
    $('#pageNo').val(pageNo);
    var url = "/frontMenu/frontMenuList";
    frmSubmit(url);
}

/* 검색 */
function search() {
    var url = "/frontMenu/frontMenuList";
    frmSubmit(url);
}

/* 공지사항 수정 페이지 이동 */
function updateFrontMenu(id) {
    var url = "/frontMenu/frontMenuInfo";
    $("#frontMenuId").val(id);
    $('#listForm')[0].method = "get";
    $('#listForm')[0].action = url;
    $('#listForm')[0].submit();
    //frmSubmit(url);
}
function frmSubmit(url) {
    $('#listForm')[0].method = "get";
    $('#listForm')[0].action = url;
    $('#listForm')[0].submit();
}