package com.emall.vo;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
public class FullUploadVo {


    private String file_path;
    private String success;

    public FullUploadVo(String file_path, String success) {
        this.file_path = file_path;
        this.success = success;
    }

    public FullUploadVo() {
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "FullUploadVo{" +
                "file_path='" + file_path + '\'' +
                ", success='" + success + '\'' +
                '}';
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
