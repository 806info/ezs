package com.gpt806.ezs.service.sys;

import com.gpt806.ezs.dto.DeptLevelDto;

import java.util.List;

public interface ISysTreeService {

    List<DeptLevelDto> deptTree();
}
