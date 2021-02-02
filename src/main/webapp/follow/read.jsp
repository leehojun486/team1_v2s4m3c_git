<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
 
<script type="text/javascript">
  $(function(){
 
  });
</script>
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
 
  <DIV class='title_line'>
    구덕자 조회
  </DIV>

  <ASIDE class="aside_left">
      <A href='./member/list.do'>회원 목록</A>  
  </ASIDE>

 
  <div class='menu_line'></div>
 
  <table class="table table-striped" style='width: 100%;'>
  <caption>관리자만 접근가능합니다.</caption>
  <colgroup>
    <col style='width: 25%;'/>
    <col style='width: 50%;'/>
    <col style='width: 25%;'/>
  </colgroup>
  <TR>
    <TH class='th'>번호</TH>
    <TH class='th'>구독자닉네임</TH>
    <TH class='th'>구독아이디</TH>
  </TR>
  <c:forEach var="followVO" items="${list }">
    <c:set var="followno" value ="${followVO.followno}" />
    <c:set var="follower" value ="${followVO.follower}" />
    <c:set var="memberno" value ="${followVO.memberno}" />
    <c:set var="mid" value ="${followVO.mid}" />
  <TR>
    <TD class='td'>${followVO.followno}</TD>
     <TD class='td'>${followVO.mnic}</TD>        
     <TD class='td'>${followVO.mid}</TD>     
  </TR>

  </c:forEach>
  
</TABLE>
 
<DIV class='bottom_menu'>
    <c:choose>
    <c:when test="${mid != sessionScope.memberid }">   
      <TD class='td'>
   <button type='button' onclick="location.href='./create.do?follower=${param.follower }&memberno=${sessionScope.memberno}'">구독</button>
    </TD>
    </c:when>
          <c:when test="${mid == sessionScope.memberid  }">     
        <TD class='td'>
   <button type='button' onclick="location.href='./delete.do?followno=${followno }'">구독취소</button>
      </TD>
        </c:when>
    </c:choose>
  <button type='button' onclick="location.reload();">새로 고침</button>
</DIV>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>

