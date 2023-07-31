<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<style type="text/css">
	table {
	width: 600px; border-collapse: collapse; text-align: center;
 }
 	table, th, td{
 		border: 1px solid black; padding: 3px;
 	}
 	div{
 		width:600px;
 		text-align: center;
 		margin: auto;
 	}
</style>
<script type="text/javascript">
	function addGuest() {
		location.href="/guestbook_write.do";
	}
</script>
</head>
<body>
	<div>
		<h2>방명록 리스트</h2>
		<hr>
		<table>
			<thead>
				<tr><th>번호</th><th>작성자</th><th>제목</th><th>작성일</th></tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}">
						<tr><td colspan="4"><h2>원하는 정보가 존재하지 않습니다.</h2></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="k" items="${list}" varStatus="vs">
						   <tr>
						       <td>${vs.count}</td> 
						       <td>${k.m_name}</td> 
						       <td><a href="/jsp/GuestController?cmd=onelist&idx=${k.idx}"> ${k.subject} </a></td> 
						       <td>${k.m_reg.substring(0,10)}</td>
						   </tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<tr><td colspan="4"><button onclick="addGuest()">방명록쓰기</button></td></tr>
			</tfoot>
		</table>
	</div>
</body>
</html>