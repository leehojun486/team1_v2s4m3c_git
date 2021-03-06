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
 
  <DIV class='title_line'> ${playlistVO.playlistname } 삭제</DIV>
 
  <DIV id='panel_delete' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
    <div class="msg_warning">플레이리스트를 삭제하면 복구 할 수 없습니다.</div>
    <FORM name='frm_delete' id='frm_delete' method='POST' action='./user_delete.do'>
      <input type='hidden' name='playlistno' id='playlistno' value='${playlistVO.playlistno }'>
      <input type='hidden' name='memberno' id='memberno' value='${playlistVO.memberno }'>
        
      <label>플레이리스트 이름</label>: ${playlistVO.playlistname } &nbsp;
      <label>수록된 곡 수</label>: ${playlistVO.cntmusic } &nbsp; 
      <label>좋아요 수</label>: ${playlistVO.likes } &nbsp;
       
      <button type="submit" id='submit'>삭제</button>
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
    <TH class="th_bs">좋아요 수</TH>
    <TH class="th_bs">기타</TH>
  </TR>
  </thead>
  
  <tbody>
  <c:forEach var="playlistVO" items="${list}">
    <c:set var="playlistno" value="${playlistVO.playlistno }" />
    <TR>
      <TD class="td_bs">${playlistVO.playlistno }</TD>
      <TD class="td_bs"><a href="../music_playlist/list.do?playlistno=${playlistno}">${playlistVO.playlistname }</a></TD>
      <TD class="td_bs"><a href="../playlist/likes_up.do?playlistno=${playlistno }">${playlistVO.likes }</a></TD>
      
      <TD class="td_bs">
        <A href="./user_read_update.do?playlistno=${playlistno }&memberno=${param.memberno }" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
        <A href="./user_read_delete.do?playlistno=${playlistno }&memberno=${param.memberno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
      </TD>   
    </TR>   
  </c:forEach> 
  </tbody>
</TABLE>
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 