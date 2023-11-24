package com.gpt806.ezs.common;

import cn.hutool.json.JSONUtil;
import com.gpt806.ezs.aspect.NoResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice(basePackages = "com.gpt806.ezs.controller")
public class ApiResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 确保仅在返回类型不是ApiResponse时应用此逻辑

        // 检查方法或类上是否有NoResult注解
        boolean hasNoResultAnnotation = returnType.getMethodAnnotation(NoResult.class) != null ||
                returnType.getContainingClass().isAnnotationPresent(NoResult.class);
        // 仅在没有NoResult注解且返回类型不是ApiResponse时应用此逻辑
        return !hasNoResultAnnotation && !ApiResponse.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 针对String类型的特殊处理，因为Spring默认将String视为直接的响应体
        if (body instanceof String) {
            return JSONUtil.toJsonStr(new ApiResponse<>(HttpStatus.OK.value(), "Success", body));
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", body);
    }
}
