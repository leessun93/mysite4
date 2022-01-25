package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> list() {
		List<BoardVo> bList = boardDao.getList();
		return bList;
		
	}
	
	public BoardVo getoneList(int no) {
		System.out.println("여긴 서비스영역");
		boardDao.uphit(no);
		BoardVo oneList = boardDao.getoneList(no);
		
		return oneList;
	}
	public BoardVo modifyForm(int no) {
		System.out.println("서비스 모디폼");
		BoardVo oneList = boardDao.getoneList(no);
		return oneList;
	}
	
	public void modify(BoardVo boardVo) {
		System.out.println("서비스영역 모디 했다");
		boardDao.modify(boardVo);
	}
	public void delete(int no) {
		System.out.println("다오의 딜리트 영역");
		boardDao.delete(no);
	}
	public void write(BoardVo boardVo, UserVo authVo) {
		System.out.println("서비스의 롸이트");
		int no = authVo.getNo();
		boardVo.setUserNo(no);
		boardDao.write(boardVo);
	}
}
