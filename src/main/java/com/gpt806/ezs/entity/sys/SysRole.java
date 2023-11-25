package com.gpt806.ezs.entity.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gpt806.ezs.base.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Herb
 * @since 2023-11-25
 */
@Getter
@Setter
@TableName("s_sys_role")
@ApiModel(value = "SysRole对象", description = "")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("role_name")
    private String roleName;

    @TableField("description")
    private String description;
}
