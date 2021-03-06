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
 
  <DIV class='title_line'>Playlist</DIV>
  <A href='./create.do?&memberno=${memberno }'>등록</a> 
  
<TABLE class="fieldset_singer">
  <colgroup>
    <col style='width: 40%;'/>
    <col style='width: 40%;'/>
    <col style='width: 20%;'/>
  </colgroup>
 
  <thead>  
  <TR>
    <TH class="th_bs">썸네일</TH>
    <TH class="th_bs">플레이 리스트 이름</TH>
    <TH class="th_bs">기타</TH>
  </TR>
  </thead>
  
  <tbody>
  <c:forEach var="playlistVO" items="${list}">
    <c:set var="playlistno" value="${playlistVO.playlistno }" />
    <TR>
      <td>
        <c:if test="${playlistVO.thumbnail.endsWith('jpg') || playlistVO.thumbnail.endsWith('png') || playlistVO.thumbnail.endsWith('gif')}">
            <DIV class="img_center">
               <IMG src="./storage/main_images/${playlistVO.thumbnail }" style="width: 50%;"> 
            </DIV>
        </c:if>
      </td>
      <TD class="td_bs"><a href="../music_playlist/list.do?playlistno=${playlistno}">${playlistVO.playlistname }</a></TD>
      <TD class="td_bs">
        <A href="./user_read_update.do?playlistno=${playlistno }&memberno=${memberno }" title="수정"><span class="glyphicon glyphicon-pencil"></span></A>
        <A href="./user_read_delete.do?playlistno=${playlistno }&memberno=${memberno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></A>
      </TD>   
    </TR>   
  </c:forEach> 
  </tbody>
</TABLE>
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 