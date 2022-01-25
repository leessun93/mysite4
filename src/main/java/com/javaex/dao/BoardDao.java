package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;
@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> getList() {
		List<BoardVo> boardList = sqlSession.selectList("board.selectList");
		return boardList;
	}

	public BoardVo getoneList(int no) {
		System.out.println("여긴 다오의 겟리스트");
		BoardVo boardList = sqlSession.selectOne("board.selectone", no);
		return boardList;
	}
	public void uphit(int no) {
		System.out.println("여긴 다오의 업힛");
		sqlSession.update("board.updatehit", no);
	}
	public void modify(BoardVo boardVo) {
		System.out.println("다오의 모디");
		sqlSession.insert("board.modify", boardVo);
	}
	public void delete(int no) {
		sqlSession.delete("board.delete", no);
	}
	public void write(BoardVo boardVo) {
		System.out.println("다오으 롸이트");
		sqlSession.insert("board.write", boardVo);
		System.out.println(boardVo);
	}
}
