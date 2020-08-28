package com.example.api.response;

import com.example.api.enums.ResultEnum;
import lombok.Data;

@Data
public class WebResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public WebResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public WebResponse(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
}
