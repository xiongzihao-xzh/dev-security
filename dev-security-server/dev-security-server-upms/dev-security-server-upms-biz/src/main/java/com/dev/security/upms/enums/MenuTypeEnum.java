package com.dev.security.upms.enums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 菜单类型枚举
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
public enum MenuTypeEnum {

    // 0 -> 目录，1 -> 功能
    ;

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<String> menuNameList = new ArrayList<>() {
            {
                add("系统管理");
                add("权限管理");
                add("用户管理");
                add("用户新增");
                add("用户修改");
                add("用户删除");
                add("菜单管理");
                add("菜单新增");
                add("菜单修改");
                add("菜单删除");
                add("角色管理");
                add("角色新增");
                add("角色修改");
                add("角色删除");
                add("分配权限");
                add("部门管理");
                add("部门新增");
                add("部门修改");
                add("部门删除");
            }
        };

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        for (String menuName : menuNameList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", menuName);
            map.put("type", 0);

            result.add(map);
        }

        String json = objectMapper.writeValueAsString(result);
        System.out.println(json);
    }
}
