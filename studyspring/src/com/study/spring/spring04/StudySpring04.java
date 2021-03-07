package com.study.spring.spring04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-11-23 22:52
 **/
public class StudySpring04 {

    ApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring04/conf/jdbc.xml");
    JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void updateTest(){

        //单次添加
       /*
        String sql = "insert into user values(null,?,?,?,?)";
        jdbcTemplate.update(sql,"胡歌","5215","ShangHai","23213133");
       */


        //注意在 批量删除 和 批量更新 以及 模糊查询 的时候是不能够用直接用占位符的 切记切记
        //①批量删除正确方式
        //因为在编译的时候会自动给占位符加上""，所以需要给 ("+id+")--> ""8,9"" 加上引号 中和一下 哈哈哈
        String id = "8,9";
        String sql = "delete from user where id in("+id+")"; //
        jdbcTemplate.update(sql);

    }

    @Test
    public void batchUpdateTest(){

        String sql = "insert into user values(null,?,?,?,?)";

        List<Object[]> list = new ArrayList();
        list.add(new Object[]{"胡歌","5215","ShangHai","23213133"});
        list.add(new Object[]{"库里","52315","Shan321gHai","2321323133"});
        list.add(new Object[]{"詹姆斯","23135215","Sh2angHai","2321233133"});
        jdbcTemplate.batchUpdate(sql,list);

    }

    @Test
    public void queryTest(){

        String sql = "select count(*) from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);

        String sql2 = "select id,name,password,address,phone from user where id = ?";
        // 将数据库列名和实体类绑定映射
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        //查询单条数据
        User user = jdbcTemplate.queryForObject(sql2, new Object[]{2}, rowMapper);
        System.out.println(user);
        //查询多条数据
        String sql3 = "select id,name,password,address,phone from user";
        List<User> users = jdbcTemplate.query(sql3, rowMapper);
        for (User user1 : users) {
            System.out.println(user1);
        }


    }




}
