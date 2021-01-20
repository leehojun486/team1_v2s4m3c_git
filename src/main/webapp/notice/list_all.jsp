<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
 
  
</script>
 
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" />
 
  <DIV class='title_line'>공지 사항</DIV>
  
  <TABLE class='table table-striped'>
  <colgroup>
    <col style='width: 10%;'/>
    <col style='width: 40%;'/>
    <col style='width: 20%;'/>
    <col style='width: 10%;'/>    
    <col style='width: 20%;'/>
  </colgroup>
 
  <thead>  
  <TR>
    <TH class="th_bs">공지사항 번호</TH>
    <TH class="th_bs">공지사항 제목</TH>
    <TH class="th_bs">공지사항  등록 날짜</TH>
    <TH class="th_bs">기타</TH>
  </TR>
  </thead>
  
  <tbody>
  <c:forEach var="noticeVO" items="${list}">
    <c:set var="noticeno" value="${noticeVO.noticeno }" />
    <TR>
      <TD class="td_bs">${noticeVO.noticeno }</TD>
      <TD class="td_bs"><a href="./read.do?noticeno=${noticeno}">${noticeVO.title }</a></TD>
      <TD class="td_bs">${noticeVO.rdate }</TD>
      <TD class="td_bs">
        <A href="./read_update.do?playlistno=${playlistno }" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
        <A href="./read_delete.do?playlistno=${playlistno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
      </TD>   
    </TR>   
  </c:forEach> 
  </tbody>
</TABLE>
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 