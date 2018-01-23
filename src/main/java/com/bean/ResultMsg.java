package com.bean;

public class ResultMsg<T>{
    public final static int SUCCESS_CODE = 200;
    public final static int FAILURE_CODE = 400;
    public final static int SERVER_FAILURE_CODE = 500;
    public final static int NO_AUTHORITY_CODE = 404;

    public final static String SERVER_FAILURE_MSG = "服务器错误";
    public final static String NO_AUTHORITY_MSG = "没有查看|操作权限";

    private int statusCode;
    private String msg;
    private Object body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "statusCode=" + statusCode +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                '}';
    }
}
