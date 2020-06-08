package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.ZiXun;
import com.byh.orderonline.pojo.ZiXunExample;
import java.util.List;

public interface ZiXunMapper extends CrudDao<ZiXun> {

    List<ZiXun> selectByExample(ZiXunExample example);

    /**
     * 资讯审核
     * @param zid
     */
    void shenhe(int zid);

}