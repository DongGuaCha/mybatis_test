package com.itheima.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import com.ithiema.mybatis.dao.UserDao;
import com.ithiema.mybatis.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import com.itheima.mybatis.pojo.User;

/**
 * junit模拟service层
 * 注意：分层其实就是代码的重新组织而已，相对于入门程序来说该做的事一件没少，换了一种方式
 * @author Administrator
 *
 */
public class TestUserDao {

	@Test
	public void testQueryUserById() throws IOException{
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.queryUserById(2);
		System.out.println(user);
	}
}
