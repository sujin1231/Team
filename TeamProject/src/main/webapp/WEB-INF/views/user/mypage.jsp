<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	if(session.getAttribute("username")==null){
	response.sendRedirect("/sessionover"); 
} %>
<%@include file="/resources/include/header.jsp" %>


		<section>
		<div align="center">
			<h2>마이페이지</h2>
			<hr>
			${sessionScope.username }(${sessionScope.name}) 님의 회원 정보를 관리합니다.
			<hr>
			<input type="button" value="비밀번호 변경" class="btn btn-default" onclick="location.href='pwupdate'">
			<input type="button" value="회원정보 변경" class="btn btn-primary" onclick="location.href='update'">
			<input type="button" value="로그아웃" class="btn btn-primary" onclick="location.href='logout'">
			<input type="button" value="회원 탈퇴" class="btn btn-info" onclick="location.href='delete'">
			
		</div>
	</section>


<%@include file="/resources/include/footer.jsp" %>