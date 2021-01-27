<%@ page contentType="text/html; charset=UTF-8"%>
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
 
</head>
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class="title_line">
    FAQ
  </DIV>

  <ASIDE class="aside_left">
     FAQ 등록현황 >
  </ASIDE>
    <c:if test="${sessionScope.adminid != null  or sessionScope.adminid != null }">
      <A href="./create.do">등록</A>
      <span class='menu_divide' >│</span>
    </c:if>  
    <A href="javascript:location.reload();">새로고침</A>
  
  <DIV style="text-align: right;">  
    <form name='frm' id='frm' method='get' action='./list_all.do'>
      <input type='hidden' name='faqno' value='${faqVO.faqno }'>
      <br>
      <c:choose>
        <c:when test="${param.faqword != '' }"> <%-- 검색하는 경우 --%>
          <input type='text' name='faqword' id='faqword' value='${param.faqword }' 
                     style='width: 20%;'>
        </c:when>
        <c:otherwise> <%-- 검색하지 않는 경우 --%>
          <input type='text' name='faqword' id='faqword' value='' style='width: 20%;'>
        </c:otherwise>
      </c:choose>
      <button type='submit'>검색</button>
      <c:if test="${param.faqword.length() > 0 }">
        <button type='button' 
                     onclick="location.href='./list.do?faqword='">검색 취소</button>  
      </c:if>    
    </form>
  </DIV>
      
  <DIV class='menu_line'></DIV>

   
  <div style='width: 100%;'>
    <table class="table table-striped" style='width: 100%;'>
      <colgroup>
        <col style="width: 35%;"></col>
        <col style="width: 35%;"></col>
        <col style="width: 30%;"></col>
      </colgroup>
      <%-- table 컬럼 --%>
      <thead>
        <tr>
          <th style='text-align: center;'>등록일</th>
          <th style='text-align: center;'>제목</th>
          <th style='text-align: center;'>회원</th>
        </tr>
      
      </thead>
      
      <%-- table 내용 --%>
      <tbody>
        <c:forEach var="faq_AdminVO" items="${list }">
          <c:set var="faqtitle" value="${faq_AdminVO.faqtitle }" />
          <c:set var="faqno" value="${faq_AdminVO.faqno }" />
          <c:set var="aid" value="${faq_AdminVO.aid }" />
          <c:set var="faqrdate" value="${faq_AdminVO.faqrdate }" />
                    
          <tr> 
            <td style='vertical-align: middle; text-align: center;'>${faqrdate.substring(0, 10)}</td>
            <td style='vertical-align: middle;'>
            
              <a href="./read.do?faqno=${faqno}&faqword=${param.faqword }&nowPage=${param.nowPage}">${faqtitle}</a> 
            </td> 
            <td style='vertical-align: middle; text-align: center;'>${aid}</td>
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    <DIV class='bottom_menu'>${paging }</DIV>
  </div>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>


