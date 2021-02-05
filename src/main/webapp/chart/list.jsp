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
    회원
  </DIV>

  <ASIDE class="aside_left">
      <A href='./member/list.do'>인기 차트</A>  
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
    <TH class='th'>No</TH>
    <TH class='th'>Title</TH>
    <TH class='th'>Artist</TH>
  </TR>
 
  <c:forEach var="chart_crawlingVO" items="${list }">
    <c:set var="chartno" value ="${chart_crawlingVO.chartno}" />
  <TR>
    <TD class='td'>${chart_crawlingVO.chartno}</TD>
    <TD class='td'>${chart_crawlingVO.music}</TD>        
    <TD class='td'>${chart_crawlingVO.artist}</TD>
    
  </TR>
  </c:forEach>
  
</TABLE>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>

