<%@ page contentType="text/html; charset=UTF-8" %>
 
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

<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
 
<script type="text/JavaScript">
  // window.onload=function(){
  //  CKEDITOR.replace('content');  // <TEXTAREA>태그 id 값
  // };

  $(function() {

  });
 
</script>

</head> 
 
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
  <DIV class="title_line">
    FAQ
  </DIV>
  
 
  <div class='menu_line'></div>
  
  <DIV style='width: 100%;'>
    <FORM name='frm' method='POST' action='./create.do' class="form-horizontal"
                >
               
 <!-- FK adminno 지정 -->
      <input type='hidden' name='adminno' id='adminno' value='${sessionScope.adminno }'>
           
      <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='faqtitle' value='제목을 입력하세요' placeholder="제목" required="required" style='width: 80%;'>
        </div>
      </div>   
      
      <div class="form-group">   
        <div class="col-md-12">
          <textarea class="form-control" name='faqcontent' id='faqcontent' rows='10' placeholder="내용">내용을 입력하세요</textarea>
        </div>
      </div>
      
            <div class="form-group">   
        <div class="col-md-12">
          <input type='text' class="form-control" name='faqword'  value='전체 <- 컬럼 꼭넣어야함' placeholder="검색어" style='width: 90%;'>
        </div>
      </div>
      
            <div class="form-group">   
        <div class="col-md-12">
          <input type='password' class="form-control" name='adminpass'  value='1234' placeholder="패스워드" style='width: 20%;'>
        </div>
      </div>
      
      <DIV class='content_bottom_menu'>
        <button type="submit" class="btn btn-info">등록</button>
         <button type="button" onclick="location.href='./list.do'" class="btn btn-primary">목록</button>
      </DIV>
      
      
       
    </FORM>
  </DIV>

  
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
 
</html>
 
  