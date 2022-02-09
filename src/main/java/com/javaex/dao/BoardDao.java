package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	//리스트 글 가져오기(리스트+페이징)
	public List<BoardVo> selectList2(int startRnum, int endRnum){
		System.out.println("보드다오 도킹 완료");
		System.out.println(startRnum+ ","+endRnum);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList2",map);
		System.out.println(boardList);
		return boardList;
	}
	
	//전체 글 개수 가져오기
	public int selectTotal() {
		System.out.println("보드 서비스의 셀렉트 토탈 도킹");
		
		return sqlSession.selectOne("board.totalCnt");
		
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
