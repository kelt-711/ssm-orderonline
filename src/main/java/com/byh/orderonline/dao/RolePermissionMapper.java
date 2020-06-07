package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.RolePermission;
import com.byh.orderonline.pojo.RolePermissionExample;
import java.util.List;

public interface RolePermissionMapper extends SysDao<RolePermission>{

    List<RolePermission> selectByExample(RolePermissionExample example);

}