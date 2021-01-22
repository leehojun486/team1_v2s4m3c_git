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
 
  <DIV class='title_line'>재생 목록 > ${music_PlaylistVO.music_playlistno } 조회(수정)</DIV>
 
  <DIV id='panel_create' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
    <FORM name='frm_update' id='frm_update' method='POST' action='./update.do'>
      <input type='hidden' name='music_playlistno' id='music_playlistno' value='${music_PlaylistVO.music_playlistno }'>
        
      <label>플레이 리스트 번호</label>
      <input type='number' name='playlistno' value='${music_PlaylistVO.playlistno }' required="required" 
                min='1' max='1000' step='1' style='width: 5%;'>
                
      <label>재생 순서</label>
      <input type='number' name='playing_seq' value='${music_PlaylistVO.playing_seq} ' required="required" 
                min='1' max='1000' step='1' style='width: 5%;'>
                
      <label>음악 번호</label>
      <input type='number' name='musicno' value='${music_PlaylistVO.musicno} ' required="required" 
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
    <TH class="th_bs">재생 음악 번호</TH>
    <TH class="th_bs">플레이 리스트 번호</TH>
    <TH class="th_bs">재생 순서</TH>
    <TH class="th_bs">음악 번호</TH>
    <TH class="th_bs">기타</TH>
  </TR>
  </thead>
  
  <tbody>
  <c:set var="test" value="${music_PlaylistVO.playlistno }" />
  <c:forEach var="music_PlaylistVO" items="${list}">
  <c:choose>
    <c:when test="${music_PlaylistVO.playlistno == test}">
      <c:set var="music_playlistno" value="${music_PlaylistVO.music_playlistno }" />
    
      <TR>
        <TD class="td_bs">${music_PlaylistVO.music_playlistno }</TD>
        <TD class="td_bs">${music_PlaylistVO.playlistno }</TD>
        <TD class="td_bs">${music_PlaylistVO.playing_seq }</TD>
        <TD class="td_bs">${music_PlaylistVO.musicno }</TD>
      
        <TD class="td_bs">
          <A href="./read_update.do?music_playlistno=${music_playlistno }" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
          <A href="./read_delete.do?music_playlistno=${music_playlistno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
        </TD>   
      </TR>
    </c:when>
  </c:choose>
  
       
  </c:forEach> 
  </tbody>
 
</TABLE>
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 