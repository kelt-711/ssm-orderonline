package com.byh.dao;

import com.byh.orderonline.dao.*;
import java.util.Date;
import com.byh.orderonline.dao.UserMapper;
import com.byh.orderonline.pojo.User;
import com.byh.orderonline.service.UserRoleService;
import com.byh.orderonline.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/*
 *测试函数运行只需要运行单个test_manager函数
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class test_manager {
    @Autowired
    private UserMapper usermapper;
    @Autowired
    private UserService userservice;
    @Autowired
    private UserRoleService userRoleService;
    @Test
    public void testmanager(){
        User user=usermapper.selectByPrimaryKey((long) 32);
        System.out.println(user);
        System.out.println(user);

    }

    /*注意:此代码涉及数据库的修改，执行后表user内容会增加，不要多次重复执行
     * 测试一个完整的添加管理员过程
     *把管理员信息插入到user表格
     * */
    @Test
    public void addManager() {
        System.out.println("\n测试一个完整的添加管理员过程 选择待添加管理员:荆凡\n");
        User user_test=new User();

        //把管理员信息插入到user表格
        String name="荆凡";
        user_test.setName(name);
        System.out.println("从前端获得的姓名信息: "+name);
        String password=RandomStringUtils.randomAlphanumeric(32);
        user_test.setPassword(password);
        String before=RandomStringUtils.randomAlphanumeric(22);
        String salt=before+"==";
        user_test.setSalt(salt);
        user_test.setStatus(1);
        String address="西电海棠六号楼";
        user_test.setAddress(address);
        String phone="12345678910";
        user_test.setPhone(phone);
        Date lasttime=new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        user_test.setLasttime(lasttime);
        userservice.add(user_test);

    }

    /*
     * 删除一名管理员：荆凡(id=43)
     * */
    @Test
    public  void delManager(){
        System.out.println("\n测试一个完整的删除管理员过程 选择待删除管理员:荆凡(id=41)\n");

        //把管理员信息从user表格删除
        userservice.delete((long)43);

    }

}