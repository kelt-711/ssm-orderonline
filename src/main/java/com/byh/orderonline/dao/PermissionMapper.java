package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.Permission;
import com.byh.orderonline.pojo.PermissionExample;
import java.util.List;

public interface PermissionMapper extends SysDao<Permission>{

    List<Permission> selectByExample(PermissionExample example);

}