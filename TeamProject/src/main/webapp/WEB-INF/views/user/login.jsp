
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file ="/resources/include/header.jsp" %>
	<section>
		<div align="center">
			<h2>로그인 페이지</h2>
			<hr>
			<form name="regForm" action="login" method="post">
			<input type="text" name ="username" placeholder="아이디"><br>
			<input type="password" name ="password" placeholder="비밀번호"><br>
			<br>
			<input type="button" value ="로그인" class="btn btn-default" onclick=check()>
			<input type="button" value ="회원가입" class="btn btn-primary" onclick="location.href='join'">
			
			</form>
	
		</div>
	</section>
	<script>
		function check(){
			//form은 document.태그이름.태그이름으로 하위태그에 접근이 가능함...(dom접근)
			//console.log(documnet.regform.id.value); 공백이 출력됨
			if(document.regForm.username.value == ''){
				alert("아이디는 필수 사항입니다.")
				return;
			}else if(document.regForm.password.value == ''){
				alert("비밀번호는 필수 사항입니다.")
				return;
			}else if(confirm("로그인 하시겠습니까?")){
				document.regForm.submit(); //자바스크립트의 submit()는 form태그 submit기능
				
			}
		}
		
	</script>
	
	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
	

<%@include file ="/resources/include/footer.jsp" %>