package com.ict.common;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.multipart.FileRenamePolicy;

@RestController
public class Summer_Controller {
	@Autowired
	private FileReName fileReName;
	
	public FileReName getFileReName() {
		return fileReName;
	}

	public void setFileReName(FileReName fileReName) {
		this.fileReName = fileReName;
	}

	@PostMapping(value="/saveImage.do")
	@ResponseBody
	public Map<String, String> saveImag(ImgVO vo, HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("엥");
		
		// 넘어온 파일 검증
		MultipartFile f = vo.getS_file();
		String fname = null;
		if(f.getSize()>0) {
			// 첨부파일 위치
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			
			UUID uuid = UUID.randomUUID();
			// 같은 파일 이름이 있으면 파일명을 수정해준다.
			fname = uuid.toString()+"_"+f.getOriginalFilename();
			
			// 업로드
			try {
				f.transferTo(new File(path, fname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 비동기식 요청이므로 저장된 파일의 경로와 파일명을 보내야한다.
			map.put("path", "/resources/upload");
			map.put("fname", fname);
			
			// pom.xml에 json변환 해주는 라이브러리 추가
			return map;
		}
		return null;
	}
}
