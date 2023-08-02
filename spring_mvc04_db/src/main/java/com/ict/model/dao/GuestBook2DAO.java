package com.ict.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.model.vo.GuestBook2VO;

@Repository
public class GuestBook2DAO {
	// 실제 Mapper를 호출하는 클래스
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 서비스에서 DB처리하는 메서드를 모두 받아 줘야 한다.
	// Guestbook 리스트
	public List<GuestBook2VO> getGuestBookList(){
		return sqlSessionTemplate.selectList("guestbook2.list");
	}
	
	// 삽입
	public int getGuestBookInsert(GuestBook2VO gvo) {
		return sqlSessionTemplate.insert("guestbook2.insert",gvo);
	}
	
	// 상세보기
	public GuestBook2VO getGuestBookOneList(String idx) {
		return sqlSessionTemplate.selectOne("guestbook2.onelist", idx);
	}
	
	// 삭제
	public int getGuestBookDelete(String idx) {
		return sqlSessionTemplate.delete("guestbook2.delete",idx);
	}
	
	// 수정
	public int getGuestBookUpdate(GuestBook2VO gvo) {
		return sqlSessionTemplate.update("guestbook2.update", gvo);
	}
}
