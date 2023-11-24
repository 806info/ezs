package com.gpt806.ezs.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T>  implements Serializable {
    private int code;
    private String message;
    private T data;

}
