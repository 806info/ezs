package com.gpt806.ezs.service.impl.sys;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gpt806.ezs.entity.sys.SysUser;
import com.gpt806.ezs.dao.sys.SysUserDao;
import com.gpt806.ezs.exception.exc.ParamException;
import com.gpt806.ezs.param.sys.UserParam;
import com.gpt806.ezs.service.sys.ISysLogService;
import com.gpt806.ezs.service.sys.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gpt806.ezs.utils.BCryptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Herb
 * @since 2023-11-30
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ISysUserService {

    private final ISysLogService iSysLogService;

    @Override
    public void add(UserParam param) {
        if(checkTelephoneExist(param.getTelephone(), param.getId())) {
            throw new ParamException("电话已被占用");
        }
        if(checkEmailExist(param.getMail(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }
        String password = "12345678";
        String encryptedPassword = BCryptUtil.encryptPassword(password);

        SysUser user = SysUser.builder().username(param.getUsername()).phone(param.getTelephone()).email(param.getMail())
                .password(encryptedPassword).deptId(param.getDeptId()).status(param.getStatus()).description(param.getRemark()).build();
        user.setUpdateBy("1");
        user.setCreateBy("1");
        user.setUid(IdUtil.simpleUUID());
        save(user);
        iSysLogService.saveUserLog(null, user);
    }

    public boolean checkEmailExist(String mail, Integer userId) {
        return count(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getEmail,mail).eq(!Objects.isNull(userId),SysUser::getId,userId)) > 0;
    }

    public boolean checkTelephoneExist(String telephone, Integer userId) {
        return count(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getPhone,telephone).eq(!Objects.isNull(userId),SysUser::getId,userId)) > 0;
    }
}
