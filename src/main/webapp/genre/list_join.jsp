<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Music world</title>
 
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
 
  <DIV class='title_line'>카테고리 그룹</DIV>
 
  <DIV id='panel_create' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
    <FORM name='frm_create' id='frm_create' method='POST' action='./create.do'>
      <!-- <input type='hidden' name='lang' id='lang' value='en'> --> <!-- ko, en -->
        
       <label>메뉴 번호</label>
      <input type='number' name='homeno' value="${homeVO.homeno }" required="required" 
                min="1" max="99999" step="1" style='width: 5%;'>
         
      <label>순서</label>
      <input type='number' name='seqno' value='1' required="required" 
                min='1' max='1000' step='1' style='width: 5%;'>
                
     <label>장르</label>
      <select name='genrename'>
      <option value='힙합' selected="selected">힙합</option>
          <option value='발라드'>발라드</option>
          <option value='재스'>재즈</option>
          <option value='팝'>팝</option>
          <option value='BGM'>BGM</option>
      </select>
       
       
      <button type="submit" id='submit'>등록</button>
      <button type="button" onclick="cancel();">취소</button>
    </FORM>
  </DIV>
 
  
<TABLE class='table table-striped'>
    <colgroup>
      <col style='width: 5%;'/>
      <col style="width: 10%;"/>
      <col style='width: 20%;'/>
      <col style='width: 20%;'/>  
      <col style='width: 20%;'/>
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
    <c:forEach var="home_Genre_join" items="${list }">  <!-- request 객체에 접근 -->
    <c:set var="homeno" value="${home_Genre_join.homeno}" />
    <c:set var="home_name" value="${home_Genre_join.r_name}" />
    <c:set var="homeno" value="${home_Genre_join.homeno}" />
    <c:set var="seqno" value="${home_Genre_join.seqno}" />
    <c:set var="genrename" value="${home_Genre_join.genrename}" />
    <c:set var="rdate" value="${home_Genre_join.rdate}" />

      <TR>
        <TD class="td_bs">${home_name}
        <TD class="td_bs">${seqno }</TD>
        <TD class="td_bs_left"><A href="../music/list.do?genrename=${genrename }">${genrename }</A></TD>
        <TD class="td_bs">${rdate.substring(0, 10) }</TD>
        <TD class="td_bs">
        </TD>
        <TD class="td_bs">
          <A href="./read_update.do?genrename=${genrename }&homeno=${homeno}"><span class="glyphicon glyphicon-pencil"></span></A>
          <A href="./read_delete.do?genrename=${genrename }&homeno=${homeno}"><span class="glyphicon glyphicon-trash"></span></A>
        
        </TD>             
      </TR>
    </c:forEach>
    </tbody>
   
  </TABLE>
 
 
<jsp:include page="/menu/bottom.jsp" />
</body>
 
</html> 
 
 
 