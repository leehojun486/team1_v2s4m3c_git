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

</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class='title_line'>
  FAQ
  </DIV>

  <ASIDE class="aside_left">
     NULL
  </ASIDE>
  <ASIDE class="aside_right">
    <A href='./list_all.do?faqno=${param.faqno }'>목록</A>
    <!-- <span class='menu_divide' >│</span> --> 
  </ASIDE> 
  
  <div class='menu_line'></div>
 
  <FORM name='frm' method='POST' action='./delete.do'>
      <input type='hidden' name='faqno' value='${param.faqno}'>
      <input type="hidden" name="nowPage" value="${param.nowPage }">
      
      <DIV id='panel1' style="width: 40%; text-align: center; margin: 10px auto;"></DIV>
            
      <div class="form-group">   
        <div class="col-md-12" style='text-align: center; margin: 10px auto;'>
          삭제 되는글: ${faqVO.faqtitle }<br><br>
          삭제하시겠습니까? 삭제하시면 복구 할 수 없습니다.<br><br>
          
        <div class="form-group">   
        <div class="col-md-12" style='text-align: center; margin: 10px auto;'>
          <input type='password' class="form-control" name='adminpass'  value='' placeholder="패스워드" style='width: 20%; margin: 0px auto;'>
        </div>
      </div>
          
          <button type = "submit" class="btn btn-info">삭제 진행</button>
          <button type = "button" onclick = "history.back()" class="btn btn-info">취소</button>
        </div>
      </div>   
  </FORM>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>
  
  