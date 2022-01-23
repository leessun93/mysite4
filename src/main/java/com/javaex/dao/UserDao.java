package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	//유저정보 가져오기 (로그인시 사용)
	public UserVo getUser(UserVo userVo) {
		System.out.println("다오의 겟유저");
		System.out.println(userVo);
		UserVo authUser = sqlSession.selectOne("user.getUser", userVo);
		return authUser;
	}
	
}
