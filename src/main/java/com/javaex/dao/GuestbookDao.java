package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	@Autowired
	private SqlSession sqlSession;

	//리스트출력
	
	public List<GuestbookVo> getList(){
		
		
		List<GuestbookVo> guestBookList = sqlSession.selectList("guestbook.selectList");
		return guestBookList;
	}
	//딜리트
	public void delete(GuestbookVo guestbookVo) {
		sqlSession.delete("guestbook.delete", guestbookVo);	
	}
	//add
	public void add(GuestbookVo guestbookVo) {
		sqlSession.insert("guestbook.insert", guestbookVo);
	}
	
}
