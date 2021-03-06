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
  <DIV class="title_line">
    team1. Project // 
  </DIV>
  
  <ASIDE class="aside_left">
    <A href='./list.do'>가수</A> > 
    신규 등록
  </ASIDE>
  <ASIDE class="aside_right">
    <A href='./list.do'>목록</A>
    <!-- <span class='menu_divide' >│</span> --> 
  </ASIDE> 
 
  <div class='menu_line'></div>
  <DIV style='width: 100%;'>
    <FORM name='frm' method='POST' action='./create.do' class="form-horizontal"
                enctype="multipart/form-data">      
    <!-- <input type='hidden' name='singerno' id='singerno' value='1'> -->
    
    <div class="form-group">   
        <div class="col-md-12">
          <%-- 실제 컬럼명: portrait, Spring File 객체 대응: portraitMF --%>
          <input type='file' class="form-control" name='portraitMF' id='portraitMF' 
                    value='' placeholder="이미지선택" multiple="multiple">
        </div>
      </div>
    
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='name' id='name' value='' placeholder="이름" required="required" style='width: 50%;'>
        </div>
      </div>
      
      <div class="form-group">
        <div class="col-md-12">
          <select name='sex' class="form-control" id='sex' style='width: 30%;'>
            <option value='남성' selected="selected">남성</option>
            <option value='여성'>여성</option>
            <option value='혼성'>혼성</option>
         </select>
        </div>
      </div>
      
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='country' id='country' value='' placeholder="국적" style='width: 50%;'>
        </div>
      </div>
      
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='genre' id='genre' value='' placeholder="장르" style='width: 50%;'>
        </div>
      </div>
      
      <div class="form-group">   
        <div class="col-md-12">
          <textarea class="form-control" name='intro' id='intro' rows='6' placeholder="소개"></textarea>
        </div>
      </div>
      
      <DIV class='content_bottom_menu'>
        <button type="submit" class="btn btn-info">가수등록</button>
        <button type="button" 
                    onclick="location.href='./list.do'" 
                    class="btn btn-info">취소[목록]</button>
      </DIV>
       
    </FORM>
  </DIV>

  
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>
 