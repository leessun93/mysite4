package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// 리스트 리스트 + 페이징
	public Map<String, Object> getBoardList2(int crtPage) {
		System.out.println("보드서비스/리스트2");

		// 페이지당 글 갯수
		int listCnt = 10;

		// 현재페이지 처리
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);

		// 시작글번호
		int startRnum = (crtPage - 1) * listCnt + 1;
		// 끝글 번호
		int endRnum = (startRnum + listCnt) - 1;

		List<BoardVo> boardList = boardDao.selectList2(startRnum, endRnum);

		// 페이징 버튼

		// 전체 글 갯수 가져오기
		int totalCnt = boardDao.selectTotal();
		System.out.println("totalCnt=" + totalCnt);
		
		System.out.println("토탈 바로밑 중간지점");
		// 페이지당 버튼갯수
		int pageBtnCount = 5;

		// 마지막 버튼번호*****
		int endPageBtnNo = (int)(Math.ceil(crtPage /(double) pageBtnCount)) * pageBtnCount;

		//시작버튼
		int startPageBtnNo = endPageBtnNo - (pageBtnCount-1);

		//다음 화살표 유무
		boolean next = false;
		if(endPageBtnNo*listCnt < totalCnt) {
			next=true;
		}else {//다음 화살표가 안보이면 마지막 버튼값을 다시계산
			endPageBtnNo = (int)Math.ceil(totalCnt/(double)listCnt);
		}
		
		//이전 화살표 유무
		boolean prev= false;
		if(startPageBtnNo != 1){
			prev = true;
		}
		
	
		//포장
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		pMap.put("boardList", boardList);
		
		System.out.println("여기가 서비스 마지막인디 넘어갈란가");
		
		
		return pMap;

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

		/*
		 * for(int i=1; i<=123; i++) { boardVo.setTitle(i + "번째 제목입니다");
		 * boardVo.setContent(i+"번째 내용입니다"); boardVo.setUserNo(1);
		 * boardDao.write(boardVo); } return 1;
		 */
	}
}
