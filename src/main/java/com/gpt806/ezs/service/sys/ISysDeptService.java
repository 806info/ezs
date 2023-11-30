package com.gpt806.ezs.service.sys;

import com.gpt806.ezs.entity.sys.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gpt806.ezs.param.sys.DeptParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Herb
 * @since 2023-11-30
 */
public interface ISysDeptService extends IService<SysDept> {

    void add(DeptParam deptParam);




}
