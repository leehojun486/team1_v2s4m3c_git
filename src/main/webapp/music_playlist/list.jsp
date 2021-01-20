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
 
  <DIV class='title_line'><a href="../playlist/list.do">music_playlist </a> ▶ ${playlistVO.playlistname }
  <p style="margin-left: 95%;"><a href="../music_playlist/create.do?playlistno=${playlistVO.playlistno}" >등록</a></p>
  </DIV>
  <p>수록된 음악 수:${cnt_music} </p>
  
 
  
 
  
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
    <TH class="th_bs">재생 음악 번호</TH>
    <TH class="th_bs">재생 순서</TH>
    <TH class="th_bs">음악 번호</TH>
    <TH class="th_bs">기타</TH>
    
  </TR>
  </thead>
  
  <tbody>
  <c:forEach var="music_PlaylistVO" items="${list}">
    <c:set var="music_playlistno" value="${music_PlaylistVO.music_playlistno }" />
    <TR>
      <TD class="td_bs">${music_PlaylistVO.music_playlistno }</TD>
      <TD class="td_bs">${music_PlaylistVO.playing_seq }</TD>
      <TD class="td_bs">${music_PlaylistVO.musicno }</TD>
      
      <TD class="td_bs">
        <A href="./read_update.do?music_playlistno=${music_playlistno }" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
        <A href="./read_delete.do?music_playlistno=${music_playlistno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
      </TD>   
    </TR>   
  </c:forEach> 
  </tbody>
 
</TABLE>
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 