package com.gpt806.ezs.controller.sys;

import com.gpt806.ezs.common.ApiResponse;
import com.gpt806.ezs.dto.DeptLevelDto;
import com.gpt806.ezs.dto.TestDto;
import com.gpt806.ezs.dto.resp.CommonResp;
import com.gpt806.ezs.param.sys.DeptParam;
import com.gpt806.ezs.service.sys.ISysDeptService;
import com.gpt806.ezs.service.sys.ISysTreeService;
import com.gpt806.ezs.utils.BeanValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Herb
 * @since 2023-11-30
 */
@Tag(name = "系统相关接口")
@RestController
@RequestMapping("/ezs/sys/dept")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SysDeptController {

    private final ISysDeptService iSysDeptService;
    private final ISysTreeService iSysTreeService;

    @Operation(summary = "添加部门")
    @PostMapping()
    public CommonResp add(@RequestBody DeptParam deptParam){
        BeanValidator.check(deptParam);
        iSysDeptService.add(deptParam);
        return CommonResp.result("添加成功");
    }
    @Operation(summary = "获取部门")
    @GetMapping()
    public List<DeptLevelDto> list() {
        return iSysTreeService.deptTree();
    }



}
