package com.byh.dao;

import com.byh.orderonline.dao.CustomerMapper;
import com.byh.orderonline.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class test {
    @Autowired
    private CustomerMapper customermapper;
    @Test
    public void testCustomer(){
        Customer customer=customermapper.selectByPrimaryKey(1);
        System.out.println(customer);
        System.out.println(customer);
           
    }
    
    @Test
    public void testOrder() {
    	System.out.println("测试一个完整的下订单过程 选择用户:test沈\n");
    	
    	
    }
    

}
