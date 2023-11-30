package com.gpt806.ezs.service.sys;

import com.gpt806.ezs.entity.sys.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gpt806.ezs.param.sys.UserParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Herb
 * @since 2023-11-30
 */
public interface ISysUserService extends IService<SysUser> {

    void add(UserParam userParam);

    public boolean checkEmailExist(String mail, Integer userId);

    public boolean checkTelephoneExist(String telephone, Integer userId);
}
