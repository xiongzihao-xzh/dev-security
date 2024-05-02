package com.dev.security.upms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 菜单表
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_menu")
public class Menu {

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 菜单名
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 菜单类型
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 权限标识
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 顺序
     */
    @TableField(value = "`order`")
    private Integer order;

    /**
     * 父菜单 id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "create_by")
    private String createBy;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_by")
    private String updateBy;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(value = "delete_flag")
    private Integer deleteFlag;
}
