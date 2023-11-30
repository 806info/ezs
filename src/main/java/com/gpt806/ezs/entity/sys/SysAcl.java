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
 * @since 2023-11-30
 */
@Getter
@Setter
@TableName("s_sys_acl")
@ApiModel(value = "SysAcl对象", description = "")
public class SysAcl extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("acl_module_id")
    private Integer aclModuleId;

    @TableField("type")
    private Integer type;

    @TableField("status")
    private Integer status;

    @TableField("seq")
    private Integer seq;

    @TableField("description")
    private String description;

    @TableField("url")
    private String url;
}
