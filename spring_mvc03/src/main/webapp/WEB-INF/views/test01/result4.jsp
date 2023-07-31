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
		<li>파일명: ${f_name}</li>
		<li>파일 종류: ${f_type}</li>
		<li>파일 사이즈: ${size}KB</li>
		<li>
			<a href="/down.do?f_name=${f_name}">
				<img src="resources/images/${f_name}" style="width: 150px;">
			</a>
		</li>
		사진: <img src="/resources/images/${f_name}" style="width: 150px;"><br>
	</h2>
	
	
</body>
</html>