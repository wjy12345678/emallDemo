package com.emall.common;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
public enum ResponseCode1 {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEARL_ARGUMENT(2,"ILLEARL_ARGUMENT"),
    NEED_LOGIN(20,"NEED_LOGIN");
    private final int code;
    private final String value;

    ResponseCode1(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
