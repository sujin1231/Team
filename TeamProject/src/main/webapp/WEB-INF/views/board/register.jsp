	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
	.register {
    width: 800px; margin: 0 auto;
    border-top: 3px solid gray; border-bottom: 3px solid gray;
	}
	.register input {width: 676px; padding: 10px; margin: 12px auto 0;}
	.register .text {table-layout: fixed;
    height: 300px; white-space: pre-line; word-break: break-all;
	}
	.register .button {padding: 0 200px; margin: 15px auto;}    
	.register .button a {
    border: 1px solid black; background: gainsboro;
    margin: 10px; padding: 5px;
    text-decoration: none; color: black;
	}
	.register .button a:hover {color: blueviolet;}
	.register p {text-align: center;}
	
	.comment_inbox_text {
	    overflow-x: hidden;
	    overflow-y: auto;
	    display: block;
	    width: 100%;
	    min-height: 10px;
	    padding-right: 1px;
	    border: 0;
	    font-size: 13px;
	    -webkit-appearance: none;
	    resize: none;
	    box-sizing: border-box;
	    background: transparent;
	    color: var(--skinTextColor);
	    outline: 0;
		}


	</style>

</head>
<body>
	<header>
	        <div class="homebox">
	            <div>
	                <a href="index.html" class="logo"></a>
	            </div>
	        </div>
	    </header>
	 
	    <main>
	    <h2><center>글 작성</center></h2>
	        <form class="register" method="POST" action="/save" enctype="multipart/form-data">
	        	<c:forEach var="one" items="${list }">
		            제목 : <input type="text" name="title" id="title">
		            <hr>
		            작성자 : <input type="text" name="writer" id="writer" value="${one.writer }"> 
		            <hr>
		            장르 :
		            <select id="genre" name="genre">
		            	<option value="">=선택=</option>
		                <option value="로맨스">로맨스</option>
		                <option value="코미디">코미디</option>
		                <option value="액션">액션</option>
		                <option value="핀타지">판타지</option>
		                <option value="공포">공포</option>
	             	</select>
	             	<hr>
	             	분류 :
	             	<select id="category" name="category">
	             		<option value="">=선택=</option>
		                <option value="리뷰">리뷰</option>
		                <option value="추천">추천</option>
		                <option value="정보">정보</option>
	             	</select>
	             	<hr>
	             	<input type="file" name="file" id="file">
	             	<hr>
		            내용 : <br>
		            <textarea name="content" id="content" placeholder="내용을 입력해주세요." class="text" required></textarea>		          
		        </c:forEach>
		            <div class="button">
		                <p>
			               <input type="submit" value="등록" >
			               <input type="button" value="목록" onclick="location.href='board'">
			               <a href="board">목록</a>
		                </p>
		            </div>
	            
	        </form>
	    </main>
	 
</body>
</html>