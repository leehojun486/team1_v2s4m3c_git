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
<c:set var="singerno" value="${albumVO.albumno}" />
<%-- <c:set var="contentsno" value="${contentsVO.contentsno }" /> --%>

<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class='title_line'>
    앨범 조회
  </DIV>
  
  <ASIDE class="aside_left">
    조회 > ${albumVO.title }
  </ASIDE>
  <ASIDE class="aside_right">
    <A href="./create.do">글 등록</A>
    <span class='menu_divide' > | </span>
    <A href='../attachfile/create.do?contentsno=${contentsno }&cateno=${cateno }'>파일 등록</A>
    <span class='menu_divide' > | </span>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' > | </span> 
    <A href='./list.do?albumno=${albumno }'>목록</A>
    <span class='menu_divide' > | </span> 
    <A href='./update.do?albumno=${albumno }'>수정</A>
    <span class='menu_divide' > | </span> 
    <A href='./delete.do?albumno=${albumno }'>삭제</A>
    
  </ASIDE> 
  
  <div class='menu_line'></div>

  <FORM name='frm' method="get" action='./update.do'>
      <input type="hidden" name="albumno" value="${albumno}">
      <fieldset class="fieldset">
        <ul>
          <li class="li_none" style='border-bottom: solid 1px #AAAAAA;'>
            <span>앨범명 : ${albumVO.title}</span>
          </li>
          <li class="li_none">
            <span>가수명 : ${albumVO.artist}</span>
          </li>
          <li class="li_none">
            <span>장르 : ${albumVO.genre}</span>
          </li>
        </ul>
      </fieldset>
  </FORM>




<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>

</html>