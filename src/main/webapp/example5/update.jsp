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

    <jsp:include page="/example5/header.jsp"></jsp:include>
    <div>
        <h3> 대기 현황 수정 페이지 </h3>
        핸드폰 번호 : <textarea class="phone"></textarea> <br/>
        인원 수 : <textarea class = "count"></textarea> <br/>
        <button type="button" onclick="waitingUpdate()"> 수정 </button>
    </div>

    <script src="/example5/update.js"></script>
</body>
</html>