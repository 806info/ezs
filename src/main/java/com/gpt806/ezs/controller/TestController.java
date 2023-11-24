package com.gpt806.ezs.controller;

import com.gpt806.ezs.aspect.NoResult;
import com.gpt806.ezs.common.ApiResponse;
import com.gpt806.ezs.dto.TestDto;
import com.gpt806.ezs.entity.Test;
import com.gpt806.ezs.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Herb
 * @since 2023-11-24
 */
@RestController
@RequestMapping("/ezs/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("abc")
    public String get(String abc){
        List<Test> list = testService.list();
        return "abc";
    }
    @GetMapping("abc2")
    public ApiResponse<TestDto> get2(String abc){
        return new ApiResponse<TestDto>(200,"succ",new TestDto());
    }
    @NoResult
    @GetMapping("abc23")
    public TestDto get23(String abc){
        return new TestDto();
    }
}
