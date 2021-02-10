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
 
<script type="text/javascript">
  function() {
 // 장르 선택창 
  
}
</script>
</head>
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class="title_line">
    등록된 모든 음악
  </DIV>
  <ASIDE class="aside_left">
    전체 보기 
  </ASIDE>
  <ASIDE class="aside_right">
  
    <A href="./create.do">음악 등록</A>
    <span class='menu_divide' >│</span>
    <A href="./list.do">음악 목록</A>
    
  </ASIDE> 
  
   
  <%-- 음악 :: 검색 기능 --%>
  <DIV style="text-align: right;">  
    <form name='frm' id='frm' method='get' action='./list.do'>
      <%-- <input type='hidden' name='musicno' value='${musicVO.musicno }'> --%>
      <br>
      <c:choose>
        <c:when test="${param.word != '' }"> <%-- 검색하는 경우 --%>
          <input type='text' name='word' id='word' value='${param.word }' 
                     style='width: 20%;'>
        </c:when>
        <c:otherwise> <%-- 검색하지 않는 경우 --%>
          <input type='text' name='word' id='word' value='' style='width: 20%;'>
        </c:otherwise>
      </c:choose>
      <button type='submit'>검색</button>
      <c:if test="${param.word.length() > 0 }">
        <button type='button' 
                     onclick="location.href='./list.do?word='">검색 취소</button>  
      </c:if>    
    </form>
  </DIV>
  
   
  <DIV class='menu_line'></DIV>
  
  <div style='width: 100%;'>
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 10%;"></col>
        <col style="width: 15%;"></col>
        <col style="width: 13%;"></col>
        <col style="width: 13%;"></col>
        
        <col style="width: 10%;"></col>
        <col style="width: 15%;"></col>
        <col style="width: 5%;"></col>
        <col style="width: 5%;"></col>
        <col style="width: 8%;"></col>
                
      </colgroup>
      
      <%-- table 컬럼 --%>
      <thead>
        <tr>
          <th style='text-align: center;'>음악 번호</th>
          <th style='text-align: center;'>음악명</th>
          <th style='text-align: center;'>가수명</th>
          <th style='text-align: center;'>앨범명</th>
          
          <th style='text-align: center;'>장르</th>
          <!-- <th style='text-align: center;'>등록일</th> -->
          <!-- <th style='text-align: center;'>추가</th> -->
          <th style='text-align: center;'>좋아요</th>
          <th style='text-align: center;'>재생 수</th>
          <!-- <th style='text-align: center;'>재생시간</th> -->
          
        </tr>
      
      </thead>
       
      <%-- table 내용 --%>    <%-- begin="0" end="${fn:length(list)}" varStatus="status" --%>
      <tbody>
        <c:forEach var="musicVO" items="${list }">
          <c:set var="memberVO" value="${list_m[status.index]}"/>
          
          <c:set var="musicno" value="${musicVO.musicno }" />
          
          <tr> 
          <td style='text-align: center;'>${musicVO.musicno}</td>
            <td>
              <a href="./read.do?musicno=${musicno }">${musicVO.title}</a> 
            </td> 
          <td style='text-align: center;'>${musicVO.singer}</td>
          <td style='text-align: center;'>${musicVO.album}</td>
          
          <td style='text-align: center;'>${musicVO.genre}</td>
          <%-- <td style='text-align: center;'>${musicVO.rdate.substring(0, 10)}</td> --%>
          
          <%-- <td class="td_bs">
            <c:choose>
              <c:when test="${musicVO.likelist == 'Y'}">
                <A href="../membermusic/delete.do?musicno=${musicno }&memberno=${1}&likelist=${musicVO.likelist}"><IMG src="./images/open.png" style='width: 18px;'></A>
              </c:when>
              <c:otherwise>
                <A href="../membermusic/create.do?musicno=${musicno }&memberno=${1}&membername='관리자'&musictitle=${musicVO.title}&singer=${musicVO.singer}&singerno=${musicVO.singerno }&likelist=${musicVO.likelist}"><IMG src="./images/close.png" style='width: 18px;'></A>
              </c:otherwise>
            </c:choose>
          </td> --%>
          
          <td style='text-align: center;'>${musicVO.likesu}</td>
          <%-- <td style='text-align: center;'>${musicVO.musiclong}</td> --%>
          <td style='text-align: center;'>${musicVO.playsu}</td>
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    <DIV class='bottom_menu'>${paging }</DIV> <!-- paging Line -->
    <br><br>
  </div>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>