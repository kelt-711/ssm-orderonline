package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.UserRole;
import com.byh.orderonline.pojo.UserRoleExample;
import java.util.List;

public interface UserRoleMapper extends SysDao<UserRole>{

    List<UserRole> selectByExample(UserRoleExample example);

}