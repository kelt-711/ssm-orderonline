package com.byh.dao;

import com.byh.orderonline.dao.UserMapper;
import com.byh.orderonline.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class test_manager {
    @Autowired
    private UserMapper usermapper;
    @Test
    public void testManager(){
        User user=usermapper.selectByPrimaryKey((long) 1);
        System.out.println(user);
        System.out.println(user);

    }

    @Test
    public void testOrder() {
        System.out.println("测试一个完整的编辑管理员过程 选择管理员:visitor\n");


    }


}