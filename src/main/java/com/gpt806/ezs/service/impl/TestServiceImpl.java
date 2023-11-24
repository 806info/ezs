package com.gpt806.ezs.service.impl;

import com.gpt806.ezs.entity.Test;
import com.gpt806.ezs.dao.TestDao;
import com.gpt806.ezs.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Herb
 * @since 2023-11-24
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestDao, Test> implements ITestService {

}
