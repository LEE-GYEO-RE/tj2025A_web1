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
        <h3> 회원목록조회/수정 </h3>

        <table border="1">
            <thead>
                <tr> 
                    <th> 회원 번호 </th> 
                    <th> 회원 성명 </th>
                    <th> 회원 전화 </th> 
                    <th> 회원 주소 </th>
                    <th> 가입 일자 </th>
                    <th> 고객 등급 </th>
                    <th> 거주 지역 </th>
                </tr>
            </thead>
            <tbody id="memberlistTbody">
                
            </tbody>
        </table>
    </div>

    <script src="/성취도평가/memberlist.js"></script> <!-- JS 불러오기 -->


</body>
</html>