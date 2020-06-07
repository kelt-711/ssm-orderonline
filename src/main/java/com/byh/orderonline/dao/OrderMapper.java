package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.Order;
import com.byh.orderonline.pojo.OrderExample;
import java.util.List;

public interface OrderMapper extends CrudDao<Order>{

    List<Order> selectByExample(OrderExample example);

}