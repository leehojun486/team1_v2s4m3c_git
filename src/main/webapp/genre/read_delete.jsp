<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Music</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
  <link href="../css/menu.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
 
  
</script>
 
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" />
 
  <DIV class='title_line'><A href="../home/list.do">메뉴</A> > ${genreVO.genrename } 삭제</DIV>
 
  <DIV id='panel_delete' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
    <div class="msg_warning">카테고리 그룹을 삭제하면 복구 할 수 없습니다.</div>
    <FORM name='frm_delete' id='frm_delete' method='POST' action='./delete.do'>
      <input type='hidden' name='genreno' id='genreno' value='${genreVO.genreno }'>
        <input type='hidden' name='homeno' id='homeno' value="${param.homeno }">
        
        <label>메뉴 번호</label>: ${genreVO.homeno } &nbsp;
      <label>순서</label>: ${genreVO.seqno } &nbsp;
      <label>장르</label>: ${genreVO.genrename } &nbsp; 
       
      <button type="submit" id='submit'>삭제</button>
        <button type="button" onclick="location.href='./list.do?homeno=${param.homeno}'">취소</button>
    </FORM>
  </DIV>
   
 
  <TABLE class='table table-striped'>
    <colgroup>
      <col style='width: 25%;'/>
      <col style="width: 15%;"/>
      <col style='width: 15%;'/>
      <col style='width: 15%;'/>  
      <col style='width: 15%;'/>
    </colgroup>
   
    <thead>  
    <TR>
      <TH class="th_bs">그룹</TH>
      <TH class="th_bs">순서</TH>
      <TH class="th_bs">장르</TH>
      <TH class="th_bs">등록일</TH>
      <TH class="th_bs">기타</TH>
    </TR>
    </thead>
    
    <tbody>
    <c:forEach var="genreVO" items="${list }">  <!-- request 객체에 접근 -->
      <c:set var="genreno" value="${genreVO.genreno}" />
      <TR>
        <TD class="td_bs">${genreVO.homeno }-${genreVO.genreno }</TD>
        <TD class="td_bs">${genreVO.seqno }</TD>
        <TD class="td_bs_left"><A href="./read_update.do?genreno=${genreno }">${genreVO.genrename }</A></TD>
        <TD class="td_bs">${genreVO.rdate.substring(0, 10) }</TD>
        <TD class="td_bs">
        </TD>
        <TD class="td_bs">
          <A href="./read_update.do?genreno=${genreno }"><span class="glyphicon glyphicon-pencil"></span></A>
          <A href="./read_delete.do?genreno=${genreno }"><span class="glyphicon glyphicon-trash"></span></A>
        
        </TD>             
      </TR>
    </c:forEach>
    </tbody>
   
  </TABLE>
 
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 