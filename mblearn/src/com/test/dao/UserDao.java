package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.entity.User;

public interface UserDao {
	// 查询数量
	public int count();

	// 更新用户
	public void addUser(User user);

	// 更新用户
	public void modifyUser(User user);

	// 修改密码
	public int updatePwd(@Param("id") Integer id, @Param("userPassword") String pwd);

	// 删除数据
	public void deleteUser(@Param("id") Integer id);

	// 根據id編號查詢數據
	public User findUserById(@Param("id") Integer id);
	
	//查询用户
	public List<User> getUserList(User user);
	
	// 根据名字进行模糊查询
	public List<User> findUserByLikeUserName(@Param("userName") String userName);
	
	// 查询用户(用户名和用户角色)
	public List<User> findUserListByNameAndRoleId(@Param("userRole")Integer userRole,@Param("userName")String userName);
	
	// 依据名字和id
	public User findUserByNameAndId(@Param("id") Integer id,@Param("userName") String userName);

	// 查詢用戶
	public List<User> findUserByRoleId(@Param("userRole") Integer roleId);
	
	// 查詢用戶
	public List<User> findAddressListByUserId(@Param("id") Integer userId);
	
}
