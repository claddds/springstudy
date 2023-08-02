package com.ict.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ict.model.vo.GuestBook2VO;

public class FileUtils {
	public List<GuestBook2VO> parseFileInfo(int seq, HttpServletRequest request, 
			MultipartHttpServletRequest mhsr) throws IOException
}
