<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/resources/include/header.jsp" %>
	<section>
      <div align="center">
         <form name="regForm" action="delete" method="post">
         
         <h2>회원탈퇴 비밀번호 확인</h2>
         
         <table>
           	<tr>
				<td>비밀번호</td>
				<td><input type="password" name ="password" placeholder="현재 비밀번호" ></td>
			</tr>

			<tr>
				<td>비밀번호 확인</td>
			<td><input type="password" name ="password_check" placeholder="비밀번화 확인란" ></td>
        	</tr>   
         </table>
         </form>
            <br>
            <input type="button" value="계정 삭제" class="btn btn-primary" onclick=check()>
            <input type="button" value="마이페이지" class="btn btn-info" onclick="location.href='mypage'">
      </div>
   </section>
   
   <script>
      function check(){
			let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
     		if(regForm.password.value == ''){
				alert("비밀번호를 입력해주세요.")
				return;
			}else if(regForm.password.value != regForm.password_check.value){
				alert("비밀번호가 일치하지않습니다. 확인해주세요.")
			return;
			 }else if(confirm("삭제하면 복구하실 수 없습니다. 계정을 삭제하시겠습니까?")){
				document.regForm.submit();
			 }
      }
   </script>
   
   
<%@include file="/resources/include/footer.jsp" %>