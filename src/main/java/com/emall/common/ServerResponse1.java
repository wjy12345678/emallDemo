package com.emall.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse1<T> {
    private int status;
    private String msg;
    private T data;

    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode1.SUCCESS.getCode();
    }

    private ServerResponse1(int status) {
        this.status = status;
    }

    private ServerResponse1(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse1(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse1(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }
    public static<T> ServerResponse1<T> createSuccess(){
        return new ServerResponse1<T>(ResponseCode1.SUCCESS.getCode());
    }
    public static<T> ServerResponse1<T> createSuccess(String msg){
        return new ServerResponse1<T>(ResponseCode1.SUCCESS.getCode(),msg);
    }
    public static<T> ServerResponse1<T> createSuccess(T data){
        return new ServerResponse1<T>(ResponseCode1.SUCCESS.getCode(),data);
    }
    public static<T> ServerResponse1<T> createSuccess(String msg,T data){
        return new ServerResponse1<T>(ResponseCode1.SUCCESS.getCode(),msg,data);
    }
    public static<T> ServerResponse1<T> createError(){
        return new ServerResponse1<T>(ResponseCode1.ERROR.getCode());
    }
    public static<T> ServerResponse1<T> createError(T data){
        return new ServerResponse1<T>(ResponseCode1.ERROR.getCode(),data);
    }
    public static<T> ServerResponse1<T> createError(String msg,T data){
        return new ServerResponse1<T>(ResponseCode1.ERROR.getCode(),msg,data);
    }
    public static<T> ServerResponse1<T> createError(String errMsg){
        return new ServerResponse1<T>(ResponseCode1.ERROR.getCode(),errMsg);
    }
    public static<T> ServerResponse1<T> createErrorCode(int errCode,String errMsg){
        return new ServerResponse1<T>(errCode,errMsg);
    }
    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
