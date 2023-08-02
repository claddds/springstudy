package com.ict.model.service;

import java.util.List;

import com.ict.model.vo.GuestBook2VO;


public interface GuestBook2Service {
	// 전체보기
	List<GuestBook2VO> getGuestBookList();
	
	// 상세보기	
	GuestBook2VO getGuestBookOneList(String idx);
	
	// 삽입
	int getGuestBookInsert(GuestBook2VO gvo2);
	
	// 수정
	int getGuestBookUpdate(GuestBook2VO gvo2);
	
	// 삭제
	int getGuestBookDelete(String idx);
}
