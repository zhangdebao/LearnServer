package com.utils;

import com.bean.ResultMsg;

public class ResultUtils {
    public static ResultMsg success (Object data, String msg){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setStatusCode(ResultMsg.SUCCESS_CODE);
        if(msg == null){
            resultMsg.setMsg("success");
        }else{
            resultMsg.setMsg(msg);
        }
        resultMsg.setBody(data);
        return resultMsg;
    }
    public static ResultMsg failure (Object data, String msg){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setStatusCode(ResultMsg.FAILURE_CODE);
        if(msg == null){
            resultMsg.setMsg("failure");
        }else{
            resultMsg.setMsg(msg);
        }
        resultMsg.setBody(data);
        return resultMsg;
    }
    public static ResultMsg error (Object data, String msg) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setStatusCode(ResultMsg.SERVER_FAILURE_CODE);
        if(msg == null){
            resultMsg.setMsg(ResultMsg.SERVER_FAILURE_MSG);
        }else{
            resultMsg.setMsg(msg);
        }
        resultMsg.setBody(data);
        return resultMsg;
    }
    public static ResultMsg authority (Object data, String msg) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setStatusCode(ResultMsg.NO_AUTHORITY_CODE);
        if(msg == null){
            resultMsg.setMsg(ResultMsg.NO_AUTHORITY_MSG);
        }else{
            resultMsg.setMsg(msg);
        }
        resultMsg.setBody(data);
        return resultMsg;
    }
}
