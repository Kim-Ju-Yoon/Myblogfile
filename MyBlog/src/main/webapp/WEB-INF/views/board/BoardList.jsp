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
					<form action="board/BoardList">
						<div class="search-wrap">
							<label for="search" class="blind">게시판 내용 검색</label> <input
								id="search" type="search" name="keyword"
								placeholder="검색어를 입력해주세요." value="">
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
				<a href="#" class="bt prev">이전</a> <a href="#" class="num on">1</a>
				<a href="#" class="num">2</a> <a href="#" class="num">3</a> <a
					href="#" class="num">4</a> <a href="#" class="num">5</a> <a
					href="#" class="bt next">다음</a>
			</div>
			<div class="bt_wrap">
				<a href="/html/게시판글작성.html" class="on">등록</a>
				<!--<a href="#">수정</a> -->
			</div>
		</div>
	</div>
</body>
</html>