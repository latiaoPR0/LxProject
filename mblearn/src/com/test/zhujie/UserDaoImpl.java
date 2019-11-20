package com.test.zhujie;

import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao{

	@Override
	public void saveUser(User user) {
		System.out.println("保存用户");
	}

}
