package com.ict.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.model.dao.GuestBookDAO;
import com.ict.model.vo.GuestBookVO;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	// DAO 호출
	@Autowired
	private GuestBookDAO guestBookDAO;

	@Override
	public List<GuestBookVO> getGuestBookList() {
		return guestBookDAO.getGuestBookList();
	}


	@Override
	public int getGuestBookInsert(GuestBookVO gvo) {
		// TODO Auto-generated method stub
		return guestBookDAO.getGuestBookInsert(gvo);
	}

	@Override
	public GuestBookVO getGuestBookOneList(String idx) {
		
		return guestBookDAO.getGuestBookOneList(idx);
	}
	
	@Override
	public int getGuestBookUpdate(GuestBookVO gvo) {
		return guestBookDAO.getGuestBookUpdate(gvo);
	}

	@Override
	public int getGuestBookDelete(String idx) {
		return guestBookDAO.getGuestBookDelete(idx);
	}
	
}
