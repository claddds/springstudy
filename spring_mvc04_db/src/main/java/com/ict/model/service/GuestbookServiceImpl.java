package com.ict.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.model.dao.GuestbookDAO;
import com.ict.model.vo.GuestbookVO;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	// DAO 호출
	@Autowired
	private GuestbookDAO guestbookDAO;
	
	public GuestbookDAO getGuestbookDAO() {
		return guestbookDAO;
	}

	public void setGuestbookDAO(GuestbookDAO guestbookDAO) {
		this.guestbookDAO = guestbookDAO;
	}

	@Override
	public List<GuestbookVO> guestbookList() {
		List<GuestbookVO> list = guestbookDAO.guestbookList();
		return list;
	}
	
}
