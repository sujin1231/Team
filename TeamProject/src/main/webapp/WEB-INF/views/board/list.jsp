<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ include file="/resources/include/header.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>board_main</title>

<style>
      div.row {
        display: flex;
        border: 1px solid #003458;
      }
      div.left {
        width: 20%;
        float: left;
        box-sizing: border-box;
        background: #f2dede;
      }
      div.right {
        width: 80%;
        float: right;
        box-sizing: border-box;
        background: #fff;
        margin: 0 auto;
        text-align: center;
      }
      
      .nav {
        width: 500px;
      }
      
      .side-table ul {
        list-style: none;
     
      }
      
      .side-table li {
        border: 1px;
        padding: 20px 40px;
        margin: 20px;
        
      }
      
      .navbar-nav.flex-row {
	    display: flex;
	    flex-direction: row;
	    
	  }
		
	  .navbar-nav.flex-row > li {
	    flex-grow: 1;
	  }
	  	table {
	  border-collapse: collapse;
	  border-spacing: 0;
	}
	section.notice {
	  padding: 10px 0;
	}
	
	.page-title {
	  margin-bottom: 5px;
	}
	.page-title h3 {
	  font-size: 28px;
	  color: #333333;
	  font-weight: 400;
	  text-align: center;
	}
	
	.pagination {
	  text-align: center;
	}
	
	#board-search .search-window .search-wrap {
	  position: relative;
	/*   padding-right: 124px; */
	  margin: 0 auto;
	  width: 80%;
	  max-width: 564px;
	}
	#board-search .search-window .search-wrap input {
	  height: 40px;
	  width: 100%;
	  font-size: 14px;
	  padding: 7px 14px;
	  border: 1px solid #ccc;
	}
	#board-search .search-window .search-wrap input:focus {
	  border-color: #333;
	  outline: 0;
	  border-width: 1px;
	}
	#board-search .search-window .search-wrap .btn {
	  position: absolute;
	  right: 0;
	  top: 0;
	  bottom: 0;
	  width: 108px;
	  padding: 0;
	  font-size: 16px;
	}
	
	.board-table {
	  font-size: 13px;
	  width: 100%;
	  border-top: 1px solid #ccc;
	  border-bottom: 1px solid #ccc;
	}
	
	.board-table a {
	  color: #333;
	  display: inline-block;
	  line-height: 1.4;
	  word-break: break-all;
	  vertical-align: middle;
	}
	.board-table a:hover {
	  text-decoration: underline;
	}
	.board-table th {
	  text-align: center;
	}
	
	.board-table .th-num {
	  width: 100px;
	  text-align: center;
	}
	
	.board-table .th-date {
	  width: 200px;
	}
	
	.board-table th, .board-table td {
	  padding: 14px 0;
	}
	
	.board-table tbody td {
	  border-top: 1px solid #e7e7e7;
	  text-align: center;
	}
	
	.board-table tbody th {
	  padding-left: 28px;
	  padding-right: 14px;
	  border-top: 1px solid #e7e7e7;
	  text-align: left;
	}
	
	.board-table tbody th p{
	  display: none;
	}
	
	.btn {
	  display: inline-block;
	  padding: 0 30px;
	  font-size: 15px;
	  font-weight: 400;
	  background: transparent;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
	  touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
	  -moz-user-select: none;
	  -ms-user-select: none;
	  user-select: none;
	  border: 1px solid transparent;
	  text-transform: uppercase;
	  -webkit-border-radius: 0;
	  -moz-border-radius: 0;
	  border-radius: 0;
	  -webkit-transition: all 0.3s;
	  -moz-transition: all 0.3s;
	  -ms-transition: all 0.3s;
	  -o-transition: all 0.3s;
	  transition: all 0.3s;
	}
	
	.btn-dark {
	  background: #555;
	  color: #fff;
	}
	
	.btn-dark:hover, .btn-dark:focus {
	  background: #373737;
	  border-color: #373737;
	  color: #fff;
	}
	
	.btn-dark {
	  background: #555;
	  color: #fff;
	}
	
	.btn-dark:hover, .btn-dark:focus {
	  background: #373737;
	  border-color: #373737;
	  color: #fff;
	}
	
	/* reset */
	
	* {
	  list-style: none;
	  text-decoration: none;
	  padding: 0;
	  margin: 0;
	  box-sizing: border-box;
	}
	.clearfix:after {
	  content: '';
	  display: block;
	  clear: both;
	}
	.container {
	  width: 1100px;
	  margin: 0 auto;
	}
	.blind {
	  position: absolute;
	  overflow: hidden;
	  clip: rect(0 0 0 0);
	  margin: -1px;
	  width: 1px;
	  height: 1px;
	}
	.form-inline{
	  text-align: center;
	}
	
		
	
    </style>

</head>
<body>
	<!-- 화면 분할 -->
	<div class="row">
	<div class="left">
	
	<!-- 회원 프로필 -->
	
	
	<!-- 장르별 목록 만들기 -->
	<div id="board-list">
	        <div class="container">
	            <table class="board-table">
	                <nav class="side-table">
					    <ul>
					      <li><a href="register">글 작성</a></li>
					      <li><a href="/board">전체 글 보기</a></li>
					      <li>장르별 글 보기</li>
					      <li><a href="/ro">로맨스</a></li>
					      <li><a href="/co">코미디</a></li>
					      <li><a href="/act">액션</a></li>
					      <li><a href="/fa">판타지</a></li>
					      <li><a href="/horror">공포</a></li>
					    </ul>
					 </nav>
	            </table>
	        </div>
	    </div>
	
	</div>
	<div class="right">
		<!-- 한지민 헤더 자료 -->
		<div id="special-menu">
		<div class="box-special-menu">
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav flex-row">
                	<li>
                		<a href="ro">전체</a>
                	</li>
                	<li>
                		<a href="review">리뷰</a>
                	</li>
                	<li>
                		<a href="recom">추천</a>
                	</li>
                	<li>
                		<a href="info">정보</a>
                	</li>
                </ul>
				   
				
                    <!-- 세션이 없다면 로그인과 조인 메뉴를 나타냄.
                   	<c:choose>
	                    	<c:when test="${sessionScope.user_id == null }">
	                    <li>
	                        <a href="/user/user_login">로그인</a>
	                    </li>
	                    <li>
	                        <a href="/user/user_join" style="color:red">JOIN</a>
	                    </li>
	                   		</c:when>
	                   		<c:otherwise>
	                    <li>
	                        <a href="/user/user_logout">로그아웃</a>
	                    </li>
	                    	</c:otherwise>
					</c:choose>
					 -->
                </ul>
            </div>
            </div>
            </div>
           
	
	<section class="notice">
	  <div class="page-title">
	        <div class="container">
	            <h3>게시판</h3>
	        </div>
	    </div>
	   
	   
	   
	   
	  <!-- board list area -->
	    <div id="board-list">
	        <div class="container">
	            <table class="board-table">
	                <thead>
	                <tr>
	                    <th scope="col" class="th-num">No.</th>
	                    <th scope="col" class="th-title">제목</th>
	                    <th scope="col" class="th-date">작성자</th>
	                    <th scope="col" class="th-date">작성시간</th>
	                    <th scope="col" class="th-num">조회수</th>
	                </tr>
	                </thead>
	                <tbody>
	                <c:forEach var="vo" items="${list.content }"> 
	               <tr>
	                  <td>${vo.num}</td>
	                  <td><a href="content?num=${vo.num }&page=${nowPage-1}">${vo.title}</a></td>
	                  <td>${vo.writer}</td>
	                  <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value = "${vo.regdate}"/></td>
	                  <td>${vo.hit}</td>
	               </tr>
	               </c:forEach>
	                </tbody>
	            </table>
	        </div>
	    </div>
	    <br>
	    
	    <!-- 페이징 구현 -->
		<nav aria-label="Page navigation example">
			 <ul class="pagination pagination-sm">
				<c:if test = "${param.page >= startPage }">
					<li><a href="${route}?page=${param.page - 1 }">이전</a></li>
				</c:if>
				<!-- 1. 페이지 번호 처리 -->
				<c:forEach var="pagenum" begin="${startPage }" end="${endPage }">
					<li class="${nowPage == pagenum ? 'active':'' }">
						<a href="${route}?page=${pagenum-1 }">${pagenum }</a>
					</li>
				</c:forEach>
				<c:if test = "${param.page < endPage - 1}">
					<li><a href="${route}?page=${param.page + 1}">다음</a></li>
				</c:if>
			</ul>
			</nav>	
	    
	     <!-- 작성글 검색 및 글작성하기 메뉴 -->
	             
	    <div id="board-search">
	        <div class="container">
	            <div class="search-window">
	                <form action="">
	                    <div class="search-wrap">
	                        <label for="search" class="blind">제목 검색</label>
	                        <input type="text" name="keyword" placeholder="제목검색">                      
	                        <button type="submit" value="검색" class="btn btn-dark">검색</button>

	                    </div>
	                   
	                </form>
	            </div>
	        </div>
	    </div>
	
	</section>
				
		
	</div>
	</div>
	
	
	
	
</body>
</html>
<script type="text/javascript">
const route = window.location.pathname.replace("/","");
</script>
<%@ include file="/resources/include/footer.jsp" %>
</body>
</html>