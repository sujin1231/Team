<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>

<head>
	<style>
		.left-box { float: left; }
		.writer_info {
	    margin-right: 6px;
	    font-size: 13px;
	    font-weight: 700;
		}
		.se-section-text.se-l-default .se-text-paragraph {
	    line-height: 1.8;
	    white-space: break-spaces;
		}
	
	
		.comment-write {
	    margin: 12px 0 29px;
	    padding: 16px 10px 10px 18px;
	    border: 2px solid var(--skincomment-writeBorder);
	    border-radius: 6px;
	    box-sizing: border-box;
	    background: var(--skincomment-writeBg);
		}
		.comment-write textarea {
	    height: auto; /* 내용의 길이에 따라 자동으로 높이 조정 */
	    resize: none; /* 사용자가 크기를 조정할 수 없도록 함 */
	    overflow: auto; /* 내용이 넘칠 경우 스크롤바 생성 */
		}
		.my-box { border:1px solid; padding:10px; width: auto;
					margin: 12px 0 29px; padding: 16px 10px 10px 18px;
					border-radius: 6px; box-sizing: border-box; overflow: auto }
		.right-box { float: right; }
		.comment_inbox_text {
	    overflow-x: hidden;
	    overflow-y: auto;
	    display: block;
	    width: 100%;
	    min-height: 17px;
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
		.comment_info_date {
	    margin-right: 8px;
		}
		
		
		
		
		
	</style>
</head>

<body>
	<section>
		
		<form name="regform" action="register.board" method="post">
			<h2>게시판 글내용 보기</h2>
			<h3 class="left-box">${one.title }</h3>
			<br><br><br>
				<span class="writer_info">${one.writer }</span>
				<span class="writer_info">${one.regdate }</span>
				<hr>
				
				<c:if test="${not empty one.filename }">
					<img src="/resources/files/${one.filename }">
				</c:if>
				
				<span>${one.content }</span>
				
				<p class="se-text-paragraph se-text-paragraph-align- " 
					style="" 
					id="SE-59f7dba5-f7d7-4a8b-8206-1551cabcbe35">
					<span>${one.writer }</span>
				</p>
				<hr>
					
			<!-- 전체 댓글 란 (댓글 목록 + 댓글 작성 칸) -->
			<div class="CommentBox">
		
			<!-- 댓글 작성 부분 -->
			<div class="my-box">
				<div id="comment-write">
				    <b>${one.writer }</b><br><br>
				    <textarea placeholder="댓글을 남겨보세요" class="comment_inbox_text" 
				    	style="overflow: hidden; overflow-wrap: break-word; "></textarea><br>
				    <div class="right-box">
				    	<button id="comment_write_button" onclick="commentWrite()">등록</button>
				    </div>
				</div>
			</div>
			</div>
			
			
			<!-- 댓글 목록 -->
			<div id="comment-list">
					
			<h3 class="comment_title">댓글</h3>
			<hr>
				<ol class="comment_list">
					<li id="" class="comment_item">
						<div class="comment_nickname">${one.num }</div>
						<div class="comment_text_box">
							<p class="comment_text_view">
								<span class="text_comment">  </span>
							</p>
						</div>
						<span class="comment_info_date">현재 시간</span><br><hr>
					</li>
				</ol>
				
			</div>
				
			
			<script th:inline="javascript">
				const writer = document.getElementById("commentWriter").value;
				const contents = document.getElementById("commentContents").value;
				console.log("작성자: ",writer);
				console.log("내용: ",contents);	
				const id = ${one.num}; //게시글 번호
				$.ajax({
					// 요청방식: post, 요청주소: /comment/save, 요청데이터: 작성자, 작성내용, 게시글번호
					type: "post",
					url: "/comment/save",
					data: {
						"commentWriter": writer,
						"commentContents": contents,
						"boardId": id
					},
					success: function (res) {
			               console.log("요청성공", res);
			               let output = "<table>";
			               output += "<tr><th>댓글번호</th>";
			               output += "<th>작성자</th>";
			               output += "<th>내용</th>";
			               output += "<th>작성시간</th></tr>";
			               for (let i in res) {
			                   output += "<tr>";
			                   output += "<td>" + res[i].id + "</td>";
			                   output += "<td>" + res[i].commentWriter + "</td>";
			                   output += "<td>" + res[i].commentContents + "</td>";
			                   output += "<td>" + res[i].commentCreatedTime + "</td>";
			                   output += "</tr>";
			               }
			               output += "</table>";
			               document.getElementById('comment-list').innerHTML = output;
			               document.getElementById('commentWriter').value = '';
			               document.getElementById('commentContents').value = '';
			           },
					error: function(err) {
						console.log("요청 실패", err);
					}
				});
			</script>
			
			
			
			<!-- 글 등록 메뉴  -->
			<table>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="목록" onclick="location.href='board?page=${param.page }'">
					<input type="button" value="수정" onclick="location.href='modify?num=${one.num}&pageNum=${param.pageNum }'">
				</td>
			</tr>
			</table>
		</form>
		
	</section>
	
	
</body>

