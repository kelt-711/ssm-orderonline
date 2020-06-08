package com.byh.dao;


import com.byh.orderonline.dao.*;
import com.byh.orderonline.pojo.Customer;
import com.byh.orderonline.pojo.Order;
import com.byh.orderonline.pojo.OrderItem;
import com.byh.orderonline.pojo.Product;
import com.byh.orderonline.service.OrderItemService;
import com.byh.orderonline.service.OrderService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



/*
*测试函数运行只需要运行单个test函数
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class test {
    @Autowired
    private CustomerMapper customermapper;
    @Autowired
    private ProductMapper productmapper;
    @Autowired
    private OrderItemMapper orderitemmapper;
    @Autowired
    private  OrderMapper ordermapper;
    @Autowired
    private OrderService orderservice;
    @Autowired
    private OrderItemService orderItemService;

    @Test
    public void testCustomer(){
        Customer customer=customermapper.selectByPrimaryKey(1);
        System.out.println(customer);
        System.out.println(customer);
           
    }


    /*注意:此代码涉及数据库的修改，执行后表order,orderitem内容会增加，不要多次重复执行
    * 测试一个完整的下订单过程 选择用户:test沈id:12
    * 购物车食物 美味奶油蛋糕id:9  x1
    *           香辣鸡腿堡id:14   x2
    *先把订单信息插入到order表格，再把订单详细菜品信息插入到orderitem
    * */
    @Test
    public void testOrder() {
    	System.out.println("测试一个完整的下订单过程 选择用户:test沈\n");
        Order order_test=new Order();
    	Customer customer_test=customermapper.selectByPrimaryKey(12);
        OrderItem orderitem_test1= new OrderItem();
        OrderItem orderitem_test2= new OrderItem();
        Product product_test1=productmapper.selectByPrimaryKey(9);
        Product product_test2=productmapper.selectByPrimaryKey(14);

        //System.out.println(product_test1);
        //把订单信息插入到order表格
        String address="姓名：test沈,邮箱：17130130234.com,配送地址：丁香宿舍楼,手机号：12346667890";
        System.out.println("从前端获得的地址信息: "+address);
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + RandomUtils.nextInt(10000);
        order_test.setCode(orderCode);
        order_test.setAddress(address);
        order_test.setCstid(customer_test.getId());
        order_test.setStatus(1);//已支付未发货
        orderservice.save(order_test);

        //把  美味奶油蛋糕id:9  x1  插入到orderitem
        orderitem_test1.setNumber(1);
        orderitem_test1.setCstid(customer_test.getId());
        orderitem_test1.setPid(product_test1.getId());
        orderitem_test1.setOid(order_test.getId());
        System.out.println(orderitem_test1);
        orderItemService.save(orderitem_test1);

        //把  香辣鸡腿堡id:14   x2  插入到orderitem
        orderitem_test2.setNumber(2);
        orderitem_test2.setCstid(customer_test.getId());
        orderitem_test2.setPid(product_test2.getId());
        orderitem_test2.setOid(order_test.getId());
        orderItemService.save(orderitem_test2);


        //输出订单信息
        Order order_print=ordermapper.selectByPrimaryKey(order_test.getId());
        OrderItem orderitem_print1=orderitemmapper.selectByPrimaryKey(orderitem_test1.getId());
        OrderItem orderitem_print2=orderitemmapper.selectByPrimaryKey(orderitem_test2.getId());
        System.out.println("\n\n订单信息：");
        System.out.println(order_print);
        System.out.println("菜品信息:");
        System.out.println((productmapper.selectByPrimaryKey(orderitem_print1.getPid())).getName()+" ,数量: "+orderitem_print1.getNumber().toString());
        System.out.println((productmapper.selectByPrimaryKey(orderitem_print2.getPid())).getName()+" ,数量: "+orderitem_print2.getNumber().toString());

    	
    }


    /*
    * 产品信息
    *       手抓饼;价格:$7;赞:99;销量:99;status:1;.....
    *
    * */
    @Test
    public  void testadd_porduct(){


    }

    /*
    * 把上面产品删除
    * */
    @Test
    public  void testdel_porduct(){


    }

    /*
    * 添加顾客:名字：testcustomer；.........
    * */
    @Test
    public void testadd_customer(){


    }

    /*
    * 把上面的顾客删除
    * */
    @Test
    public void testdel_customer(){


    }

    /*
    * 添加商家  名字：testadmin；.........
    * */
    @Test
    public void testadd_admin(){


    }

    /*
     * 把上面的商家删除
     * */
    @Test
    public void testdel_admin(){


    }


}
