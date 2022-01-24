package com.javaex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	private BoardDao boardDao;
	
	public List<BoardVo> list() {
		List<BoardVo> bList = boardDao.getList();
		return bList;
		
	}
}
