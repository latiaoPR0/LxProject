package com.test.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.zhujie.User;
import com.test.zhujie.UserDao;
import com.test.zhujie.UserService;



public class TestZhuJi {
	public static void main(String[] args) {
//		testComponent();
	}
	@Test
	public void testComponent() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		userDao.saveUser(new User());
	}
	
	private static void testService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService UserService = (UserService) context.getBean("userService");
		UserService.addUser(new User());
	}
	

}
