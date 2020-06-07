package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.Role;
import com.byh.orderonline.pojo.RoleExample;
import java.util.List;

public interface RoleMapper extends SysDao<Role> {

    List<Role> selectByExample(RoleExample example);

}