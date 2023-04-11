<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/resources/include/header.jsp" %>
	<section>
		
		<div align="center">
			<form name="regForm" id="Form" action="join" method="post">
				<h2>회원가입 페이지</h2>
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name ="username" placeholder="4글자 이상 8글자 이하"></td>
					</tr>

					<tr>
						<td>비밀번호</td>
						<td><input type="password" name ="password" placeholder="8자 이상, 영문 대/소문자"></td>
					</tr>

					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name ="password_check" placeholder="특수문자, 숫자 모두 포함"></td>
					</tr>

					<tr>
						<td>이름</td>
						<td><input type="text" name ="name" ></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="tel" name ="phone" placeholder="'-'을 빼고 입력하세요."></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" name ="email" ></td>
					</tr>

					<tr>
						<td>주소</td>
						<td><input type="text" name ="address" ></td>
					</tr>
				</table>
				<br>
				<input type="button" value="회원가입" class="btn btn-primary" onclick=check()>	<%-- onclick은 자바스크립트 이벤트핸들러 --%>
				<input type="button" value="로그인" class="btn btn-info" onclick="location.href='login'">
			</form>
			<br>
			
		
		
		</div>	
	
	
	
	</section>
	
		<script>
		function check(){
			let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
			let pnum = /^[0-9]+$/;	
			//form은 document.태그이름.태그이름으로 하위태그에 접근이 가능함...(dom접근)
			//console.log(documnet.regform.id.value); 공백이 출력됨
			if(regForm.username.value == ''){
				alert("아이디는 필수 사항입니다.")
				return;
			}else if(regForm.username.value.length < 4 || regForm.username.value.length > 12){
				alert("아이디는 4글자 이상 12글자 이하로 입력하세요.")
				return;
			}else if(regForm.password.value == ''){
				alert("비밀번호는 필수 사항입니다.")
				return;
			}else if(!reg.test(regForm.password.value)){
				alert("비밀번호는 8자 이상, 영문 대문자, 소문자, 특수문자, 숫자를 모두 포함해야합니다.")
			}else if(/(\w)\1\1\1/.test(regForm.password.value)){
				alert("비밀번호에 같은 문자를 4번이상 연속해서 사용할 수 없습니다.")
				return;
			}else if(regForm.password.value.search(" ") != -1){
				alert("비밀번호는 공백을 포함 할 수 없습니다.")
				return;
			}else if(regForm.password.value != regForm.password_check.value){
				alert("비밀번호 확인란을 확인해주세요. ")
				return;
			}else if(regForm.name.value ==''){
				alert("이름은 필수사항입니다.")
				return;
			}else if(regForm.phone.value ==''){
				alert("전화번호는 필수 사항입니다.")
				return;
			}else if(!pnum.test(regForm.phone.value)){
				alert("전화 번호는 숫자만 입력 가능합니다.")
				return;
			}else if(regForm.phone.value.search("-") != -1){
				alert("전화번호에 '-'는 사용불가합니다.")
				return;
			}else if(regForm.email.value ==''){
				alert("이메일은 필수 사항입니다.")
				return;
			}else if(regForm.email.value.search("@") == -1 || regForm.email.value.search(".") == -1){
				alert("이메일 형식 오류입니다.")
				return;
			}else if(regForm.address.value ==''){
				alert("주소는 필수 사항입니다.")
				return;
			}else if(confirm("회원 가입을 하시겠습니까?")){
				regForm.submit(); //자바스크립트의 submit()는 form태그 submit기능
				
			}
		}
		
	</script>

	<%@ include file = "/resources/include/footer.jsp" %>