package com.ivan.blog.params;

/**
 * Created by kimha on 2017-03-06.
 */
public class AdminJsonVo {

    String code = "200";
    String msg = "success";
    Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
