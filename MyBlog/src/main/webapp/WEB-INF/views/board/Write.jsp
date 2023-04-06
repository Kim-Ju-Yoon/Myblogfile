<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="https://cdn.ckeditor.com/ckeditor5/35.1.0/classic/ckeditor.js"></script>
 <link href="resources/Board/css/Write.css" rel="stylesheet">
</head>
<body>
    <div class="board_write">
        <select class="items">
            <option value="공지사항">공지사항</option>
            <option value="자유게시판">자유게시판</option>
            <option value="Q&A">Q&A</option>
        </select>
            <div class="write_area">
                <form action="/Write" method="post">
                    <div class="in_title">
                        <textarea name="title" id="utitle" rows="1" cols="55" placeholder="제목을 입력하세요" maxlength="100" ></textarea>
                    </div>
 
                    <div class="wi_line"></div>
                    <div class="in_content">
                        <textarea name="content" id="content_area" placeholder="내용을 입력하세요" ></textarea>
                    </div>
 
                    <div class="bt_se">
                        <button type="submit">글 작성</button>
                        <button type="reset">취소</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script type="text/javascript">

        ClassicEditor
        .create(document.querySelector('#content_area'))

        
        </script>
</html>