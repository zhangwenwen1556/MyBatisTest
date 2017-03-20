package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

public interface UserDao {
	
	//根据ID查询用户的信息
	public User findUserById(int id) throws Exception;
	//添加用户的信心
	public void insertUser(User user) throws Exception;
	//删除用户的信息
	public void deleteUser(int id) throws Exception;
	
}
