package com.byh.orderonline.service;

import com.byh.orderonline.pojo.Category;

public interface CategoryService extends CrudService<Category> {
    /**
     * 更新分类
     * @param category
     */
    public void update(Category category);
}
