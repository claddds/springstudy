<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#board table {
	    width:580px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#board table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#board table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#board table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
</style>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var pwchk = "${pwchk}"
	    if(pwchk == "fail"){
		   alert("비밀번호 틀림");
		   return;
	   }
	});
</script>
<script type="text/javascript">
	function delete_ok(f) {
		if(f.pwd.value.trim().length <=0){
			alert("비번을 입력해주세요");
			f.pwd.focus();
			return;
		}
		f.action="/board_delete.do";
		f.submit();
	}
	function list_go(f) {
		f.action="/board_list.do";
		f.submit();
	}
</script>
</head>
<body>
	<div id="board">
	<form method="post">
		<table summary="게시판 삭제하기">
			<caption>게시판 삭제하기</caption>
			<tbody>
				<tr>
					<th style="width: 40%" class="title">비밀번호 확인:</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="idx" value="${idx}">
						<input type="hidden" name="cPage" value="${cPage}">
						<input type="button" value="삭제" onclick="delete_ok(this.form)"/>
						<input type="button" value="목록" onclick="list_go(this.form)"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>

