package com.gpt806.ezs.entity.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gpt806.ezs.base.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author Herb
 * @since 2023-11-30
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TableName("s_sys_dept")
@ApiModel(value = "SysDept对象", description = "")
public class SysDept extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @TableField("level")
    private String level;

    @TableField("seq")
    private Integer seq;

    @TableField("description")
    private String description;

    @TableField("parent_id")
    private Integer parentId;
}
