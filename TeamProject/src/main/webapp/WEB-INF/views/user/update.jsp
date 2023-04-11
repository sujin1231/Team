<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/resources/include/header.jsp" %>
	<section>
      <div align="center">
         <form name="regForm" action="update" method="post">
         
         <h2>회원정보 수정</h2>
         
         <table>
            <tr>
               <td><input type="hidden" name="id" value= "${user.getId()}"  readonly></td>
            </tr>
            
            <tr>
               <td>아이디</td>
               <td><input type="text" name="username" value= "${user.getUsername()}"  readonly></td>
            </tr>
            <tr>
               <td>비밀번호</td>
               <td><input type="password" name="password" value= "${user.getPassword()}"  readonly></td>
            </tr>
            
            
            <tr>
               <td>이름</td>
               <td><input type="text" name="name"  value="${user.getName() }"></td>
            </tr>
            
            <tr>
               <td>번호</td>
               <td><input type="text" name="phone"  value="${user.getPhone() }"></td>
            </tr>
            
            
            <tr>
               <td>이메일</td>
               <td><input type="text" name="email" value="${user.getEmail()}"></td>
            </tr>
            
            <tr>
               <td>주소</td>
               <td><input type="text" name="address"  value="${user.getAddress() }"></td>
            </tr>   
         </table>
         </form>
            <br>
            <input type="button" value="정보수정" class="btn btn-primary" onclick=check()>
            <input type="button" value="마이페이지" class="btn btn-info" onclick="location.href='mypage'">
      </div>
   </section>
   
   <script>
      function check(){
         let pnum = /^[0-9]+$/;	
  		 if(regForm.name.value ==''){
            alert("이름을 입력하세요.")   
            return;
         	}else if(regForm.phone.value ==''){
				alert("전화번호를 입력하세요.")
				return;
			}else if(!pnum.test(regForm.phone.value)){
				alert("전화 번호는 숫자만 입력 가능합니다.")
				return;
			} else if(regForm.phone.value.search("-") != -1){
				alert("전화번호에 '-'는 사용불가합니다.")
				return;
			}else if(regForm.email.value ==''){
				alert("이메일을 입력하세요.")
				return;
			}else if(regForm.email.value.search("@") == -1 || regForm.email.value.search(".") == -1){
				alert("이메일 형식 오류입니다.")
				return;
			}else if(regForm.address.value ==''){
				alert("주소입력하세요.")
				return;
			}else if(confirm("정보를 수정 하시겠습니까?")){
            document.regForm.submit();
         }

      }
      
   </script>
<%@include file="/resources/include/footer.jsp" %>