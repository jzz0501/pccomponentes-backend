package com.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {

    private Integer code;

    private String message;

    private Object data;

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

}
