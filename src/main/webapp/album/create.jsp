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
    <A href='./list.do'>앨범</A> > 
    신규 등록
  </ASIDE>
  <ASIDE class="aside_right">
    <A href='./list.do'>목록</A>
    <!-- <span class='menu_divide' >│</span> --> 
  </ASIDE> 
 
  <div class='menu_line'></div>
  <DIV style='width: 100%;'>
    <FORM name='frm' method='POST' action='./create.do' class="form-horizontal">
      <!-- FK genre 지정 -->  
      <%--<input type='hidden' name='genreno' id='genreno' value='${genreVO.genreno} '> --%>
       
           <!-- @@@@ -->
      <!-- FK categrpno 지정 -->
      <!-- <input type='hidden' name='cateno' id='cateno' value='1'> -->    
      앨범 제목  
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='title' value='앨범 제목' placeholder="앨범 제목" required="required" style='width: 50%;'>
        </div>
      </div>  
      아티스트
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='artist' value='아티스트' placeholder="아티스트" required="required" style='width: 50%;'>
        </div>
      </div>  
      장르
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='genre' value='장르' placeholder="장르" required="required" style='width: 50%;'>
        </div>
      </div> 
      장르 번호
      <div class="form-group">   
        <div class="col-md-12">
          <input type='number' class="form-control" name='genreno' value='' placeholder="장르 번호" required="required" style='width: 50%;'>
        </div>
      </div> 
      수록곡 번호
      <div class="form-group">   
        <div class="col-md-12">
          <input type='number' class="form-control" name='listno' value=1 placeholder="수록곡 번호" required="required" style='width: 50%;'>
        </div>
      </div> 
      노래 제목
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='musictitle' value='노래 제목' placeholder="노래 제목" required="required" style='width: 50%;'>
        </div>
      </div> 
      

      
      <DIV class='content_bottom_menu'>
        <button type="submit" class="btn btn-info">등록</button>
        <button type="button" 
                    onclick="location.href='./list.do'" 
                    class="btn btn-info">취소[목록]</button>
      </DIV>
       
    </FORM>
  </DIV>

  
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>
 