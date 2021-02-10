<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>team1. Project</title>

<link href="../css/style.css" rel="Stylesheet" type="text/css">

<link href="../css/style.css" rel="Stylesheet" type="text/css">
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
  $(function(){
 
  });
</script>
 
</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
 
<DIV class='title_line'>음악 수정</DIV>
 
<FORM name='frm' method='POST' action='./update.do' class="form-horizontal">
  <input type='hidden' name='singerno' value='1'>
  <input type='hidden' name='albumno' value='1'> 
  <input type='hidden' name='genreno' value='1'>
  <input type='hidden' name='genre' value='발라드'>
  
  <div class="form-group">
     <label class="control-label col-md-3">곡 제목</label>
     <div class="col-md-9">
       <input type='text' name='title' value='${musicVO.title}' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div> 
    
  <div class="form-group">
     <label class="control-label col-md-3">가수</label>
     <div class="col-md-9">
       <input type='text' name='singer' value='${musicVO.singer}' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div>
  
  <div class="form-group">
     <label class="control-label col-md-3">앨범명</label>
     <div class="col-md-9">
       <input type='text' name='album' value='${musicVO.album}' required="required" 
                 autofocus="autofocus" class="form-control" style='width: 30%;'>
     </div>
  </div>
  
  
  <div class="form-group">
        
          
        <div class="col-md-9">
        <fieldset>
          <legend class="form">장르 선택</legend>
          <label class="check_box">
            <input type="checkbox" name='list_genre' value='1' checked="checked"> 발라드
          </label><br>
        
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre2' value='2'> 락
          </label><br>
              
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre3' value='3'> 메탈
          </label><br> 
             
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre4' value='4'> 댄스
          </label><br> 
          
          <label style="cursor: pointer;">
            <input type="checkbox" name='genre4' value='5'> 힙합
          </label><br> 
        </fieldset>
      </div>
  </div>

  
  
  

  <div class="content_bottom_menu" style="padding-right: 20%;">
    <button type="submit" class="btn btn-primary">수정</button>
    <button type="button" onclick="location.href='./list.do'" class="btn btn-primary">목록(돌아가기)</button>
  </div>

</FORM>
 
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>
