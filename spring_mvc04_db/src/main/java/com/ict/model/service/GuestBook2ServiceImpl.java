package com.ict.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.model.dao.GuestBook2DAO;
import com.ict.model.vo.GuestBook2VO;

@Service
public class GuestBook2ServiceImpl implements GuestBook2Service{
	// DAO 호출
	@Autowired
	private GuestBook2DAO guestBook2DAO;

	@Override
	public List<GuestBook2VO> getGuestBookList() {
		// TODO Auto-generated method stub
		return guestBook2DAO.getGuestBookList();
	}

	@Override
	public GuestBook2VO getGuestBookOneList(String idx) {
		return guestBook2DAO.getGuestBookOneList(idx);
	}

	@Override
	public int getGuestBookInsert(GuestBook2VO gvo2) {
		// TODO Auto-generated method stub
		return guestBook2DAO.getGuestBookInsert(gvo2);
	}

	@Override
	public int getGuestBookUpdate(GuestBook2VO gvo2) {
		// TODO Auto-generated method stub
		return guestBook2DAO.getGuestBookUpdate(gvo2);
	}

	@Override
	public int getGuestBookDelete(String idx) {
		return guestBook2DAO.getGuestBookDelete(idx);
	}

	
}
