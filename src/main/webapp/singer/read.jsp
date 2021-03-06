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
<c:set var="singerno" value="${singerVO.singerno}" />
<c:set var="musicno" value="${musicVO.musicno}" />
<%-- <c:set var="contentsno" value="${contentsVO.contentsno }" /> --%>

<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class='title_line'>
    가수 조회
  </DIV>
  
  <ASIDE class="aside_left">
    조회 > ${singerVO.name }
  </ASIDE>
  <ASIDE class="aside_right">
    <A href="./create.do">글 등록</A>
    
    <c:choose>
      <c:when test="${singerVO.portrait.trim().length() > 0 }">
        <span class='menu_divide' > | </span> 
        <A href='./img_update.do?singerno=${singerno }'>메인 이미지 변경/삭제</A>     
      </c:when>
      <c:otherwise>
        <span class='menu_divide' > | </span> 
        <A href='./img_create.do?singerno=${singerno }'>메인 이미지 등록</A>     
      </c:otherwise>
    </c:choose>
    <span class='menu_divide' > | </span>
    <A href="javascript:location.reload();">새로고침</A>
    <span class='menu_divide' > | </span> 
    <A href='./list.do'>목록</A>
    <span class='menu_divide' > | </span> 
    <A href='./update.do?singerno=${singerno }'>수정</A>
    <span class='menu_divide' > | </span> 
    <A href='./delete.do?singerno=${singerno }'>삭제</A>
    
  </ASIDE>
  
  <div class='menu_line'></div>

  <FORM name='frm' method="get" action='./update.do'>
      <input type="hidden" name="singerno" value="${param.singerno}">
      
      <fieldset class="fieldset_singer">
        <table class="img_center">
          <tr>
            <td>
              <c:set var="portrait" value="${singerVO.portrait }" />
              <c:if test="${portrait.endsWith('jpg') || portrait.endsWith('png') || portrait.endsWith('gif')}">
                <DIV class="img_center">
                  <IMG src="./storage/main_images/${portrait }" style="width: 50%;"> 
                </DIV>
              </c:if>
            </td>
          </tr>
          <tr>
            <td>
              <div class="singer_name">
                ${singerVO.name }
              </div>
              <div class="singer_country">
                ${singerVO.genre }
              </div>
              <div class="singer_country">
                ${singerVO.sex } / ${singerVO.country }
              </div>
              <div class="singer_line"></div>
              <div style="text-align: left; font-size: 1.1em; font-weight: bold; margin-bottom:20px;">
                소개
              </div>
              <div>
                ${singerVO.intro }
              </div>
              <div style="margin-top:20px; text-align: center;">
                <A href="./update_singerrec_up.do?singerno=${singerno }" title="좋아요"><span class="glyphicon glyphicon-heart"></span></A>
                 ${singerVO.singerrec}
              </div>
            </td>
          </tr>
        </table>
      </fieldset>
  </FORM>

<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>

</html>