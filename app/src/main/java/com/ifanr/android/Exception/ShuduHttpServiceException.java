package com.ifanr.android.Exception;

/**
 * Created by ganyao on 2016/10/27.
 */

public class ShuduHttpServiceException extends BaseShuduException {

    private int code;
    private String msg;

    public ShuduHttpServiceException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
