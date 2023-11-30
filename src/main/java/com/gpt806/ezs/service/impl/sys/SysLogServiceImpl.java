package com.gpt806.ezs.service.impl.sys;

import com.gpt806.ezs.entity.sys.SysDept;
import com.gpt806.ezs.entity.sys.SysLog;
import com.gpt806.ezs.dao.sys.SysLogDao;
import com.gpt806.ezs.entity.sys.SysUser;
import com.gpt806.ezs.service.sys.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Herb
 * @since 2023-11-30
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements ISysLogService {

    @Override
    public void saveDeptLog(SysDept before, SysDept after) {

    }

    @Override
    public void saveUserLog(SysUser before, SysUser after) {

    }
}
