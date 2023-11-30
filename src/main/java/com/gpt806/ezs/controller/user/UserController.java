package com.gpt806.ezs.controller.user;

import com.gpt806.ezs.dto.resp.CommonResp;
import com.gpt806.ezs.param.sys.UserParam;
import com.gpt806.ezs.service.sys.ISysUserService;
import com.gpt806.ezs.utils.BeanValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Herb
 * @since 2023-11-25
 */
@Tag(name = "用户相关接口")
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/ezs/user")
public class UserController {

    private final ISysUserService iSysUserService;
    @Operation(summary = "添加用户")
    @PostMapping()
    public CommonResp add(@RequestBody UserParam userParam){
        BeanValidator.check(userParam);
        iSysUserService.add(userParam);
        return CommonResp.result("添加成功");
    }
}
