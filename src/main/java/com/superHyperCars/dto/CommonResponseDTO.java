package com.songify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponseDTO {

    @JsonProperty("success")
    public boolean success = true;

    @JsonProperty("msg")
    public String msg = null;

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

    @Override
    public String toString() {
        return "CommanResponseDto{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }

}
