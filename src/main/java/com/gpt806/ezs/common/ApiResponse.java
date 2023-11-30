package com.gpt806.ezs.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("公共返回")
public class ApiResponse<T>  implements Serializable {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("说明")
    private String message;
    @ApiModelProperty("返回体")
    private T data;

    public ApiResponse(T value) {
        this.data = value;
    }


    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }
    public static <T> ApiResponse<T> result(ResultEnum resultEnum) {
        return new ApiResponse<>(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

}
