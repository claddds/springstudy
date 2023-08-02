package com.ict.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.model.vo.GuestBookVO;

@Repository
public class GuestBookDAO {
	// 실제 Mapper를 호출하는 클래스
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 서비스에서 DB처리하는 메서드를 모두 받아 줘야 한다.
	// Guestbook 리스트
	public List<GuestBookVO> getGuestBookList(){
		return sqlSessionTemplate.selectList("guestbook.list");
	}
	
	// 삽입
	public int getGuestBookInsert(GuestBookVO gvo) {
		return sqlSessionTemplate.insert("guestbook.insert",gvo);
	}
	
	// 상세보기
	public GuestBookVO getGuestBookOneList(String idx) {
		return sqlSessionTemplate.selectOne("guestbook.onelist", idx);
	}
	
	// 삭제
	public int getGuestBookDelete(String idx) {
		return sqlSessionTemplate.delete("guestbook.delete",idx);
	}
	
	// 수정
	public int getGuestBookUpdate(GuestBookVO gvo) {
		return sqlSessionTemplate.update("guestbook.update", gvo);
	}
}
