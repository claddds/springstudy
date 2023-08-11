package com.ict.board.model.service;

import java.util.List;
import java.util.Map;

import com.ict.board.model.vo.Board_VO;

public interface Board_Service {
	// 리스트
	public List<Board_VO> getList();
	
	// 전체 게시물의 수
	public int getTotalCount();
	
	// 페이징처리를 위한 리스트
	public List<Board_VO> getList(int offset, int limit);
	
	int getInsert(Board_VO bv);
	
	int getBoardHit(String idx);
	
	// 상세보기
	Board_VO getBoardOneList(String idx);
	
	int getLevUpdate(Map<String, Integer> map);
	
	int getAnsInsert(Board_VO bv);
	
	// 원글 수정
	int getUpdate(Board_VO bv);
	// 원글 삭제
	int getDelete(String idx);
}
