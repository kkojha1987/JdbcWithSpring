package com.kanhaiya.test;



import com.kanhaiya.model.Circle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kanhaiya.dao.*;

public class JdbcTest {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	JdbcDaoImpl1 dao=context.getBean("jdbcDaoImpl1", JdbcDaoImpl1.class);
	//Circle circle=new JdbcDaoImpl1().getCircle(1);
	

	//System.out.println(dao.getCircleCount(1));
}
}
