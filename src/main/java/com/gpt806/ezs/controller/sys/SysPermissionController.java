package com.gpt806.ezs.controller.sys;

import com.gpt806.ezs.common.ApiResponse;
import com.gpt806.ezs.dto.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Herb
 * @since 2023-11-25
 */
@RestController
@RequestMapping("/ezs/sysPermission")
public class SysPermissionController {
    @GetMapping("abc2")
    public ApiResponse<TestDto> get2(String abc){
        return new ApiResponse<TestDto>(200,"succ",new TestDto());
    }
}
