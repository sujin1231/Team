<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



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
	
	
		.CommentWriter {
	    margin: 12px 0 29px;
	    padding: 16px 10px 10px 18px;
	    border: 2px solid var(--skinCommentWriterBorder);
	    border-radius: 6px;
	    box-sizing: border-box;
	    background: var(--skinCommentWriterBg);
		}
		.CommentWriter textarea {
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
				
				<img src="${board.filePath}" alt="사진">
				<span${one.content }></span>
				
				<p class="se-text-paragraph se-text-paragraph-align- " 
					style="" 
					id="SE-59f7dba5-f7d7-4a8b-8206-1551cabcbe35">
					<span>${one.writer }</span>
				</p>
				<hr>
					
			<!-- 전체 댓글 란 (댓글 목록 + 댓글 작성 칸) -->
			<div class="CommentBox">
		
			<!-- 댓글 목록 -->
			<h3 class="comment_title">댓글</h3>
			<hr>
				<ol class="comment_list">
					<li id="" class="comment_item">
						<div class="comment_nickname">${one.num }</div>
						<div class="comment_text_box">
							<p class="comment_text_view">
								<span class="text_comment">${one.content }</span>
							</p>
						</div>
						<span class="comment_info_date">현재 시간</span><br><hr>
					</li>
					<li id="" class="comment_item">
						<div class="comment_nickname">${one.num }</div>
						<div class="comment_text_box">
							<p class="comment_text_view">
								<span class="text_comment">${one.content }</span>
							</p>
						</div>
						<span class="comment_info_date">현재 시간</span><br><hr>
					</li>
					<li id="" class="comment_item">
						<div class="comment_nickname">${one.num }</div>
						<div class="comment_text_box">
							<p class="comment_text_view">
								<span class="text_comment">${one.content }</span>
							</p>
						</div>
						<span class="comment_info_date">현재 시간</span><br><hr>
					</li>
				</ol>
			
			
				
				
			
			<!-- 댓글 작성 부분 -->
			<div class="my-box">
				<div id="CommentWriter">
				    <b>${one.writer }</b><br><br>
				    <textarea placeholder="댓글을 남겨보세요" class="comment_inbox_text" 
				    	style="overflow: hidden; overflow-wrap: break-word; "></textarea><br>
				    <div class="right-box">
				    	<button id="comment_write_button" onclick="commentWrite()">등록</button>
				    </div>
				</div>
			</div>
			</div>
				
			<!-- 글 등록 메뉴  -->
			<table>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="목록" onclick="location.href='list?pageNum=${param.pageNum }'">
					<input type="button" value="수정" onclick="location.href='modify?num=${one.num}&pageNum=${param.pageNum }'">
				</td>
			</tr>
			</table>
		</form>
		
	</section>
	
	
</body>

