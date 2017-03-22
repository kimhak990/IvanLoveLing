


function deleteNotice(noticeId) {
    var params = {
        "noticeId" : noticeId
    }
    doAjax("/notice/deleteNotice",params,function (result) {
        if(result.code!=null && result.code !="" && result.code!= 0){
            alert("공지사항이 삭제되었습니다.");
            location.href="/notice/noticeList";
        }else{
            alert("공지사항 삭제에 실패하였습니다.");
        }
    })
}
$(function () {

    /*  공지사항 등록 버튼  */
    $("#writeButton").click(function () {

        var form = $("#noticeForm").serialize();

        doAjax("/notice/addNotice",form, function (result) {
                if(result.code!=null && result.code !="" && result.code!= 0){
                    alert("공지사항이 등록되었습니다.");
                    location.href="/home";
                }else{
                    alert("등록 실패했습니다.");
                }

        })
    })
    
    /* 공지사항 수정 */
    $("#updateButton").click(function () {
        var form = $("#noticeForm").serialize();

        doAjax("/notice/updateNotice",form,function (result) {
            if(result.code != null && result.code != "" && result.code != 0){
                alert("공지사항이 수정되었습니다.");
                location.href="/notice/noticeList";
            }else{
                alert("공지사항 수정 실패");
            }
        })
    })


});
$('#pageSize').val("${noticePVO.pageSize}");

/* 페이지 이동 */
function goPage(pageNo) {
    $('#pageNo').val(pageNo);
    var url = "/notice/noticeList";
    frmSubmit(url);
}

/* 검색 */
function search() {
    var url = "/notice/noticeList";
    frmSubmit(url);
}

/* 공지사항 수정 페이지 이동 */
function updateNotice(id) {
    var url = "/notice/noticeInfo";
    $("#noticeId").val(id);
    $('#paramsId')[0].method = "get";
    $('#paramsId')[0].action = url;
    $('#paramsId')[0].submit();
    //frmSubmit(url);
}
function frmSubmit(url) {
    $('#listForm')[0].method = "get";
    $('#listForm')[0].action = url;
    $('#listForm')[0].submit();
}

