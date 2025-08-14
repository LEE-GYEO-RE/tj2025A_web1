<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="/css/member/info.css">

</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    
    <div>
        <h3> 마이페이지 </h3>
        회원번호 : <div class="mno"> </div> 
        아이디 : <div class="mid">  </div>
        이름 : <div class="mname"> </div>
        연락처 : <div class="mphone"> </div>
        가입일 : <div class="mdate"> </div>
        <a href="/member/update.jsp"> 회원정보 수정 </a>
        <a href="/member/pwdupdate.jsp"> 비밀번호 수정 </a>
        <a href="#" onclick="onDelete()"> 회원 탈퇴 </a>
    </div>
    <script src="/js/member/info.js"></script>
</body>
</html>