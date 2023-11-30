package com.gpt806.ezs.service.impl.sys;

import cn.hutool.core.lang.intern.InternUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gpt806.ezs.entity.sys.SysDept;
import com.gpt806.ezs.dao.sys.SysDeptDao;
import com.gpt806.ezs.exception.exc.ParamException;
import com.gpt806.ezs.param.sys.DeptParam;
import com.gpt806.ezs.service.sys.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gpt806.ezs.service.sys.ISysLogService;
import com.gpt806.ezs.utils.LevelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.ObjectInputStreamInstantiator;
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
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDept> implements ISysDeptService {

    private final ISysLogService iSysLogService;

    @Override
    public void add(DeptParam param) {
        if(checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDept dept = SysDept.builder().name(param.getName()).parentId(param.getParentId())
                .seq(param.getSeq()).description(param.getRemark()).build();
        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));
        dept.setCreateBy("0");
        dept.setUpdateBy("0");
        dept.setUid(IdUtil.simpleUUID());
        save(dept);
        iSysLogService.saveDeptLog(null, dept);
    }




    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        return count(Wrappers.<SysDept>lambdaQuery().eq(SysDept::getName,deptName)
                .eq(!Objects.isNull(parentId),SysDept::getParentId,parentId)
                .eq(!Objects.isNull(deptId),SysDept::getId,deptId)) > 0;
    }
    private String getLevel(Integer deptId) {
        SysDept dept = getOne(Wrappers.<SysDept>lambdaQuery().eq(SysDept::getId,deptId),false);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }
}
