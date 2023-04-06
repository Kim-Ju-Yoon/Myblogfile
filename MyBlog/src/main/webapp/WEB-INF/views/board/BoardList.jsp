<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<link href="resources/Board/css/style.css" rel="stylesheet">
</head>
<body>
	<div class="board_wrap">
		<div class="board_title">
			<strong>자유게시판</strong>
			<p>자유게시판을 빠르고 정확하게 알려드립니다.</p>
		</div>
		<!-- board seach area -->
		<div id="board-search">
			<div class="container">
				<div class="search-window">
					<form action="BoardList">
						<div class="search-wrap">
							<select name="type">
								<option value="T">제목</option>
								<option value="C">내용</option>
								<option value="TC">제목+게시글</option>
							</select> <input type="text" name="keyword" value="${paging.cri.keyword}">
							<input type="hidden" name="pageNum" value="${paging.cri.pageNum}">
							<input type="hidden" name="amount" value="${paging.cri.amount}">
							<button type="submit" class="btn btn-dark">검색</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="num">번호</div>
					<div class="title">제목</div>
					<div class="writer">글쓴이</div>
					<div class="date">작성일</div>
					<div class="count">조회</div>
				</div>
				<c:forEach items="${list}" var="boardlist">
					<div>
						<div class="num">${boardlist.uid}</div>
						<div class="title">
							<a href="/BoardDetail?uid=${boardlist.uid}">${boardlist.title}</a>
						</div>
						<div class="writer">${boardlist.id}</div>
						<div class="date">${boardlist.regdate}</div>
						<div class="count">${boardlist.count}</div>
					</div>
				</c:forEach>
			</div>
			<div class="board_page"></div>
			<div class="board_page">
				<c:if test="${paging.prev}">
					<a
						href="/BoardList?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.startPage-1}&amount=${paging.cri.amount}"
						class="bt prev">이전</a>
				</c:if>

				<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
					var="num">
					<a href="/BoardList?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${num}&amount=${paging.cri.amount}" class="num on">${num}</a>
				</c:forEach>
				<c:if test="${paging.next}">
					<a
						href="/BoardList?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.endPage+1}&amount=${paging.cri.amount}"
						class="bt next">다음</a>
				</c:if>
			</div>
			<div class="bt_wrap">
				<a href="/Write" class="on">등록</a>
				<!--<a href="#">수정</a> -->
			</div>
		</div>
	</div>
</body>
</html>