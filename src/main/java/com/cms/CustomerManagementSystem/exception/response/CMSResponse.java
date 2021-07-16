package com.cms.CustomerManagementSystem.exception.response;

public class CMSResponse {
    private String message;
    Object data = new Object();

    public CMSResponse() {
    }

    public CMSResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
