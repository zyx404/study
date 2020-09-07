package com.example.api.response;

import com.example.api.enums.ResultEnum;
import lombok.Data;

@Data
public class WebResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public WebResponse(Integer code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public WebResponse(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
        this.data = data;
    }
}
