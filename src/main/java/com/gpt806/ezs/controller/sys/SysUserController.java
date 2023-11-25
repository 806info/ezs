package com.gpt806.ezs.controller.sys;

import com.gpt806.ezs.common.ApiResponse;
import com.gpt806.ezs.dto.TestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "系统用户列表")
@RestController
@RequestMapping("/ezs/sysUser")
public class SysUserController {

    @Operation(summary = "测试一下")
    @Parameters({
            @Parameter(name = "abc",description = "测试地址",in = ParameterIn.QUERY),
//            @Parameter(name = "token",description = "请求token",required = true,in = ParameterIn.HEADER),
//            @Parameter(name = "name",description = "文件名称",required = true,in=ParameterIn.QUERY)
    })
    @GetMapping("abc2")
    public ApiResponse<TestDto> get2(String abc){
        return new ApiResponse<TestDto>(200,"succ",new TestDto());
    }
}
