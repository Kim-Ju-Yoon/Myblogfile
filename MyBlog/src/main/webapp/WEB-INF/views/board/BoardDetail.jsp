<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>board</title>
	<link href="resources/Board/css/BoardDetail.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<h2>게시글 상세 화면</h2>
		<table class="board_detail">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<div class="TextBox"></div>
			<tr>
				<th>글 번호</th>
				<td>${detail.uid}</td>
				<th>조회수</th>
				<td>${detail.count}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${detail.id}</td>
				<th>작성일</th>
				<td>${detail.regdate}</td>
			</tr>
			<div>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3">
						<input type="text" id="title" name="title" value="${detail.title}" />
					</td>
				</tr>
				<tr>
					<td colspan="4" class="view_text">
						<textarea title="내용" id="contents" name="contents">${detail.content}</textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="수정" class="BT" formaction="/board/modify"></td>
					<td><input type="submit" value="삭제" class="BT" formaction="/board/remove"></td>
				</tr>
			</div>
		</table>
	</div>
</body>

</html>