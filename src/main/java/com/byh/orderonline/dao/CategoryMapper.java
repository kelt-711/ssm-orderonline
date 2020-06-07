package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.Category;
import com.byh.orderonline.pojo.CategoryExample;
import java.util.List;

public interface CategoryMapper extends CrudDao<Category>{

     List<Category> selectByExample(CategoryExample example);

}