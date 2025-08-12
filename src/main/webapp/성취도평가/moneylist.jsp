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

    <jsp:include page="/성취도평가/header.jsp"></jsp:include>  <!-- 헤더 .jsp 불러오기 -->
    <div>
        <h3> 회원매출조회 </h3>

        <table border="1">
            <thead>
                <tr> 
                    <th> 회원 번호 </th> 
                    <th> 회원 성명 </th>
                    <th> 고객 등급 </th> 
                    <th> 매출 </th>
                </tr>
            </thead>
            <tbody id="moneylistTbody">
                
            </tbody>
        </table>
    </div>

    <script src="/성취도평가/moneylist.js"></script> <!-- JS 불러오기 -->


</body>
</html>