package com.test.iocdi;

public class UserDaoImpl implements UserDao{

	@Override
	public void save(User user) {
		System.out.println("这是保存操作");
	}

}
