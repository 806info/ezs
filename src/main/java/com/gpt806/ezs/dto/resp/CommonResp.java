package com.gpt806.ezs.dto.resp;

import com.gpt806.ezs.aspect.NoResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResp implements Serializable {
    private String result;


    public static CommonResp result(String message){
        return new CommonResp(message);
    }
}
