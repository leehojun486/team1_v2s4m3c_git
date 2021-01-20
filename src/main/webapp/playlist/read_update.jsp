<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title></title>
 
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
 
  <DIV class='title_line'>플레이리스트 > ${playlistVO.playlistname } 조회(수정)</DIV>
 
  <DIV id='panel_create' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
    <FORM name='frm_update' id='frm_update' method='POST' action='./update.do'>
      <input type='hidden' name='playlistno' id='playlistno' value='${playlistVO.playlistno }'>
        
      <label>플레이리스트 이름</label>
      <input type='text' name='playlistname' value="${playlistVO.playlistname }" required="required" style='width: 25%;'>
 
      <label>수록된 음악 수</label>
      <input type='number' name='cntmusic' value="${playlistVO.cntmusic }" required="required" 
                min='1' max='1000' step='1' style='width: 5%;'>
                
      <label>좋아요 수</label>
      <input type='number' name='likes' value="${playlistVO.likes }" required="required" 
                min='1' max='1000' step='1' style='width: 5%;'>
  
       
      <button type="submit" id='submit'>저장</button>
      <button type="button" onclick="location.href='./list.do'">취소</button>
    </FORM>
  </DIV>
 
  
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
    <TH class="th_bs">플레이 리스트 번호</TH>
    <TH class="th_bs">플레이 리스트 이름</TH>
    <TH class="th_bs">수록된 음악 수</TH>
    <TH class="th_bs">회원 번호</TH>
    <TH class="th_bs">좋아요 수</TH>
    <TH class="th_bs">기타</TH>
  </TR>
  </thead>
  
  <tbody>
  <c:forEach var="playlistVO" items="${list}">
    <c:set var="playlistno" value="${playlistVO.playlistno }" />
    <TR>
      <TD class="td_bs">${playlistVO.playlistno }</TD>
      <TD class="td_bs">${playlistVO.playlistname }</TD>
      <TD class="td_bs">${playlistVO.cntmusic }</TD>
      <TD class="td_bs">${playlistVO.memberno }</TD>
      <TD class="td_bs">${playlistVO.likes }</TD>
      
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
 
 
 