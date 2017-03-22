function doAjax(url, data, callback){
    $.ajax({
        url:url,
        method:'POST',
        data:data,
        dataType:'json',
        success:function(data, status, xhr){
            if(xhr.status == 200){
                callback(data);
            }
        },
        error:function(xhr, status, err){
            alert('처리중 오류가 발생하였습니다.');
        },
        beforeSend : function () {$('.wrap-loading').removeClass('display-none');},
        complete : function(){$('.wrap-loading').addClass('display-none');}
    });
};
