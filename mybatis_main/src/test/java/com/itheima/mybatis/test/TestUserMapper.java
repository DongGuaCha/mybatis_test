package com.itheima.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import com.com.itheima.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import com.itheima.mybatis.pojo.User;

public class TestUserMapper {

	@Test
	public void testQueryUserById() throws IOException {
		// 加载全局配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// SqlSessionFactoryBuilder获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// SqlSessionFactory获取会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 底层使用JDK动态代理，MapperProxy
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.queryUserById(2);
		System.out.println(user);
		sqlSession.close();	
	}
}
