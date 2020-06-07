package com.byh.orderonline.dao;

import com.byh.orderonline.pojo.OrderItem;
import com.byh.orderonline.pojo.OrderItemExample;
import java.util.List;

public interface OrderItemMapper extends CrudDao<OrderItem>{

    List<OrderItem> selectByExample(OrderItemExample example);

}