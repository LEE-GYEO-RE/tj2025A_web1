<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div class="container">
        <div class="ptitle">
            제목
        </div>
        <div class="pcontent">
            내용
        </div>
        <div class="pdate">
            날짜
        </div>
        <div class="pview">
            조회수
        </div>

    </div>

    <script src="/js/post/detail.js"></script>
</body>
</html>