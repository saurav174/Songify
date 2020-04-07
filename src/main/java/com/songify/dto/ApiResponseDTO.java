package com.songify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponseDTO {

    @JsonProperty("success")
    public boolean success;

    @JsonProperty("msg")
    public String msg = null;

    @JsonProperty("data")
    public Object data;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
