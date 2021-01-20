<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>team1. Project</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class='title_line'>
    ${singerVO.singer } 
  </DIV>

  <ASIDE class="aside_left">
    <A href=''>가수 정보</A> >  수정
  </ASIDE>
  <ASIDE class="aside_right">
    <A href='./list.do'>목록</A>
    <!-- <span class='menu_divide' >│</span> --> 
  </ASIDE> 
 
  <div class='menu_line'></div>
  
  <DIV style='width: 100%;'>
    <FORM name='frm' method='POST' action='./update.do' class="form-horizontal">
      <!-- FK memberno 지정 -->
      <!-- <input type='hidden' name='memberno' id='memberno' value='1'> -->
      <!-- FK categrpno 지정 -->
      <!-- <input type='hidden' name='cateno' id='cateno' value='1'> -->
      
      <input type='hidden' name='singerno' id='singerno' value='${singerVO.singerno }'>
      
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='singer' value='${singerVO.singer }' placeholder="singer" required="required" style='width: 50%;'>
        </div>
      </div>   
      
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='agency' value='${singerVO.agency }'  placeholder="소속사" style='width: 50%;'>
        </div>
      </div>

      <div class="form-group">   
        <div class="col-md-12">
          <input type="number" class="form-control" name='age' value='${singerVO.age }' placeholder="나이" style='width: 50%;'>
        </div>
      </div>   
      
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='sex'  value='${singerVO.sex }' placeholder="성별" style='width: 50%;'>
        </div>
      </div>

      <DIV class='content_bottom_menu'>
        <button type="submit" class="btn btn-info">수정</button>
        <button type="button" 
                    onclick="location.href='./list.do?categrpno=${param.singerno}'" 
                    class="btn btn-info">취소[목록]</button>
      </DIV>
       
    </FORM>
  </DIV>

  
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>