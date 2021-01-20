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
  가수목록
  </DIV>
  <ASIDE class="aside_left">
    
  </ASIDE>
  <ASIDE class="aside_right">
    <A href="./create.do">등록</A>
     <span class='menu_divide' >│</span>
     <A href="javascript:location.reload();">새로고침</A>
  </ASIDE> 
  <DIV class='menu_line'></DIV>
  
  <c:forEach var="singerVO" items="${list }">
          <c:set var="singerno" value="${singerVO.singerno }" />
          <c:set var="thumb1" value="${singerVO.thumb1 }" />
          <DIV style='width: 100%;'>
            <table style='width: 100%'>
              <colgroup>
                <col width="8.5%" />
                <col width="*" />
              </colgroup>
              <tr>
                <td style='vertical-align: top; text-align: left;' rowspan="4">
                  <c:choose>
                    <c:when test="${thumb1.endsWith('jpg') || thumb1.endsWith('png') || thumb1.endsWith('gif')}">
                      <IMG src="./storage/main_images/${thumb1}" style="width: 80px; height: 80px; margin-right: 10px;"> 
                    </c:when>
                    <c:otherwise> <!-- 이미지가 아닌 일반 파일 -->
                      ${singerVO.portrait}
                    </c:otherwise>
                  </c:choose>
                </td>
              </tr>
              <tr>
                <td><span class='review_membername'>
                  <A href="../singer/read.do?singerno=${singerVO.singerno}">${singerVO.name}</A></span>
                  <span class='review_rdate'>${singerVO.country} / ${singerVO.sex } / ${singerVO.genre }</span>
                </td>
              </tr>
              <tr>
                <td><div class='review_content'>${singerVO.intro}</div></td>
              </tr>
              <tr>
              <td><span class='review_recommend'>
                <span class="glyphicon glyphicon-heart"></span>
                ${singerVO.singerrec}</span>
              </td>
            </tr>
            </table>
            <div class='review_line'></div>
          </DIV>
        </c:forEach>
        
  
  
  
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>

