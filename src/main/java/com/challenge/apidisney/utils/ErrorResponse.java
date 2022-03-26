package com.challenge.apidisney.utils;

import lombok.Builder;

@Builder
public class ErrorResponse {

    private String title;
    private String URI;
    private int status;
    private Object detail;

    public ErrorResponse(String title, String URI, int status, Object detail) {
        this.title = title;
        this.URI = URI;
        this.status = status;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }
}
