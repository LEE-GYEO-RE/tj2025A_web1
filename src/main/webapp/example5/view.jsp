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
        <h3> 대기 현황 상세 페이지 </h3>
        핸드폰 번호 : <div class="phoneBox"></div>
        인원수 : <div class="countBox"></div>
        <button type="button" onclick="waitingDelete()"> 삭제 </button>
        <button type="button" onclick="waitingUpdateView()"> 수정 </button>
    </div>

    <script src="/example5/view.js"></script>

</body>
</html>