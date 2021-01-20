<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays"%>
 
 <%
 String[] list_memberno = request.getParameterValues("memberno");
 %>
 
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
    등록된 모든 좋아요리스트 테이블
  </DIV>
  <ASIDE class="aside_left">
    전체 보기 
  </ASIDE>
  <ASIDE class="aside_right">
  
    <A href="./create.do">좋아요리스트 등록</A>
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
        <col style="width: 20%;"></col>
      </colgroup>
      <%-- table 컬럼 --%>
      <thead>
        <tr>  
          <th style='text-align: center;'>회원 번호</th>
          <th style='text-align: center;'>회원의 좋아요 곡 리스트 열람</th>
        </tr>
      
      </thead>
      
       <%-- table 내용 --%>
      <tbody>
        <c:forEach var="membermusicVO" items="${list }">
          <c:set var="memberno" value="${memberVO.memberno }" /> 
          
          <tr> 
          <td style='text-align: center;'>[${membermusicVO.memberno}] 번 회원</td>
          <td>
            <a href="./list_read.do?memberno=${membermusicVO.memberno}">회원's 음악 열람-------></a> 
          </td>
          </tr>
        </c:forEach>
      </tbody>
      
      
    </table>
    <br><br>
  </div>
  
 ** [ ${param.memberno } ] 번 회원의 좋아요 목록 열람중 **  
 <Br>   [] ${membermusicVO.musicno } []  <br>
<%=Arrays.toString(list_memberno) // 널값???
 %>
  
  <!--  -->
  <div style='width: 100%;'>
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 10%;"></col>
        <col style="width: 15%;"></col>
        <col style="width: 15%;"></col>
        <col style="width: 15%;"></col>
        
        <col style="width: 10%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 10%;"></col>
                
      </colgroup>
      
      <%-- table 컬럼 --%>
      <thead>
        <tr>  
          <th style='text-align: center;'>음악 번호</th>
          <th style='text-align: center;'>음악명</th>
          <th style='text-align: center;'>가수명</th>
          <th style='text-align: center;'>앨범명</th>
          
          <th style='text-align: center;'>장르</th>
          <th style='text-align: center;'>등록일</th>
          <th style='text-align: center;'>좋아요</th>
          <th style='text-align: center;'>재생시간</th>
        </tr>
      
      </thead>
      
      <%-- table 내용 --%>
      <tbody>
        <c:forEach var="musicVO" items="${list_m }">
          <c:set var="musicno" value="${musicVO.musicno }" />
          <c:set var="number"  value="${param.mumberno }" />
          <c:set var="like"  value="${musicVO.likelist }" />          
         
          <%--   <c:if test="${name1 == 't1' && name2 == 't2' }" >  </c:if>   --%>
          <c:if test="${number == '${membermusicVO.muiscno }' }">
            <c:if test="${like == 'Y' }">
            
          <tr>
          <td style='text-align: center;'>${musicVO.musicno}</td>
            <td>
              <a href="./read.do?musicno=${musicno }">${musicVO.title}</a> 
            </td> 
          <td style='text-align: center;'>${musicVO.singer}</td>
          <td style='text-align: center;'>${musicVO.album}</td>
          
          <td style='text-align: center;'>${musicVO.genre}</td>
          <td style='text-align: center;'>${musicVO.rdate.substring(0, 10)}</td>
          <td style='text-align: center;'>${musicVO.likesu}</td>
          <td style='text-align: center;'>${musicVO.musiclong}</td>
          </tr>
          
          
             </c:if>
          </c:if> 
        </c:forEach>
      </tbody>
      
      
    </table>
    <br><br>
  </div>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>