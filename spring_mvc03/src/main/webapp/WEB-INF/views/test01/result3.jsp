<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과보기</h1>
	<h2>
		<li>올린사람: ${name}</li>
		<li>파일명(올릴 때 이름): ${f_name}</li>
		<li>파일명(저장할 때 이름): ${f_name2}</li>
		<li>파일 종류: ${file_type}</li>
		<li>파일 사이즈: ${size}KB</li>
		<li>수정날짜:${lastday}</li>
		
		사진: <img src="/resources/images/${f_name2}" style="width: 150px;"><br>
	</h2>
	
	
</body>
</html>