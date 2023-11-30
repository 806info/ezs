package com.gpt806.ezs.service.sys;

import com.gpt806.ezs.entity.sys.SysDept;
import com.gpt806.ezs.entity.sys.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gpt806.ezs.entity.sys.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Herb
 * @since 2023-11-30
 */
public interface ISysLogService extends IService<SysLog> {

    void saveDeptLog(SysDept before, SysDept after);

    void saveUserLog(SysUser before, SysUser after);

}
