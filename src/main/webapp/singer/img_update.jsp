<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class="title_line">
  『${singerVO.name}』 메인 이미지 변경 및 삭제
  </DIV>
  <ASIDE class="aside_left">
    <A href="../singer/list.do">가수목록</A> > 
    <A href="./read.do?singerno=${singerVO.singerno}">${singerVO.name }</A>
  </ASIDE>
 
  <div class='menu_line'></div>
  <DIV style='width: 100%;'>
  <%-- 이미지가 존재하는 경우 이미지를 출력하고 삭제 버튼 --%>
  <c:set var="portrait" value="${singerVO.portrait }" />
  <c:if test="${portrait.endsWith('jpg') || portrait.endsWith('png') || portrait.endsWith('gif')}">
    <H3>등록된 메인 이미지 삭제</H3>
    <div style="width: 50%; float: left; margin-right: 10px;">
      <IMG src="./storage/main_images/${portrait }" style="width: 100%;"> 
    </div>
    
    <FORM name='frm' method='POST' action='./img_delete.do' class="form-horizontal">
      <!-- FK memberno 지정 -->
      <input type='hidden' name='singerno' id='singerno' value='${singerVO.singerno }'>
      
      <div class="form-group">   
        <div class="col-md-12">
          <button type="submit" class="btn btn-info">메인 이미지 삭제</button>
          <button type="button" 
                       onclick="location.href='./read.do?singerno=${param.singerno}'" 
                       class="btn btn-info">취소[조회]</button>
        </div>
      </div>
    </FORM>
   </c:if>
   
   <H3>등록된 메인 이미지 변경</H3>
  <%-- 이미지가 존재하는 경우 새로운 이미지 등록 폼 출력 --%>
    <FORM name='frm' method='POST' action='./img_update.do' class="form-horizontal"
                 enctype="multipart/form-data">
               
      <!-- FK memberno 지정 -->
      <input type='hidden' name='singerno' id='singerno' value='${singerVO.singerno }'>

      <div class="form-group">   
        <div class="col-md-12">
          <%-- 실제 컬럼명: fiel1, Spring File 객체 대응: fiel1MF --%>
          <input type='file' class="form-control" name='portraitMF' id='portraitMF' 
                    value='' placeholder="파일 선택" multiple="multiple">
        </div>
      </div>

      <div class="form-group">   
        <div class="col-md-12">
          <button type="submit" class="btn btn-info">새로운 메인 이미지 등록</button>
          <button type="button" 
                       onclick="location.href='./read.do?singerno=${param.singerno}'" 
                       class="btn btn-info">취소[조회]</button>
        </div>
      </div>
       
    </FORM>
  </DIV>

  
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>