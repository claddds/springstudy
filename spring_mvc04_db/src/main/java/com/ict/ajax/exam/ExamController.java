package com.ict.ajax.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Controller
public class ExamController {
	@RequestMapping("/kma_go.do")
	public ModelAndView getKmago() {
		ModelAndView mv = new ModelAndView("result");
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				sb.append(msg);
			}
			
			InputSource in = new InputSource(new StringReader(sb.toString()));
			
			// 자바에서 XML 파싱하는 방법: DOM방식, SAX방식
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(in);
			
			// 저장할 vo를 만든다.
			ArrayList<KMA_VO> list = new ArrayList<KMA_VO>();
			
			// 원하는 태그 찾기  ocument.getElementsByTagName("태그이름");
			NodeList locals = document.getElementsByTagName("local");
			// KMA_VO[] arr = new KMA_VO[locals.getLength()];
			
			for (int i = 0; i < locals.getLength(); i++) {
				// 태그의 텍스트 구하기
				String local = locals.item(i).getFirstChild().getNodeValue();
				// 태그의 속성 구하기
				String ta = ((Element)(locals.item(i))).getAttribute("ta");
				String desc = ((Element)(locals.item(i))).getAttribute("desc");
				String icon = ((Element)(locals.item(i))).getAttribute("icon");
				
				KMA_VO kma_vo = new KMA_VO(local, ta, desc, icon);
				list.add(kma_vo);
			}
			mv.addObject("list",list);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("/kma_go2.do")
	public ModelAndView getKmago2() {
		ModelAndView mv = new ModelAndView("result");
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			
			String msg = "";
			while ((msg = br.readLine()) != null) {
				sb.append(msg);
			}
			InputSource in = new InputSource(new StringReader(sb.toString()));
			
			SAXBuilder builder = new SAXBuilder();
			org.jdom2.Document document = builder.build(in);
			org.jdom2.Element rootElement = document.getRootElement();
			org.jdom2.Element weather = rootElement.getChild("weather");
			
			List<org.jdom2.Element> list = weather.getChildren();
			for (org.jdom2.Element k : list) {
				// 
				String loc = k.getName();
				String ta = k.getAttributeValue("ta");
				
				System.out.println("loc: "+loc+"ta:"+ta);
			}
			return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
