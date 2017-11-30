package com.emall.vo;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
public class UploadVo {

    private Integer productId;
    private String uri;
    private String url;

    public UploadVo() {
    }

    public UploadVo(Integer productId, String uri, String url) {
        this.productId = productId;
        this.uri = uri;
        this.url = url;
    }
    public UploadVo(Integer productId, String uri) {
        this.productId = productId;
        this.uri = uri;

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadVo{" +
                "productId=" + productId +
                ", uri='" + uri + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
