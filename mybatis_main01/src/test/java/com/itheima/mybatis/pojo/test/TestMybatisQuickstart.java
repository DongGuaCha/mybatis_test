package com.itheima.mybatis.pojo.test;

import java.io.InputStream;

import com.itheima.mybatis.pojo.pojo.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMybatisQuickstart {
	@Test
	public void testQueryBlogById() throws Exception {
		// 1. 加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 2. 创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 3. 创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 5. 执行SqlSession对象执行查询，获取结果Blog
		// 第一个参数是BlogMapper.xml的statement的id，第二个参数是执行sql需要的参数；
		Blog blog = sqlSession.selectOne("queryBlogById", 1);

		// 6. 打印结果
		System.out.println(blog);

		// 7. 释放资源
		sqlSession.close();
	}

}
