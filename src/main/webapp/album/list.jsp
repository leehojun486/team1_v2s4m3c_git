<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>team1. Project</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class="title_line">
    등록된 모든 앨범
  </DIV>
  <ASIDE class="aside_left">
    전체 보기 
  </ASIDE>
  <ASIDE class="aside_right">
  
    <A href="./create.do">앨범 등록</A>
    <span class='menu_divide' >│</span>
    <A href="./list.do">목록</A>
    <span class='menu_divide' >│</span>
    <A href="javascript:location.reload();">새로고침</A>
    
  </ASIDE> 
  <DIV class='menu_line'></DIV>
  
  <div style='width: 100%;'>
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 7%;"></col>
        <col style="width: 13%;"></col>
        <col style="width: 20%;"></col>
        <col style="width: 20%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 20%;"></col>
      </colgroup>
      
      <%-- table 컬럼 --%>
      <thead>
        <tr>
          <th style='text-align: center;'>번호</th>
          <th style='text-align: center;'>표지</th>
          <th style='text-align: center;'>앨범명</th>
          <th style='text-align: center;'>가수명</th>
          <th style='text-align: center;'>장르</th>
          <th style='text-align: center;'>수록곡순서</th>
          <th style='text-align: center;'>음악제목</th>
        </tr>
      
      </thead>
      
      <%-- table 내용 --%>
      <tbody>
        <c:forEach var="albumVO" items="${list }">
          <c:set var="albumno" value="${albumVO.albumno }" />
          
          <tr> 
            <td style='text-align: center;'>${albumVO.albumno}</td>
            <td style='text-align: center;'>
              <a href="./read.do?albumno=${albumno}">"앨범썸네일공간 및 앨범 열람"</a>
            </td>
            <td style='text-align: center;'>${albumVO.title}</td>
            <td style='text-align: center;'>${albumVO.artist}</td>
            <td style='text-align: center;'>${albumVO.genre}</td>
            <td style='text-align: center;'>${albumVO.listno}</td>
            <td style='text-align: center;'>
              <a href="../music/read.do?musicno=${musicVO.musicno}">${albumVO.music}</a> 
            </td> 
            
            <%-- <td style='text-align: center;'>${singerVO.rdate.substring(0, 10)}</td> --%>
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    <br><br>
  </div>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>