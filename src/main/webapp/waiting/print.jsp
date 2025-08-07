<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

</head>
<body>
    <jsp:include page="/waiting/header.jsp"></jsp:include>
    <div>
        <h3> 대기 현황 페이지 </h3>
        <table border="1">
            <thead>
                <tr>
                    <tr> 번호 </tr>
                    <tr> 핸드폰 번호 </tr>
                    <tr> 인원수 </tr>
                </tr>
            </thead>
            <tbody id="waitingTbody">


            </tbody>
        </table>


    </div>
    <script src="/waiting/print.js"></script>
    
</body>
</html>