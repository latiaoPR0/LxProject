package com.test.zhujie;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
//	@Autowired
//	@Qualifier("userDao")
	@Resource
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		System.out.println("Service add User");
	}

}
